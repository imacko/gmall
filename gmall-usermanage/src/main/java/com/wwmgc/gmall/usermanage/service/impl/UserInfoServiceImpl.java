package com.wwmgc.gmall.usermanage.service.impl;

import com.wwmgc.gmall.bean.UserInfo;
import com.wwmgc.gmall.service.UserInfoService;
import com.wwmgc.gmall.usermanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoMapper.selectAll();
    }
}
