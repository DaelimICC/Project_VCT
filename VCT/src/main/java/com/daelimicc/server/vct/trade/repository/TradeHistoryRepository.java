package com.daelimicc.server.vct.trade.repository;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TradeHistoryRepository extends MongoRepository<TradeHistory, String> {
}
