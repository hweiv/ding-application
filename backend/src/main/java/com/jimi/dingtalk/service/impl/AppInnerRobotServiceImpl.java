package com.jimi.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.jimi.dingtalk.ding.domain.DingAppInnerRobotMsg;
import com.jimi.dingtalk.ding.domain.DingAppInnerRobotMsgResp;
import com.jimi.dingtalk.service.AppInnerRobotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppInnerRobotServiceImpl implements AppInnerRobotService {

    @Override
    public DingAppInnerRobotMsgResp sendMsgToPersonList(DingAppInnerRobotMsg robotMsg) {

        return null;
    }
}
