package com.springcloud.order_service.controller;


import com.springcloud.order_service.entity.Order;
import com.springcloud.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务控制器
 * */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "{orderId}",method = RequestMethod.GET)
    public Order findOrder(@PathVariable("orderId") Long orderId){
        return orderService.findOrderById(orderId);
    }
}
