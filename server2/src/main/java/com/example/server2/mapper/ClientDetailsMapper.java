package com.example.server2.mapper;

import com.example.server2.model.ClientDetails;
import com.example.server2.model.ClientDetailsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ClientDetailsMapper {
    long countByExample(ClientDetailsExample example);

    int deleteByExample(ClientDetailsExample example);

    int deleteByPrimaryKey(String appid);

    int insert(ClientDetails record);

    int insertSelective(ClientDetails record);

    List<ClientDetails> selectByExampleWithRowbounds(ClientDetailsExample example, RowBounds rowBounds);

    List<ClientDetails> selectByExample(ClientDetailsExample example);

    ClientDetails selectByPrimaryKey(String appid);

    int updateByExampleSelective(@Param("record") ClientDetails record, @Param("example") ClientDetailsExample example);

    int updateByExample(@Param("record") ClientDetails record, @Param("example") ClientDetailsExample example);

    int updateByPrimaryKeySelective(ClientDetails record);

    int updateByPrimaryKey(ClientDetails record);
}