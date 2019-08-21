package com.sixmai.service;

import java.util.Map;

public interface loginService {
    Map<String,Object> login(String loginname, String password);
}
