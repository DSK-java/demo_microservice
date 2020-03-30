package com.springcloud.order_service.fallback;


import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.feign.GoodsServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class GoodsServiceFeignFallback implements GoodsServiceFeignClient {

    @Override
    public Goods findGoods(Long goodsId) {
        return new Goods(-1L,"错误数据",0,"shanghai","xxx");
    }
}
