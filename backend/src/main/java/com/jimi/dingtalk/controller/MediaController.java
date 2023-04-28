package com.jimi.dingtalk.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import com.jimi.dingtalk.config.AppConfig;
import com.jimi.dingtalk.constant.UrlConstant;
import com.jimi.dingtalk.exception.InvokeDingTalkException;
import com.jimi.dingtalk.model.ApiResult;
import com.jimi.dingtalk.model.ServiceResult;
import com.jimi.dingtalk.service.MediaService;
import com.jimi.dingtalk.util.AccessTokenUtil;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMediaUploadRequest;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传媒体文件
 */
@RestController
@RequestMapping("/media")
@Slf4j
public class MediaController {

    @Autowired
    private MediaService mediaService;

    /**
     * 上传媒介文件
     *
     * @return
     */
    @PostMapping("/upload")
    public ApiResult uploadMedia(@RequestParam(value = "file") MultipartFile file, HttpServletRequest httpServletRequest) {
        try {
            return ApiResult.success(mediaService.uploadMedia(file, httpServletRequest));
        } catch (Exception e) {
            log.error("MediaController-uploadMedia is error:{}", e);
            return ApiResult.error(e.getMessage());
        }
    }
}

