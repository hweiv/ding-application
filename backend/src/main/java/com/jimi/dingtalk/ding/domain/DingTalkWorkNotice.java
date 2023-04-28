package com.jimi.dingtalk.ding.domain;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.jimi.dingtalk.common.CommonConstants;
import com.jimi.dingtalk.constant.DingTalkMsgConstant;
//import com.jimi.dingtalk.util.RedisCacheUtil;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.jimi.dingtalk.constant.UrlConstant;
import com.jimi.dingtalk.model.DingAppInfo;
import com.jimi.dingtalk.util.DingAppConfigUtil;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
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
     * 缓存时间：两小时
     */
    private static final long CACHE_TTL = 60 * 60 * 2 * 1000;
//    @Resource
//    private DingTalkParams dingTalkParams;
//    @Resource
//    private RedisCacheUtil cacheUtil;

    /**
     * 向钉钉发送消息
     *
     * @param dingTalkMsg 实例对象
     */
    public Long sendDingMsg(DingTalkMsg dingTalkMsg) throws Exception{
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingTalkMsg.getDingAppCode());
        String accessToken = getAccessToken(dingAppInfo.getAppKey(), dingAppInfo.getAppSecret());
        String msgType = dingTalkMsg.getMsgType();
        String title = dingTalkMsg.getTitle();
        String content = dingTalkMsg.getContent();
//        String userList = dingTalkMsg.getUserList();
        String[] userArray = dingTalkMsg.getUserList().split(",");
        String userList = "";
        for (String s : userArray) {
            String mobile = getUserIdByMobile(accessToken, s);
            userList = mobile + ",";
        }
        String url = dingTalkMsg.getUrl();
        String mediaId = dingTalkMsg.getMediaId(); // 上传到钉钉之后的媒介id（图片，文件，音频等）
        List<OapiMessageCorpconversationAsyncsendV2Request.Form> fromList = dingTalkMsg.getFromList();
        String author = dingTalkMsg.getAuthor();
        DingTalkClient client = new DefaultDingTalkClient(DingTalkUrlConstants.URL_SEND_WORK_NOTICE);
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setAgentId(dingAppInfo.getAppAgentId());
        request.setUseridList(userList);
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        // 消息类型
        switch (msgType) {
            case DingTalkMsgConstant.MSG_TYPE_OA: // oa 类型通知
                msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
                // 设置头部
                msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
                msg.getOa().getHead().setText("head");
                // 设置消息体
                msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
                msg.getOa().getBody().setTitle(title); // 标题
                msg.getOa().getBody().setContent(content); // 内容
                msg.getOa().getBody().setForm(fromList); // 表单属性，最多六个
                msg.getOa().getBody().setAuthor(author); // 发送者
                msg.getOa().getBody().setFileCount(dingTalkMsg.getFileCount()); // 附件数，不验证是否正确
                msg.getOa().getBody().setRich(dingTalkMsg.getRich()); // 富文本：15.6元
                msg.getOa().getBody().setImage(mediaId); // 上传的图片
                msg.getOa().setMessageUrl(url); // 手机端跳转链接
                msg.getOa().setPcMessageUrl(dingTalkMsg.getPcMsgUrl()); // pc端跳转链接
                msg.getOa().setStatusBar(dingTalkMsg.getStatusBar()); // 状态节点
                break;
            case DingTalkMsgConstant.MSG_TYPE_LINK: // 链接类型通知
                msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
                msg.getLink().setTitle(title);
                msg.getLink().setText(content);
                msg.getLink().setMessageUrl(url);
                msg.getLink().setPicUrl(mediaId);
                break;
            case DingTalkMsgConstant.MSG_TYPE_ACTION_CARD: // 卡片类型通知
                msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
                msg.getActionCard().setTitle(title); // 标题
                msg.getActionCard().setMarkdown(content); // markdown格式的文本
                // 一个跳转链接
                msg.getActionCard().setSingleTitle(dingTalkMsg.getSingleTitle()); // 整体跳转链接的文字
                msg.getActionCard().setSingleUrl(url); // 整体跳转链接
                // 多个跳转链接
                msg.getActionCard().setBtnOrientation(dingTalkMsg.getBtnOrientation()); // 多个跳转链接按钮排列方向：0-横向；1-竖向
                msg.getActionCard().setBtnJsonList(dingTalkMsg.getBtnJsonList()); // 多个跳转链接按钮
                break;
            case DingTalkMsgConstant.MSG_TYPE_FILE: // 文件类型通知
                msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
                msg.getFile().setMediaId(mediaId);
                break;
            case DingTalkMsgConstant.MSG_TYPE_IMAGE: // 图片类型通知
                msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
                msg.getImage().setMediaId(mediaId);
                break;
            case DingTalkMsgConstant.MSG_TYPE_MARKDOWN: // markdown脚本文本类型通知
                msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
                msg.getMarkdown().setTitle(title);
                msg.getMarkdown().setText(content);
                break;
            case DingTalkMsgConstant.MSG_TYPE_TEXT: // 纯文本类型通知
                msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
                msg.getText().setContent(content);
                break;
            case DingTalkMsgConstant.MSG_TYPE_VOICE: // 语音类型通知
                msg.setVoice(new OapiMessageCorpconversationAsyncsendV2Request.Voice());
                msg.getVoice().setDuration(dingTalkMsg.getDuration()); // 语音时长（秒）
                msg.getVoice().setMediaId(mediaId);
            default:
                break;
        }
        msg.setMsgtype(msgType);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response rsp;
        try {
            // 执行钉钉提醒
            rsp = client.execute(request, accessToken);
            log.info(rsp.getBody());
            return rsp.getTaskId();
        } catch (ApiException e) {
            log.error("发送钉钉工作通知异常：", e);
            throw new Exception("发送通知异常");
        }
    }

    public String getUserIdByMobile(String accessToken, String mobile) throws Exception {
        DingTalkClient client2 = new DefaultDingTalkClient(UrlConstant.GET_USER_BY_MOBILE);
        OapiUserGetByMobileRequest req = new OapiUserGetByMobileRequest();
        req.setMobile(mobile);
        req.setHttpMethod("GET");
        OapiUserGetByMobileResponse rsp = client2.execute(req, accessToken);
        return rsp.getUserid();
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
    public String getAccessToken(String appKey, String appSecret) throws ApiException {
//        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        String redisKey = CommonConstants.DAILY_DING_ACCESS_TOKEN + appKey;
        // 从持久化存储中读取
//        String accessToken = getFromCache(redisKey, "access_token");
//        if (accessToken != null) {
//            return accessToken;
//        }
        DefaultDingTalkClient client = new DefaultDingTalkClient(DingTalkUrlConstants.URL_GET_TOKEN);
        OapiGettokenRequest request = new OapiGettokenRequest();
        OapiGettokenResponse response;
        request.setAppkey(appKey);
        request.setAppsecret(appSecret);
        request.setHttpMethod("GET");
        try {
            response = client.execute(request);
        } catch (ApiException e) {
            log.error("获取access_token失败异常：{}", e);
            throw e;
        }
        String accessToken = response.getAccessToken();
        // 持久化accessToken
//        putToCache(redisKey, "access_token", accessToken);
        return accessToken;
    }

    /**
     * 获取JSTicket, 用于js的签名计算
     * 正常的情况下，jsapi_ticket的有效期为7200秒，所以开发者需要在某个地方设计一个定时器，定期去更新jsapi_ticket
     *
     * @return jsTicket或错误信息
     */
    /*
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
    /*
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
     */
}