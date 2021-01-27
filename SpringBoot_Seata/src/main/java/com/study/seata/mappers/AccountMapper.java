package com.study.seata.mappers;


import com.study.seata.mode.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    Account selectAccountByUserId(Integer userId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int reduceBalance(@Param("userId") Integer userId, @Param("money") BigDecimal money);
}
