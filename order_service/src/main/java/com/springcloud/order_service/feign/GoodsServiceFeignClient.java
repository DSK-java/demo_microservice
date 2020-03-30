package com.springcloud.order_service.feign;

import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.fallback.GoodsServiceFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "goods-service",fallback = GoodsServiceFeignFallback.class)
public interface GoodsServiceFeignClient {
    @RequestMapping(value = "/goods/{goodsId}",method = RequestMethod.GET)
    Goods findGoods(@PathVariable("goodsId") Long goodsId);
}
