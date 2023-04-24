package com.aliyun.dingtalk.ding.domain;

/**
 * <p>DingTalkUrlConstants 此类用于：调用钉钉API路径URL</p>
 * <p>@author：hjm</p>
 * <p>@date：2021年06月08日 11:20</p>
 * <p>@remark：</p>
 */
public class DingTalkUrlConstants {
    private static final String HOST = "https://oapi.dingtalk.com";
    /**
     * 钉钉网关 gettoken 地址
     */
    public static final String URL_GET_TOKEN = HOST + "/gettoken";
    /**
     * 获取 jsapi_ticket 地址
     */
    public static final String URL_GET_JSTICKET = HOST + "/get_jsapi_ticket";
    /**
     * 发送钉钉工作通知接口URL
     */
    public static final String URL_SEND_WORK_NOTICE = HOST + "/topapi/message/corpconversation/asyncsend_v2";
    /**
     * 获取用户在企业内 userId 的接口URL
     */
    public static final String URL_GET_USER_INFO = HOST + "/user/getuserinfo";
    /**
     * 获取用户姓名的接口URL
     */
    public static final String URL_USER_GET = HOST + "/user/get";
    /**
     * 获取部门列表接口URL
     */
    public static final String URL_DEPARTMENT_LIST = HOST + "/department/list";
    /**
     * 获取部门用户接口URL
     */
    public static final String URL_USER_SIMPLELIST = HOST + "/user/simplelist";
}