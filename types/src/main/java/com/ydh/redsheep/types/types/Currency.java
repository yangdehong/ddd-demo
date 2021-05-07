package com.ydh.redsheep.types.types;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Currency {

    private String value;

    public Currency(String value) {
        if (value == null || "".equals(value)){
            throw new IllegalArgumentException("货币不能为空");
        }
        this.value = value;
    }

}
