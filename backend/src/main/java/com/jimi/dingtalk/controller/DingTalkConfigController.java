package com.jimi.dingtalk.controller;

import com.jimi.dingtalk.config.AppConfig;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.DingAppInfo;
import com.jimi.dingtalk.model.ServiceResult;
import com.jimi.dingtalk.util.DingAppConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取钉钉应用的配置信息
 */
@RestController
@RequestMapping("/config")
public class DingTalkConfigController {

    /**
     * 获取钉钉配置
     * @return
     */
    @GetMapping("/getConfig")
    public ApiResult getDingTalkConfig(@RequestParam String dingAppCode) {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        return ApiResult.success(dingAppInfo);
    }


}
