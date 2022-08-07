package com.daelimicc.server.vct.coin.repository;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoinHistoryRepository extends MongoRepository<CoinHistory, String> {
    List<CoinHistory> findByCoinName(String coinName);

    List<CoinHistory> findByCrtDttmLike(String crtDt);

    List<CoinHistory> findByCoinNameAndCrtDttmLike(String coinName, String crtDt);

    CoinHistory findTop1ByCoinNameOrderByCrtDttmDesc(String coinName);
}
