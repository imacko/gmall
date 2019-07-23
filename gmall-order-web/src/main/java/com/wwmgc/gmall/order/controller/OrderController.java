package com.wwmgc.gmall.order.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wwmgc.gmall.bean.UserAddress;
import com.wwmgc.gmall.service.UserAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {
    //调用servi层服务
    @Reference
    private UserAddressService userAddressService;

    //根据用户id进行查询，用户id应该是传递过来的值
    @RequestMapping("trad")
    public List<UserAddress> trad(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<UserAddress> userAddressList = userAddressService.getUserAddressList(userId);
        return userAddressList;
    }
}
