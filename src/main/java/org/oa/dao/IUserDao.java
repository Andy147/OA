package org.oa.dao;

import org.oa.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserDao {
    //根据用户名查找用户
    public User getUserByName(String userName);
}
