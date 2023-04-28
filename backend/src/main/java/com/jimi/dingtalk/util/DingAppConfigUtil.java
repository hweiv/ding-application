package com.jimi.dingtalk.util;

import com.jimi.dingtalk.config.AppConfig;
import com.jimi.dingtalk.model.DingAppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DingAppConfigUtil {
    private static AppConfig appConfig;

    public static DingAppInfo getDingAppInfo(String app) {
        DingAppInfo dingAppInfo = new DingAppInfo();
        switch (app) {
            case "hw2" :
                dingAppInfo.setAppAgentId(appConfig.getHwAppAgentId2());
                dingAppInfo.setAppKey(appConfig.getHwAppKey2());
                dingAppInfo.setAppSecret(appConfig.getHwAppSecret2());
                dingAppInfo.setCorpId(appConfig.getHwCorpId());
                break;
            default:
                dingAppInfo.setAppAgentId(appConfig.getHwAppAgentId());
                dingAppInfo.setAppKey(appConfig.getHwAppKey());
                dingAppInfo.setAppSecret(appConfig.getHwAppSecret());
                dingAppInfo.setCorpId(appConfig.getHwCorpId());
                break;
        }
        return dingAppInfo;
    }

    @Autowired
    public void setAppConfig (AppConfig appConfigParam){
        appConfig = appConfigParam;
    }

}
