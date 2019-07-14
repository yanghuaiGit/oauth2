package com.example.server2.mapper;

import com.example.server2.model.SysRoleUser;
import com.example.server2.model.SysRoleUserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SysRoleUserMapper {
    long countByExample(SysRoleUserExample example);

    int deleteByExample(SysRoleUserExample example);

    int deleteByPrimaryKey(Integer sysUserId);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByExampleWithRowbounds(SysRoleUserExample example, RowBounds rowBounds);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    SysRoleUser selectByPrimaryKey(Integer sysUserId);

    int updateByExampleSelective(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByExample(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}