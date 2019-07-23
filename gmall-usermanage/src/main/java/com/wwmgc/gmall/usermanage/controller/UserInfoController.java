package com.wwmgc.gmall.usermanage.controller;

import com.wwmgc.gmall.bean.UserInfo;
import com.wwmgc.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        List<UserInfo> userInfoList = userInfoService.getUserInfoList();
        return userInfoList;
    }
}
