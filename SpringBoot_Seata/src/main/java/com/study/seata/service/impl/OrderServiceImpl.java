package com.study.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;

import com.study.seata.mappers.OrdersMapper;
import com.study.seata.mode.Orders;
import com.study.seata.mode.Product;
import com.study.seata.service.AccountService;
import com.study.seata.service.OrderService;
import com.study.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;


    @DS(value = "order-ds")
    @GlobalTransactional //seata全局事务注解
    public Integer createOrder(Integer userId, Integer productId) throws Exception {
        Integer amount = 1; // 购买数量暂时设置为 1

        log.info("当前 XID: {}", RootContext.getXID());


        // 减库存 - 远程服务
        Product product = productService.reduceStock(productId, amount);

        // 减余额 - 远程服务
        accountService.reduceBalance(userId, product.getPrice());


        // 下订单 - 本地下订单
        Orders order = new Orders();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setPayAmount(product.getPrice().multiply(new BigDecimal(amount)));

        ordersMapper.insertSelective(order);

        log.info("下订单: {}", order.getId());

        int m = 1 / 0;
        // 返回订单编号
        return order.getId();
    }
}
