package com.daelimicc.server.vct.user.repository;

import com.daelimicc.server.vct.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
