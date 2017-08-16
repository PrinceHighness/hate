package com.jk.service.notice.impl;

import com.jk.dao.notice.NoticeDao;
import com.jk.service.notice.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeDao noticeDao;
}
