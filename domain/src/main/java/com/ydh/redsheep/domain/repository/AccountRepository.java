package com.ydh.redsheep.domain.repository;


import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.types.types.AccountId;
import com.ydh.redsheep.types.types.AccountNumber;
import com.ydh.redsheep.types.types.UserId;

public interface AccountRepository {
    AccountDO find(AccountId id) throws Exception;
    AccountDO find(AccountNumber accountNumber) throws Exception;
    AccountDO find(UserId userId) throws Exception;
    AccountDO save(AccountDO accountDO) throws Exception;
}
