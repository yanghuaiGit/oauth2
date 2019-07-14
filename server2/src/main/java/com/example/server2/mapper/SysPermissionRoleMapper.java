package com.example.server2.mapper;

import com.example.server2.model.SysPermissionRole;
import com.example.server2.model.SysPermissionRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SysPermissionRoleMapper {
    long countByExample(SysPermissionRoleExample example);

    int deleteByExample(SysPermissionRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissionRole record);

    int insertSelective(SysPermissionRole record);

    List<SysPermissionRole> selectByExampleWithRowbounds(SysPermissionRoleExample example, RowBounds rowBounds);

    List<SysPermissionRole> selectByExample(SysPermissionRoleExample example);

    SysPermissionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);

    int updateByExample(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);

    int updateByPrimaryKeySelective(SysPermissionRole record);

    int updateByPrimaryKey(SysPermissionRole record);
}