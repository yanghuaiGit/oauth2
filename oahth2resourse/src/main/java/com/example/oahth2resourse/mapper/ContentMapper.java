package com.example.oahth2resourse.mapper;

import com.example.oahth2resourse.model.Content;
import com.example.oahth2resourse.model.ContentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ContentMapper {
    long countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExampleWithRowbounds(ContentExample example, RowBounds rowBounds);

    List<Content> selectByExample(ContentExample example);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);
}