package com.sixmai.service.impl;

import com.sixmai.domain.User;
import com.sixmai.mapper.UserMapper;
import com.sixmai.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> login(String loginname, String password) {
        HashMap<String, Object> mm = new HashMap<String, Object>();
        List<User> users = userMapper.login(loginname);
        String msg = "";
        if ((users.size() == 0)) {
            mm.put("status", "401");
            mm.put(msg, "用户不存在!");
        }
        User user = users.get(0);
        if (!password.equals(user.getPassword())) {
            mm.put("status", "401");
            mm.put(msg, "密码错误！");
        } else {
            mm.put("status", "200");
            mm.put(msg, "登陆成功!");
        }
        return mm;
    }
}
