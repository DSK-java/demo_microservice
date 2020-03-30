package com.springcloud.order_service.util;

import com.springcloud.order_service.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据
 * */
public class MockData {
    public static final Map<Long, Order> orderMap = new HashMap<>();

    static{
        //添加订单数据
        Order order1 = new Order(1L, "2020-1-1 18:00:00", 1001L);
        order1.getGoods().put(1L,null);//只添加商品编号
        order1.getGoods().put(2L,null);
        orderMap.put(1L, order1);


        Order order2 = new Order(2L, "2020-2-1 18:00:00", 1002L);
        order2.getGoods().put(3L,null);//只添加商品编号
        order2.getGoods().put(4L,null);
        orderMap.put(2L, order2);
    }
}
