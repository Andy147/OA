package org.oa.controller;

import net.sf.json.JSONObject;
import org.oa.model.User;
import org.oa.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    IUserServer userServer;
    @Autowired
    HttpSession session;
    @RequestMapping("login.do" )
    public void login(){
        JSONObject reply = new JSONObject();
        System.out.println("登录页面");
        System.out.println("name:"+request.getParameter("name"));
        //获取用户名和密码
        User user = userServer.getUserByName(request.getParameter("name") , request.getParameter("pwd") );
        if (user != null)
        {
            reply.put("statu" , 0);
            reply.put("reason" , "OK");
            session.setAttribute("user" , user);
        }
        else
        {
            reply.put("statu" , -1);
            reply.put("reason" , "用户名或密码不存在");
        }
        System.out.println(reply.toString(2));
    }
    @RequestMapping("index.do")
    public String turn2Index()
    {
        return "index";
    }

}
