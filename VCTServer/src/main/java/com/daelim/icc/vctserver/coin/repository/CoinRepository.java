package com.daelim.icc.vctserver.coin.repository;

import com.daelim.icc.vctserver.coin.entity.Coin;
import com.daelim.icc.vctserver.constdata.CoinList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, CoinList> {

}
