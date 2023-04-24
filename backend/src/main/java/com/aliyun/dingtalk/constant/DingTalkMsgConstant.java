package com.aliyun.dingtalk.constant;

/**
 * 钉钉通知消息类型
 */
public class DingTalkMsgConstant {
    // OA类型通知   （可跳转）
    public static final String MSG_TYPE_OA = "oa";
    // 卡片类型通知   （可多个跳转）
    public static final String MSG_TYPE_ACTION_CARD = "action_card";
    // 文件类型通知   （不可跳）
    public static final String MSG_TYPE_FILE = "file";
    // 图片类型通知   （不可跳）
    public static final String MSG_TYPE_IMAGE = "image";
    // 链接类型通知   （可跳转）
    public static final String MSG_TYPE_LINK = "link";
    // 多级标题-文本格式类型通知    （markdown文本可配置跳转链接）
    public static final String MSG_TYPE_MARKDOWN = "markdown";
    // 文本类型通知   （不可跳）
    public static final String MSG_TYPE_TEXT = "text";
    // 语音类型通知   （不可跳）
    public static final String MSG_TYPE_VOICE = "voice";
}
