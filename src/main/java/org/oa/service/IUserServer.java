package org.oa.service;

import org.oa.model.User;

public interface IUserServer {
    public User getUserByName(String name , String pwd);
}
