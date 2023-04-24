package com.aliyun.dingtalk.ding.domain;

import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
/**
 * DingTalkMsg.java此类用于
 *
 * @author: hjm
 * @date: 2021/4/14
 * @remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingTalkMsg {
    @ApiModelProperty(value = "消息类型")
    private String msgType;
    @ApiModelProperty(value = "通知标题")
    private String title;
    @ApiModelProperty(value = "通知内容")
    private String content;
    @ApiModelProperty(value = "媒介id")
    private String media_id;
    @ApiModelProperty(value = "通知人员dingUserId列表")
    private String userList;
    @ApiModelProperty(value = "消息链接地址")
    private String url;
    @ApiModelProperty(value = "OA Form 表单内容")
    private List<OapiMessageCorpconversationAsyncsendV2Request.Form> fromList;
    @ApiModelProperty(value = "提醒人")
    private String author;
}