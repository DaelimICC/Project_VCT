package com.daelimicc.server.vct.userinterest.repository;

import com.daelimicc.server.vct.userinterest.domain.UserInterest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInterestRepository extends MongoRepository<UserInterest, String> {


}
