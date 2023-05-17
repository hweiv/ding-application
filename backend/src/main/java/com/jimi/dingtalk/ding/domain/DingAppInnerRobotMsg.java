package com.jimi.dingtalk.ding.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DingAppInnerRobotMsg {
    @ApiModelProperty(value = "通知内容")
    private String content;
    @ApiModelProperty(value = "通知人员dingUserId列表，多个用英文逗号连接")
    private String userList;
}
