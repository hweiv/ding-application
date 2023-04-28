package com.jimi.dingtalk.constant;

/**
 * 钉钉开放接口网关常量
 */
public class UrlConstant {

    /**
     * 通过电话获取用户信息
     */
    public static final String GET_USER_BY_MOBILE = "https://oapi.dingtalk.com/user/get_by_mobile";

    /**
     * 获取access_token url
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    /**
     * 通过免登授权码获取用户信息 url
     */
    public static final String GET_USER_INFO_URL = "https://oapi.dingtalk.com/topapi/v2/user/getuserinfo";

    /**
     * 根据用户id获取用户详情 url
     */
    public static final String USER_GET_URL = "https://oapi.dingtalk.com/topapi/v2/user/get";


    /**
     * 异步发送工作通知url
     */
    public static final String ASYNC_SEND_MESSAGE = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";

    /**
     * 创建群会话url
     */
    public static final String CREATE_CHAT_URL = "https://oapi.dingtalk.com/chat/create";

    /**
     * 发送群消息url
     */
    public static final String SEND_CHAT_MESSAGE = "https://oapi.dingtalk.com/chat/send";

    /**
     * 获取已读消息人员列表url
     */
    public static final String GET_READ_LIST_URL = "https://oapi.dingtalk.com/chat/getReadList";

    /**
     * 上传媒体文件url
     */
    public static final String UPLOAD_MEDIA_URL = "https://oapi.dingtalk.com/media/upload";

    /**
     * 获取部门成员信息
     */
    public static final String GET_USER_LIST_BY_DEPT_URL = "https://oapi.dingtalk.com/topapi/v2/user/list";

    /**
     * 根据唯一任务ID task_id，调用服务端API-获取工作通知消息的发送进度接口，获取发送进度
     */
    public static final String GET_SEND_PROGRESS_BY_TASK_ID = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendprogress";

    /**
     * 根据唯一任务ID task_id，调用服务端API-获取工作通知消息的发送结果接口，查看发送结果
     */
    public static final String GET_SEND_RESULT_BY_TASK_ID = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult";

    /**
     * 根据唯一任务ID task_id，调用服务端API-更新工作通知状态栏接口，更新工作通知
     * 审批状态颜色参考
     * 已同意 0xFF78C06E
     * 已拒绝 0xFFF65E5E
     * 已撤销 0xFF858E99
     * 待审批 0xFFFF9D46
     */
    public static final String UPDATE_STATUS_BY_TASK_ID = "https://oapi.dingtalk.com/topapi/message/corpconversation/status_bar/update";

    /**
     * 根据唯一任务ID task_id，调用服务端API-撤回工作通知消息接口，撤回工作通知
     */
    public static final String RECALL_NOTICE_BY_TASK_ID = "https://oapi.dingtalk.com/topapi/message/corpconversation/recall";
}
