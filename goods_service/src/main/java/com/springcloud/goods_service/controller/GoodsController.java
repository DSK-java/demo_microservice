package com.springcloud.goods_service.controller;

import com.springcloud.goods_service.entity.Goods;
import com.springcloud.goods_service.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品服务控制器
 * */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "{goodsId}",method = RequestMethod.GET)
    public Goods findGoods(@PathVariable("goodsId") Long goodsId){
        Goods goods = goodsService.findGoodsById(goodsId);
        goods.setAddress("From----->" + port);
        return goods;

    }
}
