package com.jimi.dingtalk.ding.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * @author openapi@dingtalk
 * @date 2020/2/4
 */
@Configuration
@Data
public class DingTalkParams {
    @Value("${dingtalk.hw.app_key}")
    private String appKey;
    @Value("${dingtalk.hw.app_secret}")
    private String appSecret;
    @Value("${dingtalk.hw.app_agent_id}")
    private long agentId;
    @Value("${dingtalk.hw.corp_id}")
    private String corpId;
//    @Value("${dingtalk.is_open}")
//    private String isOpen;

    @Value("${dingtalk.hw2.app_key}")
    private String hwAppKey2;
    @Value("${dingtalk.hw2.app_secret}")
    private String hwAppSecret2;
    @Value("${dingtalk.hw2.app_agent_id}")
    private long hwAppAgentId2;
}