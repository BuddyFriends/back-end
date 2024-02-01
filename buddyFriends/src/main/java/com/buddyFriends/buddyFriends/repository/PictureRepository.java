package com.buddyFriends.buddyFriends.repository;

import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<PictureEntity, String> {

    List<PictureEntity> findByPetId(PetEntity petId);
}
