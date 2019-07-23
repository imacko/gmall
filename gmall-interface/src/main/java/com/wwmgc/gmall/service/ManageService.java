package com.wwmgc.gmall.service;

import com.wwmgc.gmall.bean.BaseAttrInfo;
import com.wwmgc.gmall.bean.BaseCatalog1;
import com.wwmgc.gmall.bean.BaseCatalog2;
import com.wwmgc.gmall.bean.BaseCatalog3;

import java.util.List;

public interface ManageService {

    public List<BaseCatalog1> getCatalog1();

    List<BaseCatalog2> getCatalog2(String catalog1Id);

    List<BaseCatalog3> getCatalog3(String catalog2Id);

    List<BaseAttrInfo> baseAttrInfo(String catalog3Id);
}
