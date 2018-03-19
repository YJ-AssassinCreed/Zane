package com.zane.shop.service.impl;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;
import com.zane.shop.common.ServerResponse;
import com.zane.shop.dao.XylFontCategoryAttrPOMapper;
import com.zane.shop.dao.XylFontCategoryPOMapper;
import com.zane.shop.dao.XylProductAttrPOMapper;
import com.zane.shop.dao.XylProductPOMapper;
import com.zane.shop.po.XylFontCategoryAttrPO;
import com.zane.shop.po.XylFontCategoryPO;
import com.zane.shop.po.XylProductPO;
import com.zane.shop.service.IFontCategoryService;
import com.zane.shop.vo.CategoryVo;
import com.zane.shop.vo.ProductVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Service("IFontCategoryService")
public class FontCategoryServiceImpl implements IFontCategoryService {

    @Autowired
    private XylFontCategoryPOMapper xylFontCategoryPOMapper;
    @Autowired
    private XylFontCategoryAttrPOMapper xylFontCategoryAttrPOMapper;
    @Autowired
    private XylProductAttrPOMapper xylProductAttrPOMapper;
    @Autowired
    private XylProductPOMapper xylProductPOMapper;
    @Override
    public ServerResponse<List<CategoryVo>> getNavigation() {
        List<XylFontCategoryPO>  fontCategoryList =  xylFontCategoryPOMapper.queryCategoryChildrenByParentId(0);
        if(fontCategoryList.size()>0){
            List<CategoryVo> resultList = Lists.newArrayList();
            for(XylFontCategoryPO fontCategory : fontCategoryList){
                CategoryVo fontCategoryVo = new CategoryVo();
                fontCategoryVo.setFcid(fontCategory.getFcid());
                fontCategoryVo.setFcname(fontCategory.getFcname());
                fontCategoryVo.setPicUrl(fontCategory.getPicUrl());
                fontCategoryVo.setSortOrder(fontCategory.getSortOrder());
                resultList.add(fontCategoryVo);
            }
            return  ServerResponse.createBySuccess(resultList);
        }
        return ServerResponse.createByErrorMessage("分类导航栏数据为空");
    }
    @Override
    public ServerResponse<List<CategoryVo>> getCategoryList(Integer categoryId){
        List<CategoryVo> categoryList = Lists.newArrayList();
        findChildCategory(categoryList,categoryId);
        if(CollectionUtils.isEmpty(categoryList)){
            return ServerResponse.createByErrorMessage("分类数据为空");
        }
        return ServerResponse.createBySuccess(categoryList);
    }
    private List<CategoryVo> findChildCategory(List<CategoryVo> categoryList, Integer categoryId){
        List<XylFontCategoryPO>  fontCategoryList =  xylFontCategoryPOMapper.queryCategoryChildrenByParentId(categoryId);
        if(fontCategoryList.size()>0){
            for(XylFontCategoryPO fontCategory : fontCategoryList){
                CategoryVo categoryVo = new CategoryVo();
                categoryVo.setFcid(fontCategory.getFcid());
                categoryVo.setFcname(fontCategory.getFcname());
                categoryVo.setPicUrl(fontCategory.getPicUrl());
                if(fontCategory.getIsLeafnode()==0){
                    List<CategoryVo> subCategoryList = Lists.newArrayList();
                    categoryVo.setSubCategoryList(findChildCategory(subCategoryList,fontCategory.getFcid()));
                }
                categoryList.add(categoryVo);
            }
        }
        return categoryList;
    }
    @Override
    public ServerResponse getProductListByCategoryId(Integer fcid){

        List<ProductVo> resultList = Lists.newArrayList();
        List<Integer> bcidList = xylFontCategoryPOMapper.queryBaseCategoryIdByFontCategoryId(fcid);
        List<XylFontCategoryAttrPO> xylFontCategoryAttrList= xylFontCategoryAttrPOMapper.queryCategoryAttrByBcidListAndFcid(bcidList,fcid);
        String attrSql = null;
        if(xylFontCategoryAttrList.size()>0){
            StringBuffer  sb = new StringBuffer ();
            sb.append("and (");
            for(int i=0,len=xylFontCategoryAttrList.size();i<len;i++){
                if(i>0){
                    sb.append(" or ");
                }
                sb.append("(attr_name='").append(xylFontCategoryAttrList.get(i).getAttrName()).append("' and attr_value_name='").append(xylFontCategoryAttrList.get(i).getAttrValName()).append("')");
            }
            sb.append(")");
            attrSql = sb.toString();
        }
        List<String> productIdList = xylProductAttrPOMapper.queryProductIdsByAttrAndBcidList(attrSql,bcidList);
        List<XylProductPO> xylProductPOList = xylProductPOMapper.queryProductListByProductIds(productIdList);
        if(xylProductPOList.size()>0){
            for(XylProductPO xylProductPO : xylProductPOList){
                ProductVo productVo = new ProductVo();
                productVo.setProductId(xylProductPO.getProductId());
                productVo.setProductName(xylProductPO.getName());
                productVo.setPrice(xylProductPO.getPrice());
                productVo.setOriginPrice(xylProductPO.getOriginPrice());
                productVo.setSmallPic(xylProductPO.getSmallPic());
                resultList.add(productVo);
            }
            return ServerResponse.createBySuccess(resultList);
        }
        return ServerResponse.createByErrorMessage("商品数据为空");
    }
}
