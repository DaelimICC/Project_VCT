package com.daelimicc.server.vct.status.controller;

import com.daelimicc.server.vct.status.dto.CoinStatusDTO;
import com.daelimicc.server.vct.status.repository.CoinStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class CoinStatusController {
    private final CoinStatusRepository coinStatusRepository;

    @PostMapping("")
    public void saveCoinStatus(@RequestBody CoinStatusDTO coinStatusDTO) {
        coinStatusRepository.save(coinStatusDTO.toEntity());
    }


}
