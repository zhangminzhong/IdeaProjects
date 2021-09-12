package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by AdministratorZhang on 2019/11/3 12:07
 */
@RestController
@RequestMapping(("/buyer/product"))
public class BuyerProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //查询上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目
        //List<Integer> categoryList = new ArrayList<Integer>();
        //传统方法
        /*for(ProductInfo productInfo:productInfoList){
            categoryList.add(productInfo.getCategoryType());
        }*/
        //精简方法，java8的lambda表达式
        List<Integer> categoryList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        //数据拼装
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        List<ProductVO> productVOList= new ArrayList<ProductVO>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setProductInfoVOList(new ArrayList<ProductInfoVO>());
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productVO.getProductInfoVOList().add(productInfoVO);
                }
            }
            productVOList.add(productVO);
        }
        resultVO.setData(productVOList);

        return resultVO;
    }
}
