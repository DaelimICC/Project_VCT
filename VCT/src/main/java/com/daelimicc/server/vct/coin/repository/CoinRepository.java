package com.daelimicc.server.vct.coin.repository;

import com.daelimicc.server.vct.coin.domain.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, String> {
    Coin findByCoinName(String coinName);
    void deleteByCoinName(String coinName);
}
