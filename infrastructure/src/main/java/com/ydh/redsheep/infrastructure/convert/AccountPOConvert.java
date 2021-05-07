package com.ydh.redsheep.infrastructure.convert;

import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.infrastructure.entity.AccountPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
* 持久化PO 和 领域对象DO互转
* @author : yangdehong
* @date : 2021/5/4 10:21
*/
@Mapper
public interface AccountPOConvert {

    AccountPOConvert INSTANCE = Mappers.getMapper(AccountPOConvert.class);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "accountNumber.value", target = "accountNumber")
    @Mapping(source = "userId.id", target = "userId")
    @Mapping(source = "available.amount", target = "availableAmout")
    @Mapping(source = "dailyLimit.amount", target = "dailyLimitAmout")
    @Mapping(source = "currency.value", target = "currency")
    AccountPO accountDO2AccountPO(AccountDO accountDO);

    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "accountNumber.value", source = "accountNumber")
    @Mapping(target = "userId.id", source = "userId")
    @Mapping(target = "available.amount", source = "availableAmout")
    @Mapping(target = "dailyLimit.amount", source = "dailyLimitAmout")
    @Mapping(target = "currency.value", source = "currency")
    AccountDO accountPO2AccountDO(AccountPO accountPO);

}
