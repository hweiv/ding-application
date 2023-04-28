package com.jimi.dingtalk.model;

import lombok.Data;

import java.util.List;

@Data
public class DingTalkWorkNoticeInputVO {
    // 钉钉应用系统编码
    private String dingAppCode;

    private List<String> userIdList;

    private Boolean toAllUser;

    private WorkNotice workNotice;

}
