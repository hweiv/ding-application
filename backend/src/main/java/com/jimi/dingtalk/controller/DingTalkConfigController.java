package com.jimi.dingtalk.controller;

import com.jimi.dingtalk.config.AppConfig;
import com.jimi.dingtalk.ding.domain.DingTalkWorkNotice;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.DingAppInfo;
import com.jimi.dingtalk.model.ServiceResult;
import com.jimi.dingtalk.util.DingAppConfigUtil;
import com.taobao.api.ApiException;
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

    @Autowired
    private DingTalkWorkNotice dingTalkWorkNotice;

    /**
     * 获取钉钉配置
     * @return
     */
    @GetMapping("/getConfig")
    public ApiResult getDingTalkConfig(@RequestParam String dingAppCode) {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        return ApiResult.success(dingAppInfo);
    }

    /**
     * 获取钉钉应用token
     * @return
     */
    @GetMapping("/getAccessToken")
    public ApiResult getAccessToken(@RequestParam String dingAppCode) {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        try {
            String accessToken = dingTalkWorkNotice.getAccessToken(dingAppInfo.getAppKey(), dingAppInfo.getAppSecret());
            return ApiResult.success(accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ApiResult.error("获取失败");
    }

    /**
     * 根据员工电话获取id
     * @return
     */
    @GetMapping("/getMobileById")
    public ApiResult getMobileById(@RequestParam String dingAppCode, @RequestParam String mobile) {
        DingAppInfo dingAppInfo = DingAppConfigUtil.getDingAppInfo(dingAppCode);
        try {
            String accessToken = dingTalkWorkNotice.getAccessToken(dingAppInfo.getAppKey(), dingAppInfo.getAppSecret());
            String userId = dingTalkWorkNotice.getUserIdByMobile(accessToken, mobile);
            return ApiResult.success(userId);
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.error("获取失败");
    }
}
