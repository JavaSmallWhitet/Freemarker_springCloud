package com.study.seata.mode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Account
 * @author JIAYUTAO
 * @create 2021-01-22 15:05
 * @desc
 *
 **/
public class Account {
    private int id;
    private int userId;
    private BigDecimal balance;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                ", updateTime=" + updateTime +
                '}';
    }
}