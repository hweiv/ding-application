package com.jimi.dingtalk.ding.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DingAppInnerRobotMsgResp {
    @ApiModelProperty(value = "消息id")
    private String processQueryKey;
    @ApiModelProperty(value = "无效的用户userId列表")
    private List<String> invalidStaffIdList;
    @ApiModelProperty(value = "被限流的userId列表")
    private List<String> flowControlledStaffIdList;
}
