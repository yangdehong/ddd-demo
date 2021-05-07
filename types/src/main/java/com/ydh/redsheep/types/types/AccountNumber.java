package com.ydh.redsheep.types.types;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountNumber {

    private String value;

    public AccountNumber(String value) {
        if (value == null || "".equals(value)){
            throw new IllegalArgumentException("账号不能为空");
        }
        this.value = value;
    }

}
