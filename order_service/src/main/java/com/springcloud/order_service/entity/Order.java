package com.springcloud.order_service.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单实体类
 * */
public class Order {

    private Long id;
    private String time;
    private Long userId;
    private Map<Long,Goods> goods = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Goods> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Goods> goods) {
        this.goods = goods;
    }


    public Order(Long id, String time, Long userId) {
        this.id = id;
        this.time = time;
        this.userId = userId;
    }

    public Order() {
    }
}
