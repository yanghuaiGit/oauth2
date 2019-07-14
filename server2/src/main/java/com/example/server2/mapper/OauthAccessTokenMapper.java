package com.example.server2.mapper;

import com.example.server2.model.OauthAccessToken;
import com.example.server2.model.OauthAccessTokenExample;
import com.example.server2.model.OauthAccessTokenWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OauthAccessTokenMapper {
    long countByExample(OauthAccessTokenExample example);

    int deleteByExample(OauthAccessTokenExample example);

    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBsWithRowbounds(OauthAccessTokenExample example, RowBounds rowBounds);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenExample example);

    List<OauthAccessToken> selectByExampleWithRowbounds(OauthAccessTokenExample example, RowBounds rowBounds);

    List<OauthAccessToken> selectByExample(OauthAccessTokenExample example);

    OauthAccessTokenWithBLOBs selectByPrimaryKey(String authenticationId);

    int updateByExampleSelective(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExample(@Param("record") OauthAccessToken record, @Param("example") OauthAccessTokenExample example);

    int updateByPrimaryKeySelective(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKey(OauthAccessToken record);
}