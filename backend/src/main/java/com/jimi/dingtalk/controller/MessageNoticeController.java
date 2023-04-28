package com.jimi.dingtalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jimi.dingtalk.ding.domain.DingTalkMsg;
import com.jimi.dingtalk.ding.domain.DingTalkParams;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.DingTalkWorkNoticeInputVO;
import com.jimi.dingtalk.model.GroupMessageInputVO;
import com.jimi.dingtalk.service.MessageNoticeService;
import com.jimi.dingtalk.service.MessageNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 钉钉消息通知
 */
@Slf4j
@RestController
@RequestMapping("/work")
public class MessageNoticeController {

    @Autowired
    private MessageNoticeService messageNoticeService;

    /**
     * 发送工作通知
     *
     * @return
     */
    @PostMapping("/sendWorkNotice")
    public ApiResult sendWorkNotice(@RequestBody DingTalkMsg dingTalkMsg) {
        log.info("MessageNotificationController#sendWorkNotice param : {}", JSONObject.toJSON(dingTalkMsg));
        try {
            return ApiResult.success(messageNoticeService.sendWorkNotice(dingTalkMsg));
        } catch (Exception e) {
            log.error("MessageNoticeController-sendWorkNotice error:{}", e);
            return ApiResult.error(e.getMessage());
        }
    }

    /**
     * 查看通知进度
     * @param taskId
     * @return
     */
    @GetMapping("/getSendProgress")
    public ApiResult getSendProgress(@RequestParam String dingAppCode, @RequestParam Long taskId) {
        log.info("MessageNotificationController#sendWorkNotice param : {}", JSONObject.toJSON(taskId));
        try {
            return ApiResult.success(messageNoticeService.getSendProgress(dingAppCode, taskId));
        } catch (Exception e) {
            log.error("MessageNoticeController-sendWorkNotice error:{}", e);
            return ApiResult.error(e.getMessage());
        }
    }

    /**
     * 查看通知结果
     * @param taskId
     * @return
     */
    @GetMapping("/getSendNotice")
    public ApiResult getSendNotice(@RequestParam String dingAppCode, @RequestParam Long taskId) {
        log.info("MessageNotificationController#sendWorkNotice param : {}", JSONObject.toJSON(taskId));
        try {
            return ApiResult.success(messageNoticeService.getSendNotice(dingAppCode, taskId));
        } catch (Exception e) {
            log.error("MessageNoticeController-sendWorkNotice error:{}", e);
            return ApiResult.error(e.getMessage());
        }
    }

}
