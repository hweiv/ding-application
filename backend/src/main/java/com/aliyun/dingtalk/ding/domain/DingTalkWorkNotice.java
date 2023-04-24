package com.aliyun.dingtalk.ding.domain;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dingtalk.common.CommonConstants;
import com.aliyun.dingtalk.util.RedisCacheUtil;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
/**
 * DingTalkWorkNotice.java此类用于钉钉自定义机器人
 *
 * @author:hjm
 * @date:2021年4月7日
 * @remark:
 */
@Slf4j
@Component
public class DingTalkWorkNotice {
    /**
     * 缓存时间：一小时50分钟
     */
    private static final long CACHE_TTL = 60 * 55 * 2 * 1000;
    @Resource
    private DingTalkParams dingTalkParams;
    @Resource
    private RedisCacheUtil cacheUtil;
    private final String IS_OPEN = "true";
    private final String MSG_TYPE_OA = "oa";
    private final String MSG_TYPE_LINK = "link";
    private final String MSG_TYPE_ACTION_CARD = "action_card";
    /**
     * 向钉钉发送消息
     *
     * @param dingTalkMsg 实例对象
     */
    public void sendDingMsg(DingTalkMsg dingTalkMsg) {
        String msgType = dingTalkMsg.getMsgType();
        String title = dingTalkMsg.getTitle();
        String content = dingTalkMsg.getContent();
        String userList = dingTalkMsg.getUserList();
        String url = dingTalkMsg.getUrl();
        List<OapiMessageCorpconversationAsyncsendV2Request.Form> fromList = dingTalkMsg.getFromList();
        String author = dingTalkMsg.getAuthor();
        DingTalkClient client = new DefaultDingTalkClient(DingTalkUrlConstants.URL_SEND_WORK_NOTICE);
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setAgentId(dingTalkParams.getAgentId());
        request.setUseridList(userList);
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        // 消息类型
        switch (msgType) {
            case MSG_TYPE_OA: // OA类型
                msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
                msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
                msg.getOa().getHead().setText("head");
                msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
                msg.getOa().getBody().setTitle(title);
                msg.getOa().getBody().setContent(content);
                msg.getOa().getBody().setForm(fromList);
                msg.getOa().getBody().setAuthor(author);
                break;
            case MSG_TYPE_LINK:
                msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
                msg.getLink().setTitle(title);
                msg.getLink().setText(content);
                msg.getLink().setMessageUrl(url);
                msg.getLink().setPicUrl("test");
                break;
            case MSG_TYPE_ACTION_CARD:
                msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
                msg.getActionCard().setTitle(title);
                msg.getActionCard().setMarkdown(content);
                msg.getActionCard().setSingleTitle("查看详情");
                msg.getActionCard().setSingleUrl(url);
                break;
            default:
                break;
        }
        msg.setMsgtype(msgType);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response rsp;
        try {
            // 是否开启钉钉提醒
            if (StringUtils.equals(dingTalkParams.getIsOpen(), IS_OPEN)) {
                String accessToken = getAccessToken();
                rsp = client.execute(request, accessToken);
                log.info(rsp.getBody());
            }
        } catch (ApiException e) {
            log.error("发送钉钉工作通知异常：", e);
        }
    }
    /**
     * 在此方法中，为了避免频繁获取access_token，
     * 在距离上一次获取access_token时间在两个小时之内的情况，
     * 将直接从持久化存储中读取access_token
     * <p>
     * 因为access_token和jsapi_ticket的过期时间都是7200秒
     * 所以在获取access_token的同时也去获取了jsapi_ticket
     * 注：jsapi_ticket是在前端页面JSAPI做权限验证配置的时候需要使用的
     * 具体信息请查看开发者文档--权限验证配置
     *
     * @return accessToken 或错误信息
     */
    public String getAccessToken() throws ApiException {
        String redisKey = CommonConstants.DAILY_DING_ACCESS_TOKEN + dingTalkParams.getAppKey();
        // 从持久化存储中读取
        String accessToken = getFromCache(redisKey, "access_token");
        if (accessToken != null) {
            return accessToken;
        }
        DefaultDingTalkClient client = new DefaultDingTalkClient(DingTalkUrlConstants.URL_GET_TOKEN);
        OapiGettokenRequest request = new OapiGettokenRequest();
        OapiGettokenResponse response;
        request.setAppkey(dingTalkParams.getAppKey());
        request.setAppsecret(dingTalkParams.getAppSecret());
        request.setHttpMethod("GET");
        try {
            response = client.execute(request);
        } catch (ApiException e) {
            log.error("获取access_token失败异常：{}", e);
            throw e;
        }
        accessToken = response.getAccessToken();
        // 持久化accessToken
        putToCache(redisKey, "access_token", accessToken);
        return accessToken;
    }
    /**
     * 获取JSTicket, 用于js的签名计算
     * 正常的情况下，jsapi_ticket的有效期为7200秒，所以开发者需要在某个地方设计一个定时器，定期去更新jsapi_ticket
     *
     * @return jsTicket或错误信息
     */
    public String getJsTicket() throws ApiException {
        // 从持久化存储中读取
        String ticket = getFromCache("jsticket", "ticket");
        if (ticket != null) {
            return ticket;
        }
        String accessToken = getAccessToken();
        DefaultDingTalkClient client = new DefaultDingTalkClient(DingTalkUrlConstants.URL_GET_JSTICKET);
        OapiGetJsapiTicketRequest request = new OapiGetJsapiTicketRequest();
        OapiGetJsapiTicketResponse response;
        request.setHttpMethod("GET");
        try {
            response = client.execute(request, accessToken);
        } catch (ApiException e) {
            log.error("获取jsticket失败异常：{}", e);
            throw e;
        }
        ticket = response.getTicket();
        // 持久化jsticket
        putToCache("jsticket", "ticket", ticket);
        return ticket;
    }
    /**
     * 模拟从持久化存储中获取token并检查是否已过期
     *
     * @param section 存储key
     * @param field   token字段名
     * @return token值 或 null (过期或未查到)
     */
    private String getFromCache(String section, String field) {
        String beginTimeKey = "begin_time";
        String value = cacheUtil.getCacheObject(section);
        JSONObject o = JSONObject.parseObject(value);
        if (o != null && System.currentTimeMillis() - o.getLong(beginTimeKey) <= CACHE_TTL) {
            return o.getString(field);
        }
        return null;
    }
    private void putToCache(String section, String field, String value) {
        JSONObject fieldObj = new JSONObject(2);
        fieldObj.put(field, value);
        fieldObj.put("begin_time", System.currentTimeMillis());
        cacheUtil.setCacheObject(section, fieldObj.toJSONString());
    }
}