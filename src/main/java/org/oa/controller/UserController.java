package org.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("login.do")
    public String login(){
        System.out.println("登录页面");
        System.out.println("000");
        return "index";
    }

}
