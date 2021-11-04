package com.ydh.redsheep.core.infrastructure.repository.impl;

import com.ydh.redsheep.core.common.exception.BusinessException;
import com.ydh.redsheep.core.domain.entity.AccountDO;
import com.ydh.redsheep.core.domain.repository.AccountRepository;
import com.ydh.redsheep.core.domain.types.AccountId;
import com.ydh.redsheep.core.domain.types.AccountNumber;
import com.ydh.redsheep.core.domain.types.UserId;
import com.ydh.redsheep.core.infrastructure.convert.AccountPOConvert;
import com.ydh.redsheep.core.infrastructure.mapper.AccountMapper;
import com.ydh.redsheep.core.infrastructure.entity.AccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountDO find(AccountId id) throws Exception {
        AccountPO accountPO = accountMapper.selectById(id.getValue());
        return AccountPOConvert.INSTANCE.accountPO2AccountDO(accountPO);
    }

    @Override
    public AccountDO find(AccountNumber accountNumber) throws Exception {
        AccountPO accountPO = accountMapper.selectByAccountNumber(accountNumber.getValue());
        if (accountPO == null) {
            throw new BusinessException(String.format("账户[%s]不存在", accountNumber.getValue()));
        }
        return AccountPOConvert.INSTANCE.accountPO2AccountDO(accountPO);
    }

    @Override
    public AccountDO find(UserId userId) throws Exception {
        AccountPO accountPO = accountMapper.selectByUserId(userId.getId());
        if (accountPO == null) {
            throw new BusinessException("账户不存在");
        }
        return AccountPOConvert.INSTANCE.accountPO2AccountDO(accountPO);
    }

    @Override
    public AccountDO save(AccountDO accountDO) throws Exception {
        AccountPO accountPO = AccountPOConvert.INSTANCE.accountDO2AccountPO(accountDO);
        if (accountPO.getId() == null) {
            accountMapper.insert(accountPO);
        } else {
            accountMapper.update(accountPO);
        }
        return AccountPOConvert.INSTANCE.accountPO2AccountDO(accountPO);
    }

}
