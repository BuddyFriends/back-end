package com.buddyFriends.buddyFriends.repository;

import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    //findIdColulmns
    //findByUserId

    List<PostEntity> findByUserId(UserEntity user);

    List<PostEntity> findAll();
    List<PostEntity> findByPetId_Species(String species);

    Optional<PostEntity> findByPostId(Long postId);
}
