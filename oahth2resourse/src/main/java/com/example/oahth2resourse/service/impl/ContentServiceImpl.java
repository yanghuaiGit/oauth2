package com.example.oahth2resourse.service.impl;

import com.example.oahth2resourse.dao.ContentDao;
import com.example.oahth2resourse.model.Content;
import com.example.oahth2resourse.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lucky_yh
 * 2019/7/3 21:41
 */

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentDao contentDao;


    @Autowired
    public ContentServiceImpl(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    @Override
    public List<Content> queryListContent() {
        return contentDao.queryListContent();
    }
}
