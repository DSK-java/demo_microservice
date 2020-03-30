package com.springcloud.order_service.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.order_service.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 调用商品服务类
 * */
@Service
public class GoodsService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询商品
     * @param id
     * @return
     * */
    @HystrixCommand(fallbackMethod = "findGoodsByIdFallback")
    public Goods findGoodsById(Long id){
        //调用商品微服务,获得商品对象
        String host = "http://goods-service/goods/";
        Goods goods = restTemplate.getForObject(host + id, Goods.class);
        return goods;
    }

    public Goods findGoodsByIdFallback(Long id){
        Goods goods = new Goods(-1L,"Error",0,"Error","Error");
        return goods;
    }

}
