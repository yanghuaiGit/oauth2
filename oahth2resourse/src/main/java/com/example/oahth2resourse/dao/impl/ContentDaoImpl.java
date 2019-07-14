package com.example.oahth2resourse.dao.impl;

import com.example.oahth2resourse.dao.ContentDao;
import com.example.oahth2resourse.mapper.ContentMapper;
import com.example.oahth2resourse.model.Content;
import com.example.oahth2resourse.model.ContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lucky_yh
 * 2019/7/3 21:38
 */

@Repository
public class ContentDaoImpl implements ContentDao {

    private final ContentMapper contentMapper;


    @Autowired
    public ContentDaoImpl(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Override
    public List<Content> queryListContent() {
        ContentExample contentExample = new ContentExample();
        return contentMapper.selectByExample(contentExample);
    }
}
