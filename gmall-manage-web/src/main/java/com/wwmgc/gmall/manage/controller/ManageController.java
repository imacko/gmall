package com.wwmgc.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwmgc.gmall.bean.*;
import com.wwmgc.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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



    /**
     * 获得一级分类
     * @return
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){

        List<BaseCatalog1> catalog1List = manageService.getCatalog1();

        return catalog1List;
    }

    /**
     * 获得两级分类
     * @param map
     * @return
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(@RequestParam Map<String,String> map){
        String catalog1Id = map.get("catalog1Id");
        List<BaseCatalog2> catalog2List = manageService.getCatalog2(catalog1Id);

        return catalog2List;
    }


    /**
     * 获得三级分类
     * @param map
     * @return
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(@RequestParam Map<String,String> map){
        String catalog2Id = map.get("catalog2Id");
        List<BaseCatalog3> catalog3List = manageService.getCatalog3(catalog2Id);

        return catalog3List;
    }

    /**
     * 获得属性列表
     * @param map
     * @return
     */
    @RequestMapping("baseAttrInfo")
    @ResponseBody
    public List<BaseAttrInfo> baseAttrInfo(@RequestParam Map<String,String> map){
        String catalog3Id = map.get("catalog3Id");
        List<BaseAttrInfo> baseAttrInfoList = manageService.baseAttrInfo(catalog3Id);

        return baseAttrInfoList;
    }

    @RequestMapping(value = "saveAttrInfo",method = RequestMethod.POST)
    @ResponseBody
    public String saveAttrInfo(BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
        return "success";
    }


    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(@RequestParam Map<String,String> map){
        String attrId = map.get("attrId");
        List<BaseAttrValue> baseAttrValueList = manageService.getAttrValueList(attrId);

        return baseAttrValueList;
    }
}
