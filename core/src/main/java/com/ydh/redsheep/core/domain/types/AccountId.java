package com.ydh.redsheep.core.domain.types;

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



