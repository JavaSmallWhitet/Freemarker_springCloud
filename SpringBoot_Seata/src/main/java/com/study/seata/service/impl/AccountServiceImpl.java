package com.study.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.seata.mappers.AccountMapper;
import com.study.seata.mode.Account;
import com.study.seata.service.AccountService;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @DS(value = "account-ds")
    public void reduceBalance(Integer userId, BigDecimal money) throws Exception {
        log.info("当前 XID: {}", RootContext.getXID());

        // 检查余额
        Account account = accountMapper.selectAccountByUserId(userId);
        if (account.getBalance().doubleValue() < money.doubleValue()) {
            throw new Exception("余额不足");
        }

        // 扣除余额
        int updateCount = accountMapper.reduceBalance(userId, money);
        // 扣除成功
        if (updateCount == 0) {
            throw new Exception("余额不足");
        }
        log.info("扣除用户 {} 余额成功", userId);
    }
}
