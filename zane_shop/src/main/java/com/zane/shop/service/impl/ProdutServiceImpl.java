package com.zane.shop.service.impl;

import com.google.common.collect.Lists;
import com.zane.shop.common.ServerResponse;
import com.zane.shop.dao.XylProductDescPicPOMapper;
import com.zane.shop.dao.XylProductPOMapper;
import com.zane.shop.dao.XylProductPicPOMapper;
import com.zane.shop.po.XylProductDescPicPO;
import com.zane.shop.po.XylProductPO;
import com.zane.shop.po.XylProductPicPO;
import com.zane.shop.service.IProductService;
import com.zane.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @create 2018-03-20 11:48
 * @desc 商品服务实现类
 **/
@Service("IProductService")
public class ProdutServiceImpl implements IProductService{
    @Autowired
    private XylProductPOMapper xylProductPOMapper;
    @Autowired
    private XylProductPicPOMapper xylProductPicPOMapper;
    @Autowired
    private XylProductDescPicPOMapper xylProductDescPicPOMapper;
    @Override
    public ServerResponse<ProductVo> getProductBaseInfo(String productId) {
        XylProductPO xylProductPO = xylProductPOMapper.queryProductByProductId(productId);
        if(xylProductPO!=null){
            ProductVo productVo = new ProductVo();
            productVo.setProductId(xylProductPO.getProductId());
            productVo.setTitle(xylProductPO.getName());
            productVo.setSubTitle(xylProductPO.getSubName());
            productVo.setPrice(xylProductPO.getPrice());
            productVo.setOriginPrice(xylProductPO.getOriginPrice());
            List<XylProductPicPO> xylProductPicList =  xylProductPicPOMapper.queryByProductId(xylProductPO.getProductId());
            if(xylProductPicList.size()==0){
                return  ServerResponse.createByErrorMessage("该产品缺少主图信息");
            }
            List<ProductVo.MainPic> mainPicList = Lists.newArrayList();
            for(XylProductPicPO xylProductPicPO : xylProductPicList){
                ProductVo.MainPic mainPic = productVo.new MainPic();
                mainPic.setUrl(xylProductPicPO.getPic());
                mainPic.setAlt(xylProductPicPO.getAlt());
                mainPicList.add(mainPic);
            }
            productVo.setMainPic(mainPicList);

            List<XylProductDescPicPO> xylProductDescPicList = xylProductDescPicPOMapper.queryByProductId(xylProductPO.getProductId());
            ProductVo.DetailInfo detailInfo = productVo.new DetailInfo();
            List<ProductVo.DetailInfo.DetailPic> detailPicList = Lists.newArrayList();
            for(XylProductDescPicPO xylProductDescPicPO : xylProductDescPicList){
                ProductVo.DetailInfo.DetailPic detailPic = detailInfo.new DetailPic();
                detailPic.setUrl(xylProductDescPicPO.getPic());
                detailPic.setAlt(xylProductDescPicPO.getAlt());
                detailPicList.add(detailPic);
            }
            detailInfo.setDetailPic(detailPicList);
            productVo.setDetailInfo(detailInfo);
            return ServerResponse.createBySuccess(productVo);
        }
        return ServerResponse.createByErrorMessage("查询不到该产品");
    }


}
