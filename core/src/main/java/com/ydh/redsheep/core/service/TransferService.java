package com.ydh.redsheep.core.service;

import com.ydh.redsheep.core.common.Result;
import com.ydh.redsheep.core.common.exception.DailyLimitExceededException;

import java.math.BigDecimal;

public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException;

}