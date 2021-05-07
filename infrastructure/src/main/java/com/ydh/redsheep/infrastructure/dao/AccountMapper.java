package com.ydh.redsheep.infrastructure.dao;

import com.ydh.redsheep.infrastructure.entity.AccountPO;

public interface AccountMapper {
    int insert(AccountPO accountPO);

    int update(AccountPO accountPO);

    AccountPO selectByUserId(Long id);

    AccountPO selectByAccountNumber(String accountNumber);

    AccountPO selectById(Long id);
}
