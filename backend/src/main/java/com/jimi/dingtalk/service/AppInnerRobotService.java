package com.jimi.dingtalk.service;

import com.jimi.dingtalk.ding.domain.DingAppInnerRobotMsg;
import com.jimi.dingtalk.ding.domain.DingAppInnerRobotMsgResp;

public interface AppInnerRobotService {
    DingAppInnerRobotMsgResp sendMsgToPersonList(DingAppInnerRobotMsg robotMsg);
}
