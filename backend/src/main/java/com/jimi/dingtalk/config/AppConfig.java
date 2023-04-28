package com.jimi.dingtalk.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {
    @Value("${dingtalk.hw.app_key}")
    private String hwAppKey;
    @Value("${dingtalk.hw.app_secret}")
    private String hwAppSecret;
    @Value("${dingtalk.hw.app_agent_id}")
    private long hwAppAgentId;
    @Value("${dingtalk.hw.corp_id}")
    private String hwCorpId;

    @Value("${dingtalk.hw2.app_key}")
    private String hwAppKey2;
    @Value("${dingtalk.hw2.app_secret}")
    private String hwAppSecret2;
    @Value("${dingtalk.hw2.app_agent_id}")
    private long hwAppAgentId2;
}
