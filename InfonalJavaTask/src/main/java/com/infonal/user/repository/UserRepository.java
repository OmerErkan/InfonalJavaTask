package com.infonal.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.infonal.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByName(String name);
}
