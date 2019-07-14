package com.example.oauth2test.dao;

import com.example.oauth2test.model.SysRoleUser;
import com.example.oauth2test.model.SysUser;

/**
 * @author lucky_yh
 * 2019/7/3 9:47
 */
public interface UserDao {
    SysUser queryOneByName(String name);

}
