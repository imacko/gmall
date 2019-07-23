package com.wwmgc.gmall.service;

import com.wwmgc.gmall.bean.UserAddress;

import java.util.List;

public interface UserAddressService {
    //通过用户的id查找用户地址信息
    List<UserAddress> getUserAddressList(String userId);
}
