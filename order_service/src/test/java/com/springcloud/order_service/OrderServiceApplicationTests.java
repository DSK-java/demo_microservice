package com.springcloud.order_service;

import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.entity.JsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetList(){
        JsonResult result = restTemplate.getForObject("http://goods-service/test", JsonResult.class);
        System.out.println("调用结果"+result);
        JsonResult result2 = restTemplate.getForObject("http://goods-service/test/{1}",
                JsonResult.class,888L);
        System.out.println("带参数的查询："+result2);
    }

    @Test
    public void testGetList2(){
        ResponseEntity<JsonResult> result =
                restTemplate.getForEntity("http://goods-service/test",
                        JsonResult.class);
        System.out.println("调用结果"+result.getBody());
    }

    @Test
    public void testPost(){
        Goods goods = new Goods(999L,"测试商品",999,"xxx","");
       JsonResult result =  restTemplate.postForObject("http://goods-service/test",goods,JsonResult.class);
       System.out.println("Post结果："+result);
       ResponseEntity<JsonResult> entity =
               restTemplate.postForEntity("http://goods-service/test",goods,JsonResult.class);
       System.out.println("Post结果："+entity.getBody());
    }

    @Test
    public void testPut(){
        Goods goods = new Goods(999L,"测试商品",999,"xxx","");
     //   restTemplate.put("http://goods-service",goods);
        StringBuilder url = new StringBuilder("http://goods-service/test?");
        url.append("id={id}&");
        url.append("name={name}&");
        url.append("price={price}&");
        url.append("address={address}&");
        url.append("image={image}");
        Map<String,Object> map = new HashMap<>();
        map.put("id",goods.getId());
        map.put("name",goods.getName());
        map.put("price",goods.getAddress());
        map.put("address",goods.getAddress());
        map.put("image",goods.getImage());
        //3\创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //4\创建请求实体
        HttpEntity<Goods> entity=new HttpEntity<>(goods,headers);
        //5.调用put接口
        ResponseEntity<JsonResult> entity1 = restTemplate.exchange(url.toString(), HttpMethod.PUT, entity, JsonResult.class, map);
        System.out.println("put请求:"+entity1.getBody());
    }

    @Test
    public void testDelect(){
        restTemplate.delete("http://goods-service/test/{1}",777L);
        ResponseEntity<JsonResult> entity = restTemplate.exchange("http://goods-service/test/{1}", HttpMethod.DELETE,null,
                JsonResult.class,777L);
        System.out.println("返回结果："+entity.getBody());
    }
}
