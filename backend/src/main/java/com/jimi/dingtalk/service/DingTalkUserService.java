package com.jimi.dingtalk.service;

import com.dingtalk.api.response.OapiV2UserGetResponse;

import java.util.List;
import java.util.Map;


public interface DingTalkUserService {
    OapiV2UserGetResponse.UserGetResponse getUserInfo(String authCode);

    List<Map<String, String>> getUsersByDeptIds(List<Long> deptIds);
}
