package com.ydh.redsheep.infrastructure.repository.impl;

import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.domain.repository.AccountRepository;
import com.ydh.redsheep.infrastructure.convert.AccountPOConvert;
import com.ydh.redsheep.infrastructure.entity.AccountPO;
import com.ydh.redsheep.infrastructure.dao.AccountMapper;
import com.ydh.redsheep.types.exception.BusinessException;
import com.ydh.redsheep.types.types.AccountId;
import com.ydh.redsheep.types.types.AccountNumber;
import com.ydh.redsheep.types.types.UserId;
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
