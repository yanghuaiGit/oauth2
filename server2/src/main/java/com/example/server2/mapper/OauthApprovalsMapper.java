package com.example.server2.mapper;

import com.example.server2.model.OauthApprovals;
import com.example.server2.model.OauthApprovalsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OauthApprovalsMapper {
    long countByExample(OauthApprovalsExample example);

    int deleteByExample(OauthApprovalsExample example);

    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);

    List<OauthApprovals> selectByExampleWithRowbounds(OauthApprovalsExample example, RowBounds rowBounds);

    List<OauthApprovals> selectByExample(OauthApprovalsExample example);

    int updateByExampleSelective(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);

    int updateByExample(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);
}