package com.buddyFriends.buddyFriends.repository;

import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<PetEntity, String> {

    List<PetEntity> findByUserId(UserEntity user);

    Optional<PetEntity> findByPetId(Integer petId);
}
