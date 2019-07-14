package com.example.oauth2test.mapper;

import com.example.oauth2test.model.SysPermission;
import com.example.oauth2test.model.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysPermissionMapper {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExampleWithRowbounds(SysPermissionExample example, RowBounds rowBounds);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}