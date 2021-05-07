package com.ydh.redsheep.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountPO {

    private Long id;

    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmout;
    private BigDecimal dailyLimitAmout;
    private String currency;

}
