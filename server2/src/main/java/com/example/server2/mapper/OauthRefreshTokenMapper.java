package com.example.server2.mapper;

import com.example.server2.model.OauthRefreshToken;
import com.example.server2.model.OauthRefreshTokenExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OauthRefreshTokenMapper {
    long countByExample(OauthRefreshTokenExample example);

    int deleteByExample(OauthRefreshTokenExample example);

    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);

    List<OauthRefreshToken> selectByExampleWithBLOBsWithRowbounds(OauthRefreshTokenExample example, RowBounds rowBounds);

    List<OauthRefreshToken> selectByExampleWithBLOBs(OauthRefreshTokenExample example);

    List<OauthRefreshToken> selectByExampleWithRowbounds(OauthRefreshTokenExample example, RowBounds rowBounds);

    List<OauthRefreshToken> selectByExample(OauthRefreshTokenExample example);

    int updateByExampleSelective(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenExample example);

    int updateByExample(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenExample example);
}