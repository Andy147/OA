package org.oa.service.impl;

import net.sf.json.JSONObject;
import org.oa.dao.IUserDao;
import org.oa.model.User;
import org.oa.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServerImpl implements IUserServer {
    @Autowired
    IUserDao userDao;
    @Override
    public User getUserByName(String name , String pwd) {
        User user = userDao.getUserByName(name);
        //判断密码是否匹配
        if(user.getUser_pwd().equals(pwd))
        {
            return user;
        }
        return null;
    }
}
