package com.wwmgc.gmall.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwmgc.gmall.bean.UserAddress;
import com.wwmgc.gmall.service.UserAddressService;
import com.wwmgc.gmall.usermanage.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        //创建地址对象
        UserAddress userAddress = new UserAddress();
        //将用户的id传递给对象
        userAddress.setUserId(userId);
        //使用通用mapper查出信息
        List<UserAddress> listUserAddress = userAddressMapper.select(userAddress);
        //将信息返回
        return listUserAddress;
    }
}
