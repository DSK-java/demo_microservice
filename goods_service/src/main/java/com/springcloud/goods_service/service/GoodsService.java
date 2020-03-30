package com.springcloud.goods_service.service;

import com.springcloud.goods_service.entity.Goods;
import com.springcloud.goods_service.util.MockData;
import org.springframework.stereotype.Service;


/**
 * 商品业务逻辑类
 *
 * */

@Service
public class GoodsService {
    /**
     * 按id查询商品
     * @param id
     * @return
     * */
    public Goods findGoodsById(Long id){
        return MockData.goodsMap.get(id);
    }
}