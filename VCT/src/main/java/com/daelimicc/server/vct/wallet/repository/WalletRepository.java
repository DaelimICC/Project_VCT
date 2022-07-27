package com.daelimicc.server.vct.wallet.repository;

import com.daelimicc.server.vct.wallet.domain.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository  extends MongoRepository<Wallet, String> {

}
