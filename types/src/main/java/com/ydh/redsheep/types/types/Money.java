package com.ydh.redsheep.types.types;

import com.ydh.redsheep.types.exception.MoneyAmountNotNullException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Money {

    private BigDecimal amount;

    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {

        if (amount == null){
            throw new MoneyAmountNotNullException("金额不能为空");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public int compareTo(Money money) {
        return this.amount.compareTo(money.getAmount());
    }

    public Money subtract(Money money) throws Exception {
        BigDecimal resultAmout = this.amount.subtract(money.getAmount());
        return new Money(resultAmout, this.currency);
    }


    public Money add(Money money) throws MoneyAmountNotNullException {
        BigDecimal resultAmout = this.amount.add(money.getAmount());
        return new Money(resultAmout, this.currency);
    }
}
