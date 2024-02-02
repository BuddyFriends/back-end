package com.buddyFriends.buddyFriends.repository;

import com.buddyFriends.buddyFriends.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    //findIdColulmns
    //findByUserId

}
