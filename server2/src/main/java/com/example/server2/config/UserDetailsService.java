package com.example.server2.config;

import com.example.server2.dao.UserDao;
import com.example.server2.model.SysUser;
import com.example.server2.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucky_yh
 * 2019/7/3 7:23
 */

public class  UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser sysUser = userDao.queryOneByName(name);
        if (sysUser != null) {
            List<GrantedAuthority> list = new ArrayList<>();
            list.add((GrantedAuthority) () -> "/client1");

            return new UserVo(sysUser.getUsername(), sysUser.getPassword(), list);
        }
        throw new UsernameNotFoundException(name);
    }
}
