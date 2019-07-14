package com.example.server2.dao.imp;

import com.example.server2.dao.UserDao;
import com.example.server2.mapper.SysUserMapper;
import com.example.server2.model.SysUser;
import com.example.server2.model.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lucky_yh
 * 2019/7/3 9:48
 */

@Repository
public class UserDaoImp implements UserDao {

    private final SysUserMapper sysUserMapper;

    @Autowired
    public UserDaoImp(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }


    @Override
    public SysUser queryOneByName(String name) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(name);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if (list != null && list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
