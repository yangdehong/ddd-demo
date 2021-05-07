package com.ydh.redsheep.types.types;

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
