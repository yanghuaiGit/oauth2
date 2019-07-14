package com.example.oauth2test.mapper;

import com.example.oauth2test.model.SysPermissionRole;
import com.example.oauth2test.model.SysPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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