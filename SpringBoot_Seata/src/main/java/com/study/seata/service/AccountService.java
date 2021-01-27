package com.study.seata.service;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 减余额
     *
     * @param userId 用户id
     * @param money  扣减金额
     * @throws Exception 失败时抛出异常
     */
    void reduceBalance(Integer userId, BigDecimal money) throws Exception;

}
