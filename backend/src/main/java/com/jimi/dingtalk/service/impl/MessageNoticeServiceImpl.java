package com.jimi.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationGetsendprogressRequest;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiMessageCorpconversationGetsendprogressResponse;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.jimi.dingtalk.constant.UrlConstant;
import com.jimi.dingtalk.ding.domain.DingTalkMsg;
import com.jimi.dingtalk.ding.domain.DingTalkWorkNotice;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.DingAppInfo;
import com.jimi.dingtalk.service.MessageNoticeService;
import com.jimi.dingtalk.util.DingAppConfigUtil;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageNoticeServiceImpl implements MessageNoticeService {

    @Autowired
    private DingTalkWorkNotice dingTalkWorkNotice;

    /**
     * 发送钉钉通知消息--通用版
     * @param dingTalkMsg
     * @return 发送消息成功的任务id
     */
    @Override
    public Long sendWorkNotice(DingTalkMsg dingTalkMsg) throws Exception{
        Long taskId = dingTalkWorkNotice.sendDingMsg(dingTalkMsg);
        return taskId;
    }

    @Override
    public ApiResult getSendProgress(String dingAppCode, Long taskId) throws ApiException {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        String accessToken = dingTalkWorkNotice.getAccessToken(dingAppInfo.getAppKey(), dingAppInfo.getAppSecret());
        DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_SEND_PROGRESS_BY_TASK_ID);
        OapiMessageCorpconversationGetsendprogressRequest req = new OapiMessageCorpconversationGetsendprogressRequest();
        req.setAgentId(dingAppInfo.getAppAgentId());
        req.setTaskId(taskId);
        OapiMessageCorpconversationGetsendprogressResponse rsp = client.execute(req, accessToken);
        System.out.println(rsp.getBody());
        return ApiResult.success(rsp.getBody());
    }

    @Override
    public ApiResult getSendNotice(String dingAppCode, Long taskId) throws ApiException {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        String accessToken = dingTalkWorkNotice.getAccessToken(dingAppInfo.getAppKey(), dingAppInfo.getAppSecret());
        DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_SEND_RESULT_BY_TASK_ID);
        OapiMessageCorpconversationGetsendprogressRequest req = new OapiMessageCorpconversationGetsendprogressRequest();
        req.setAgentId(dingAppInfo.getAppAgentId());
        req.setTaskId(taskId);
        OapiMessageCorpconversationGetsendprogressResponse rsp = client.execute(req, accessToken);
        System.out.println(rsp.getBody());
        return ApiResult.success(rsp.getBody());
    }

    @Override
    public String getUserIdByMobile(String accessToken, String mobile) throws Exception {
        DingTalkClient client2 = new DefaultDingTalkClient(UrlConstant.GET_USER_BY_MOBILE);
        OapiUserGetByMobileRequest req = new OapiUserGetByMobileRequest();
        req.setMobile(mobile);
        req.setHttpMethod("GET");
        OapiUserGetByMobileResponse rsp = client2.execute(req, accessToken);
        return rsp.getUserid();
    }
}
