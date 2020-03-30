package com.springcloud.goods_service.util;


import com.springcloud.goods_service.entity.Goods;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据
 * */
public class MockData {
    //模拟商品数据
    public static final Map<Long, Goods> goodsMap= new HashMap<>();

    //添加模拟数据
    static{
        goodsMap.put(1L,new Goods(1L,"小米10手机",3000,"深圳","1.jpg"));
        goodsMap.put(2L,new Goods(2L,"华为P30手机",5000,"广州","2.jpg"));
        goodsMap.put(3L,new Goods(3L,"ThinkPad电脑",5000,"上海","3.jpg"));
        goodsMap.put(4L,new Goods(4L,"dell电脑",6000,"北京","4.jpg"));
    }
}