package com.daelim.icc.vctserver.auth.repository;

import com.daelim.icc.vctserver.auth.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
