package com.leyou.item.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
//@SessionAttributes("account")
public class SecurityContextController {

    @GetMapping("/account")
    public void login() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
//已经拿到session,就可以拿到session中保存的用户信息了。
        System.out.println(request.getSession().getAttribute("userInfo"));
    }
}
