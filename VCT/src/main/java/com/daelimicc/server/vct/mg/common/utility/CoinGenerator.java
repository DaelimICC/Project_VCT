package com.daelimicc.server.vct.mg.common.utility;

import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoinGenerator {
    private CoinRepository coinRepository;
    private CoinHistoryRepository coinHistoryRepository;
}
