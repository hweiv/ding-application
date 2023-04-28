package com.jimi.dingtalk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMediaUploadRequest;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import com.jimi.dingtalk.config.AppConfig;
import com.jimi.dingtalk.constant.UrlConstant;
import com.jimi.dingtalk.exception.InvokeDingTalkException;
import com.jimi.dingtalk.model.ServiceResult;
import com.jimi.dingtalk.service.MediaService;
import com.jimi.dingtalk.util.AccessTokenUtil;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class MediaServiceImpl implements MediaService {
    @Autowired
    private AppConfig appConfig;

    @Override
    public String uploadMedia(MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        String accessToken = AccessTokenUtil.getAccessToken(appConfig.getHwAppKey(), appConfig.getHwAppSecret());
        DingTalkClient client = new DefaultDingTalkClient(UrlConstant.UPLOAD_MEDIA_URL);
        OapiMediaUploadRequest req = new OapiMediaUploadRequest();
        String name = file.getName(); // file
        String originalFilename = file.getOriginalFilename(); // 测试头像.ico  项目帮助.txt
        String[] split = originalFilename.split("\\.");
        String fileExtension = split[split.length - 1];
        // 判断文件类型：image、voice、video、file
        String fileType = getFileTypeByExtension(fileExtension.toLowerCase());
        if (StringUtils.isBlank(fileType)) {
            throw new InvokeDingTalkException("不合法的文件类型");
        }
        req.setType(fileType);
        // 要上传的媒体文件
        byte[] bytes = file.getBytes();
        String realPath = httpServletRequest.getServletContext().getRealPath("/");
        log.info("MediaServiceImpl-uploadMedia.realPath : {}", realPath);
        String fileName = UUID.randomUUID() + "." + fileExtension.toLowerCase();
        File file1 = new File(realPath + fileName);
        getFile(bytes, realPath, fileName);
        FileItem item = new FileItem(file1);
        log.info("MediaServiceImpl-uploadMedia.item : {}", JSONObject.toJSON(item));
        req.setMedia(item);
        try {
            log.info("upload media request params req: {}, accessToken: {}", JSONObject.toJSON(req), accessToken);
            OapiMediaUploadResponse rsp = client.execute(req, accessToken);
            log.info("upload media response : {}", JSONObject.toJSON(rsp));

            if (rsp.isSuccess()) {
                return rsp.getMediaId();
            } else {
                log.error("upload media response error:{}", rsp.getErrmsg());
                throw new InvokeDingTalkException(rsp.getErrorCode(), rsp.getErrmsg());
            }
        } catch (ApiException e) {
            log.error("upload media response error:{}", e);
            throw new InvokeDingTalkException(e.getErrCode(), e.getErrMsg());
        }
    }

    private String getFileTypeByExtension(String fileExtension) {
        switch (fileExtension) {
            case "jpg" :
            case "gif" :
            case "png" :
            case "bmp" :
                return "image";
            case "amr" :
            case "mp3" :
            case "wav" :
                return "voice";
            case "mp4" :
                return "video";
            case "doc" :
            case "docx" :
            case "xls" :
            case "xlsx" :
            case "ppt" :
            case "pptx" :
            case "zip" :
            case "pdf" :
            case "rar" :
                return "file";
            default:
                return null;
        }
    }

    public void getFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            log.error("getFile Exception error:{}", e);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    log.error("bos close IOException error:{}", e1);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    log.error("fos close IOException error:{}", e1);
                }
            }
        }
    }
}
