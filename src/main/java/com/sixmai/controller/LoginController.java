package com.sixmai.controller;

import com.sixmai.domain.User;
import com.sixmai.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("login")
@Service
public class LoginController {
    @Autowired
    private loginService loginService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String login(User user, Model model) {
        String loginname = user.getLoginname();
        String password = user.getPassword();
        Map<String, Object> map = loginService.login(loginname, password);
        if (map.get("status").equals("200")) {
            return "system/index";
        } else {
            model.addAttribute("error", map.get("msg"));
            return "login";
        }
    }
}