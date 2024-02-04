package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.ApplicantDto;
import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public String apply (ApplicantDto applicantDto) {
        Optional<PostEntity> findPost = postRepository.findByPostId(applicantDto.getPostId());
        Optional<UserEntity> findUser = userRepository.findByUserId(applicantDto.getUserId());

        ApplicantEntity applicant = ApplicantEntity.builder()
                .postId(findPost.get())
                .userId(findUser.get())
                .build();

        applicantRepository.save(applicant);

        return "200";
    }

    public List<ApplicantEntity> getApplicantsList(Long postId) {

        Optional<PostEntity> findPost = postRepository.findById(postId);

        List<ApplicantEntity> list = applicantRepository.findByPostId(findPost.get());

        return list;
    }
    public List<ApplicantEntity> getApplicantsByPostId(Long postId) {
        return applicantRepository.findByPostId_PostId(postId);
    }


}

