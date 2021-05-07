package com.ydh.redsheep.application;

import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.types.common.Result;

import java.math.BigDecimal;

public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException;

}