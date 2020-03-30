package com.springcloud.order_service;

import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.entity.JsonResult;
import com.springcloud.order_service.feign.TestFeingClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FiegnClientTest {

    @Autowired
    private TestFeingClient testFeingClient;

    @Test
    public void testList(){
        JsonResult list = testFeingClient.list();
        System.out.println(list);
    }

    @Test
    public void testFindById(){
        JsonResult goods = testFeingClient.findById(1);
        System.out.println(goods);
    }

    @Test
    public void testAdd(){
        JsonResult jsonResult = testFeingClient.addGoods(
                new Goods(999L,"xxx",2000,"xxx","xxx"));
        System.out.println(jsonResult);
    }

    @Test
    public void testLogin(){
        JsonResult zhangsan = testFeingClient.login("zhangsan","123456");
            System.out.println(zhangsan);
        }

    @Test
    public void testRegister(){
        JsonResult zhangsan = testFeingClient.register("zhangsan","123456");
        System.out.println(zhangsan);
    }
}
