package com.example.oauth2test.mapper;

import com.example.oauth2test.model.SysRole;
import com.example.oauth2test.model.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExampleWithRowbounds(SysRoleExample example, RowBounds rowBounds);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}