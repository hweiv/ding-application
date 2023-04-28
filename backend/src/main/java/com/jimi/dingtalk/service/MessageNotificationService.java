package com.jimi.dingtalk.service;


import com.jimi.dingtalk.model.DingTalkWorkNoticeInputVO;
import com.jimi.dingtalk.model.GroupMessageInputVO;

import java.util.List;

public interface MessageNotificationService {

    Long sendWorkNotice(DingTalkWorkNoticeInputVO dingTalkWorkNoticeInputVO);

    String sendGroupMessage(GroupMessageInputVO groupMessageInputVO);

    List<String> getReadList(String dingAppCode, String messageId);
}
