package com.jimi.dingtalk.service;

import com.jimi.dingtalk.model.ServiceResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface MediaService {

    String uploadMedia(MultipartFile file, HttpServletRequest httpServletRequest) throws IOException;
}
