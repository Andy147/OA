package org.oa.model;

import java.util.Date;

public class User {
    private int user_id;
    private String user_account;
    private String user_pwd;
    private Date last_time;

    public User() {
    }

    public User(int user_id, String user_account, String user_pwd, Date last_time) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.last_time = last_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }
}
