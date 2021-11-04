package com.ydh.redsheep.core.domain.types;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserId {

    private Long id;

    public UserId(Long id) {
        this.id = id;
    }

}
