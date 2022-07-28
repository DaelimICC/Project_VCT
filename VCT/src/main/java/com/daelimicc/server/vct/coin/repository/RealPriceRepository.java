package com.daelimicc.server.vct.coin.repository;

import com.daelimicc.server.vct.coin.domain.RealPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RealPriceRepository extends MongoRepository<RealPrice, String> {

}

