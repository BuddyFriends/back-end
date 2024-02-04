package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public ApplicantService(ApplicantRepository applicantRepository, PostRepository postRepository, UserRepository userRepository) {
        this.applicantRepository = applicantRepository;
        this.postRepository=postRepository;
        this.userRepository=userRepository;
    }

    @Transactional(readOnly = true)
    public List<ApplicantEntity> getApplicantsByUser(Long postId) {
        PostEntity user = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + postId));
        return applicantRepository.findByPostId(user.getPostId());
    }



}

