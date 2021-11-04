package com.ydh.redsheep.core.domain.repository;


import com.ydh.redsheep.core.domain.entity.AccountDO;
import com.ydh.redsheep.core.domain.types.AccountId;
import com.ydh.redsheep.core.domain.types.AccountNumber;
import com.ydh.redsheep.core.domain.types.UserId;

public interface AccountRepository {
    AccountDO find(AccountId id) throws Exception;
    AccountDO find(AccountNumber accountNumber) throws Exception;
    AccountDO find(UserId userId) throws Exception;
    AccountDO save(AccountDO accountDO) throws Exception;
}
