package com.springcloud.order_service.service;

import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.entity.Order;
import com.springcloud.order_service.feign.GoodsServiceFeignClient;
import com.springcloud.order_service.util.MockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 商品业务逻辑
 * */
@Service
public class OrderService {


  //private GoodsService goodsService;
    @Autowired
    private GoodsServiceFeignClient goodsServiceFeignClient;

    public Order findOrderById(Long id){
        Order order = MockData.orderMap.get(id);
        if(order == null){
            return null;
        }
        //调用商品服务获得商品信息
        Set<Long> goodsIds = order.getGoods().keySet();
        //遍历所有商品编号
        for(Long gId : goodsIds){
            //远程调用商品服务查询商品
 //         Goods goods = goodsService.findGoodsById(gId);
            Goods goods = goodsServiceFeignClient.findGoods(gId);
            //将查询的商品，添加到商品集合
            order.getGoods().put(gId,goods);
        }

        return order;
    }
}
