package com.wwmgc.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwmgc.gmall.bean.BaseAttrInfo;
import com.wwmgc.gmall.bean.BaseCatalog1;
import com.wwmgc.gmall.bean.BaseCatalog2;
import com.wwmgc.gmall.bean.BaseCatalog3;
import com.wwmgc.gmall.manage.mapper.BaseAttrInfoMapper;
import com.wwmgc.gmall.manage.mapper.BaseCatalog1Mapper;
import com.wwmgc.gmall.manage.mapper.BaseCatalog2Mapper;
import com.wwmgc.gmall.manage.mapper.BaseCatalog3Mapper;
import com.wwmgc.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private  BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;



    @Override
    public List<BaseCatalog1> getCatalog1() {

        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();

        return baseCatalog1List;
    }

    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2);
        return baseCatalog2List;
    }

    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3);
        return baseCatalog3List;
    }

    @Override
    public List<BaseAttrInfo> baseAttrInfo(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
        return baseAttrInfoList;
    }
}
