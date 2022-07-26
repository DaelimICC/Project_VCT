package com.daelimicc.server.vct.status.repository;

import com.daelimicc.server.vct.status.domain.CoinStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinStatusRepository extends MongoRepository<CoinStatus, String> {
}
