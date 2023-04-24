package com.aliyun.dingtalk.ding.domain;

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
    @Value("${dingtalk.app_key}")
    private String appKey;
    @Value("${dingtalk.app_secret}")
    private String appSecret;
    @Value("${dingtalk.agent_id}")
    private long agentId;
    @Value("${dingtalk.corp_id}")
    private String corpId;
    @Value("${dingtalk.is_open}")
    private String isOpen;
}