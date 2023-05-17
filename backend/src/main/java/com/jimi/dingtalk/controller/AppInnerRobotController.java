package com.jimi.dingtalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jimi.dingtalk.ding.domain.DingAppInnerRobotMsg;
import com.jimi.dingtalk.ding.domain.DingTalkMsg;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.service.AppInnerRobotService;
import com.jimi.dingtalk.service.MessageNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 钉钉应用内机器人
 */
@Slf4j
@RestController
@RequestMapping("/robot")
public class AppInnerRobotController {
    @Autowired
    private AppInnerRobotService robotService;

    /**
     * 发送工作通知
     *
     * @return
     */
    @PostMapping("/sendMsgToPersonList")
    public ApiResult sendMsgToPersonList(@RequestBody DingAppInnerRobotMsg robotMsg) {
        log.info("AppInnerRobotController#sendMsgToPersonList param : {}", JSONObject.toJSON(robotMsg));
        try {
            return ApiResult.success(robotService.sendMsgToPersonList(robotMsg));
        } catch (Exception e) {
            log.error("MessageNoticeController-sendWorkNotice error:{}", e);
            return ApiResult.error(e.getMessage());
        }
    }
}
