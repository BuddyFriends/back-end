package com.buddyFriends.buddyFriends.repository;

import com.buddyFriends.buddyFriends.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUserId(String userId);
}
