package com.jimi.dingtalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.ServiceResult;
import com.jimi.dingtalk.service.DingTalkUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 钉钉h5企业内部应用DEMO, 实现了根据用户授权码获取用户信息功能
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class DingTalkUserController {

    @Autowired
    private DingTalkUserService dingTalkUserService;

    /**
     * 欢迎页面, 检查后端服务是否启动
     *
     * @return
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 根据免登授权码, 获取登录用户身份
     *
     * @param authCode 免登授权码
     * @return
     */
    @GetMapping("/login")
    public ApiResult login(@RequestParam(value = "authCode") String authCode) {
        log.info("DingTalkUserController#login param : {}", authCode);
        return ApiResult.success(dingTalkUserService.getUserInfo(authCode));

    }

    /**
     * 获取部门员工信息
     * @param deptIds
     * @return
     */
    @GetMapping("/getUsersByDeptIds")
    public ApiResult getUsersByDeptIds(Long[] deptIds) {
        log.info("DingTalkUserController#getUsersByDeptIds param : {}", JSONObject.toJSON(deptIds));
        return ApiResult.success(dingTalkUserService.getUsersByDeptIds(Arrays.asList(deptIds)));
    }


}
