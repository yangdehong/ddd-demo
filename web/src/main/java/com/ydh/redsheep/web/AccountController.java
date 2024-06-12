package com.ydh.redsheep.web;

import com.ydh.redsheep.application.TransferService;
import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private TransferService transferService;

    @GetMapping("/test")
    public void test() {
        try {
            transferService.transfer(1L, "abc", BigDecimal.TEN, "CNY");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (DailyLimitExceededException e) {
            throw new RuntimeException(e);
        }
    }

}
