package com.srbtj.demo.controller;

import com.srbtj.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model) {
        System.out.print("=======" + user.toString());
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
//            request.setAttribute("msg", "用户名或密码不能为空");
            model.addAttribute("msg", "用户名或密码不能为空");
            return "login";
        }
        // 使用 shiro 进行验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (LockedAccountException e) { // 账号已锁
            token.clear();
            model.addAttribute("msg", "用户已被锁定不能登录，请联系管理员!");
            return "login";
        } catch (AuthenticationException e) { // 用户名或密码错误
            token.clear();
            model.addAttribute("msg", "用户或密码不正确!");
            return "login";
        }
        return "login";
    }
}
