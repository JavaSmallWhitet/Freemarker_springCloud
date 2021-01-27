package com.study.seata.service;

public interface OrderService {

    /**
     * 下订单
     *
     * @param userId 用户id
     * @param productId 产品id
     * @return 订单id
     * @throws Exception 创建订单失败，抛出异常
     */
    Integer createOrder(Integer userId, Integer productId) throws Exception;

}
