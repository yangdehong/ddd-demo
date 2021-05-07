package com.ydh.redsheep.domain.domain.entity;

import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.domain.exception.InsufficientFundsException;
import com.ydh.redsheep.types.exception.InvalidCurrencyException;
import com.ydh.redsheep.types.exception.MoneyAmountNotNullException;
import com.ydh.redsheep.types.types.*;
import lombok.Data;

@Data
public class AccountDO {

    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    private Currency currency;

    // 转出
    public void withdraw(Money money) throws Exception, DailyLimitExceededException {
        if (this.available.compareTo(money) < 0){
            throw new InsufficientFundsException();
        }

        if (this.dailyLimit.compareTo(money) < 0){
            throw new DailyLimitExceededException();
        }

        this.available = this.available.subtract(money);
    }

    // 转入
    public void deposit(Money money) throws InvalidCurrencyException, MoneyAmountNotNullException {
       if (!this.getCurrency().equals(money.getCurrency())){
           throw new InvalidCurrencyException();
       }

       this.available = this.available.add(money);

    }
}
