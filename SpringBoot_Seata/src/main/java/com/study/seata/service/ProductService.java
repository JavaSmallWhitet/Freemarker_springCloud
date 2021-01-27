package com.study.seata.service;


import com.study.seata.mode.Product;

public interface ProductService {

    /**
     * 减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    Product reduceStock(Integer productId, Integer amount) throws Exception;

}
