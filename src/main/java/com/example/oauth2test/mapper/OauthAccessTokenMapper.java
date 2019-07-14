package com.example.oauth2test.mapper;

import com.example.oauth2test.model.OauthAccessToken;
import com.example.oauth2test.model.OauthAccessTokenExample;
import com.example.oauth2test.model.OauthAccessTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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