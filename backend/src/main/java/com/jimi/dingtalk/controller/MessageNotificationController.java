package com.jimi.dingtalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.DingTalkWorkNoticeInputVO;
import com.jimi.dingtalk.model.GroupMessageInputVO;
import com.jimi.dingtalk.service.MessageNotificationService;
import com.jimi.dingtalk.model.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 钉钉消息通知
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageNotificationController {

    @Autowired
    private MessageNotificationService messageNotificationService;

    /**
     * 发送工作通知
     *
     * @return
     */
    @PostMapping("/sendWorkNotice")
    public ApiResult sendWorkNotice(@RequestBody DingTalkWorkNoticeInputVO dingTalkWorkNoticeInputVO) {
        log.info("MessageNotificationController#sendWorkNotice param : {}", JSONObject.toJSON(dingTalkWorkNoticeInputVO));
        return ApiResult.success(messageNotificationService.sendWorkNotice(dingTalkWorkNoticeInputVO));
    }

    /**
     * 发送群消息
     *
     * @return
     */
    @PostMapping("/sendGroupMessage")
    public ApiResult sendGroupMessage(@RequestBody GroupMessageInputVO groupMessageInputVO) {
        log.info("MessageNotificationController#sendGroupMessage param : {}", JSONObject.toJSON(groupMessageInputVO));
        return ApiResult.success(messageNotificationService.sendGroupMessage(groupMessageInputVO));

    }

    /**
     * 根据消息ID获取已读人员列表
     *
     * @return
     */
    @GetMapping("/getReadList")
    public ApiResult getReadList(@PathVariable String dingAppCode, @PathVariable String messageId) {
        log.info("MessageNotificationController#getReadList param-messageId:{}，dingAppCode:{}", messageId, dingAppCode);
        return ApiResult.success(messageNotificationService.getReadList(dingAppCode, messageId));

    }



}
