package com.daelimicc.server.vct.coin.repository;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinHistoryRepository extends MongoRepository<CoinHistory, String> {

}
