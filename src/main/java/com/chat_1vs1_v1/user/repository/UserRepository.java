package com.chat_1vs1_v1.user.repository;

import com.chat_1vs1_v1.user.entity.Status;
import com.chat_1vs1_v1.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
