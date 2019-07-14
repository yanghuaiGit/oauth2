package com.example.server2.dao;

import com.example.server2.model.SysUser;

/**
 * @author lucky_yh
 * 2019/7/3 9:47
 */
public interface UserDao {
    SysUser queryOneByName(String name);

}
