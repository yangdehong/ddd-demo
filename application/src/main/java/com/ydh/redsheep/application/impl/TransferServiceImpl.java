package com.ydh.redsheep.application.impl;

import com.ydh.redsheep.application.TransferService;
import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.domain.domain.service.AccountTransferService;
import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.domain.external.ExchangeRateService;
import com.ydh.redsheep.domain.repository.AccountRepository;
import com.ydh.redsheep.types.common.Result;
import com.ydh.redsheep.types.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountRepository accountRepository;
//    @Autowired
//    private AuditMessageProducer auditMessageProducer;
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private AccountTransferService accountTransferService;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException {
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        AccountDO sourceAccountDO = accountRepository.find(new UserId(sourceUserId));

        AccountDO targetAccountDO = accountRepository.find(new AccountNumber(targetAccountNumber));

        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccountDO.getCurrency(), targetMoney.getCurrency());

        accountTransferService.transfer(sourceAccountDO, targetAccountDO, targetMoney, exchangeRate);

        accountRepository.save(sourceAccountDO);

        accountRepository.save(targetAccountDO);

        // 发送审计消息
//        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
//        auditMessageProducer.send(message);

        return Result.success(true);
    }
}
