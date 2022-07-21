package com.daelimicc.server.vct.trade.repository;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TradeHistoryRepository extends MongoRepository<TradeHistory, String> {
    List<TradeHistory> findByTradeUserId(String userId);
}
