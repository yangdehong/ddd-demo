package com.ydh.redsheep.web;

import com.ydh.redsheep.application.TransferService;
import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.types.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("transfer")
    public String transfer() {
        try {
            Result<Boolean> cny = transferService.transfer(1L, "1234567890", new BigDecimal(100), "CNY");
            System.out.println(cny);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        } catch (DailyLimitExceededException e) {
            e.printStackTrace();
        }
        return "false";
    }

}
