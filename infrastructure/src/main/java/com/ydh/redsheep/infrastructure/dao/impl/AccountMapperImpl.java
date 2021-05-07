package com.ydh.redsheep.infrastructure.dao.impl;

import com.ydh.redsheep.infrastructure.entity.AccountPO;
import com.ydh.redsheep.infrastructure.dao.AccountMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountMapperImpl implements AccountMapper {
    @Override
    public int insert(AccountPO accountPO) {
        System.err.println("------------------插入:"+ accountPO);
        return 0;
    }

    @Override
    public int update(AccountPO accountPO) {
        System.err.println("------------------更新:"+ accountPO);
        return 0;
    }

    @Override
    public AccountPO selectByUserId(Long id) {
        return new AccountPO(1L, "1234567890", 1L, new BigDecimal(100), new BigDecimal(100), "CNY");
    }

    @Override
    public AccountPO selectByAccountNumber(String accountNumber) {
        return new AccountPO(1L, "1234567890", 1L, new BigDecimal(100), new BigDecimal(100), "CNY");
    }

    @Override
    public AccountPO selectById(Long id) {
        return new AccountPO(1L, "1234567890", 1L, new BigDecimal(100), new BigDecimal(100), "CNY");
    }
}
