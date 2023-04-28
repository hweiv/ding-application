package com.jimi.dingtalk.ding.domain;

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
    @ApiModelProperty(value = "钉钉应用系统编码")
    private String dingAppCode;
    @ApiModelProperty(value = "消息类型")
    private String msgType;
    @ApiModelProperty(value = "通知标题")
    private String title;
    @ApiModelProperty(value = "通知内容")
    private String content;
    @ApiModelProperty(value = "媒介id")
    private String mediaId;
    @ApiModelProperty(value = "通知人员dingUserId列表，多个用英文逗号连接")
    private String userList;
    @ApiModelProperty(value = "消息链接地址")
    private String url;
    @ApiModelProperty(value = "OA Form 表单内容")
    private List<OapiMessageCorpconversationAsyncsendV2Request.Form> fromList;
    @ApiModelProperty(value = "提醒人")
    private String author;
    @ApiModelProperty(value = "卡片按钮列表")
    private List<OapiMessageCorpconversationAsyncsendV2Request.BtnJsonList> btnJsonList;
    @ApiModelProperty(value = "卡片按钮排列方向：0-横向；1-竖向")
    private String btnOrientation;
    @ApiModelProperty(value = "卡片整体跳转标题文字")
    private String singleTitle;
    @ApiModelProperty(value = "OA PC端打开的链接")
    private String pcMsgUrl;
    @ApiModelProperty(value = "OA 展示的附件数")
    private String fileCount;
    @ApiModelProperty(value = "OA 富文本")
    private OapiMessageCorpconversationAsyncsendV2Request.Rich rich;
    @ApiModelProperty(value = "状态节点")
    private OapiMessageCorpconversationAsyncsendV2Request.StatusBar statusBar;
    @ApiModelProperty(value = "语音时长（秒），不超过60s")
    private String duration;
}