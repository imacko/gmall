package com.wwmgc.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwmgc.gmall.bean.BaseAttrInfo;
import com.wwmgc.gmall.bean.BaseCatalog1;
import com.wwmgc.gmall.bean.BaseCatalog2;
import com.wwmgc.gmall.bean.BaseCatalog3;
import com.wwmgc.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("attrListPage")
    public String getAttrListPage(){
        return "attrListPage";
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){

        List<BaseCatalog1> catalog1List = manageService.getCatalog1();

        return catalog1List;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(@RequestParam Map<String,String> map){
        String catalog1Id = map.get("catalog1Id");
        List<BaseCatalog2> catalog2List = manageService.getCatalog2(catalog1Id);

        return catalog2List;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(@RequestParam Map<String,String> map){
        String catalog2Id = map.get("catalog2Id");
        List<BaseCatalog3> catalog3List = manageService.getCatalog3(catalog2Id);

        return catalog3List;
    }

    @RequestMapping("baseAttrInfo")
    @ResponseBody
    public List<BaseAttrInfo> baseAttrInfo(@RequestParam Map<String,String> map){
        String catalog3Id = map.get("catalog3Id");
        List<BaseAttrInfo> baseAttrInfoList = manageService.baseAttrInfo(catalog3Id);

        return baseAttrInfoList;
    }

}
