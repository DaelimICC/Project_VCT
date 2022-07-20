package com.daelimicc.server.vct.coin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin")
public class CoinController {

    // Test Method
    @GetMapping("")
    public String getCoin() {
        return "coin";
    }
}
