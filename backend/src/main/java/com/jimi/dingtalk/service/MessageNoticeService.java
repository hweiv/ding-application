package com.jimi.dingtalk.service;

import com.jimi.dingtalk.ding.domain.DingTalkMsg;
import com.jimi.dingtalk.model.ApiResult;
import com.taobao.api.ApiException;

public interface MessageNoticeService {
    Long sendWorkNotice(DingTalkMsg dingTalkMsg) throws Exception;

    ApiResult getSendProgress(String dingAppCode, Long taskId) throws ApiException;

    ApiResult getSendNotice(String dingAppCode, Long taskId) throws ApiException;

    String getUserIdByMobile(String accessToken, String mobile) throws Exception;
}
