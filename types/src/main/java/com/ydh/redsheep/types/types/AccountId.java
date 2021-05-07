package com.ydh.redsheep.types.types;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountId {

    private Long value;

    public AccountId(Long value) {
        this.value = value;
    }

}



