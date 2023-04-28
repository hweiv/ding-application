package com.jimi.dingtalk.ding.domain;

import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import java.util.ArrayList;
import java.util.List;
/**
 * 构建钉钉发送消息
 *
 * @author hjm
 * @date 2019-04-24
 */
public class DingDingMsg {
    private List<OapiMessageCorpconversationAsyncsendV2Request.Form> mapList = new ArrayList<>();
    private DingDingMsg() {
    }
    public static DingDingMsg create(String key, String value) {
        return (new DingDingMsg()).builder(key, value);
    }
    public DingDingMsg builder(String key, String value) {
        OapiMessageCorpconversationAsyncsendV2Request.Form form = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form.setKey(key);
        form.setValue(value);
        mapList.add(form);
        return this;
    }
    public List<OapiMessageCorpconversationAsyncsendV2Request.Form> collect() {
        return this.mapList;
    }
}