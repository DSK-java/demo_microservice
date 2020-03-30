package com.springcloud.goods_service.controller;

import com.springcloud.goods_service.entity.Goods;
import com.springcloud.goods_service.entity.JsonResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public JsonResult list(){
        return new JsonResult(200,"查询所有数据",null);
    }

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable("id")int id){
        return new JsonResult(200,"查询单条数据"+id,id);
    }

    @PostMapping
    public JsonResult addGoods(@RequestBody Goods goods){
        return new JsonResult(200,"添加商品",goods);
    }

    @PutMapping
    public JsonResult putGoods(@RequestBody Goods goods){
        System.out.println("更新商品："+goods);
        return new JsonResult(200,"更新商品",goods);
    }

    @DeleteMapping("{id}")
    public JsonResult deleteGoods(@PathVariable("id")int id){
        System.out.println("删除商品："+id);
        return new JsonResult(200,"删除商品",id);
    }

    @PostMapping("/login")
    public JsonResult login(@RequestParam("username")String username,
                            @RequestParam("password")String password){
        return new JsonResult(200,"登录成功","账号："+username+",密码:"+password);
    }

    @PostMapping("/register")
    public JsonResult register(@RequestHeader("username")String username,
                               @RequestHeader("password")String password){
        return new JsonResult(200,"注册成功","账号："+username+",密码:"+password);
    }
}
