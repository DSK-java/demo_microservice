package com.springcloud.order_service.feign;

import com.springcloud.order_service.entity.Goods;
import com.springcloud.order_service.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "goods-service",path ="/test")
public interface TestFeingClient {
    @GetMapping
    JsonResult list();

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable("id")int id);

    @PostMapping
    public JsonResult addGoods(@RequestBody Goods goods);

    @PostMapping("/login")
    public JsonResult login(@RequestParam("username")String username,
                            @RequestParam("password")String password);

    @PostMapping("/register")
    public JsonResult register(@RequestHeader("username")String username,
                               @RequestHeader("password")String password);
}
