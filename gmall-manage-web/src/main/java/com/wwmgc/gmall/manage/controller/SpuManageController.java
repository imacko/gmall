package com.wwmgc.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwmgc.gmall.bean.BaseAttrInfo;
import com.wwmgc.gmall.bean.SpuInfo;
import com.wwmgc.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SpuManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("spuListPage")
    public String spuListPage(){
        return "spuListPage";
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuList(@RequestParam Map<String,String> map){
        String catalog3Id = map.get("catalog3Id");
        List<SpuInfo> spuInfoList = manageService.spuList(catalog3Id);

        return spuInfoList;
    }
}
