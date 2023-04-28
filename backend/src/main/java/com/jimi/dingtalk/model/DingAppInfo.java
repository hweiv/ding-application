package com.jimi.dingtalk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 钉钉应用信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingAppInfo {
    private String appKey;
    private String appSecret;
    private long appAgentId;
    private String corpId;
}
