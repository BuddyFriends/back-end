package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.PostDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, PetRepository petRepository) {
        this.postRepository = postRepository;
        this.petRepository=petRepository;
        this.userRepository=userRepository;
    }

    //게시글 작성
    @Transactional
    public String createPost(PostDto postDto) {
        UserEntity user = userRepository.findByUserId(postDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다 " + postDto.getUserId()));

        PetEntity pet = petRepository.findById(postDto.getPetId().toString())
                .orElseThrow(() -> new EntityNotFoundException("반려동물을 찾을 수 없습니다" + postDto.getPetId()));
        Optional<PetEntity> findPet = petRepository.findByPetId(postDto.getPetId());
        Optional<UserEntity> findUser = userRepository.findByUserId(postDto.getUserId());

        PostEntity post = PostEntity.builder()
                .userId(findUser.get())
                .petId(findPet.get())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .periodStart(postDto.getPeriodStart())
                .periodEnd(postDto.getPeriodEnd())
                .helperSex(postDto.isHelperSex())
                .done(false)
                .pickId("Null")
                .careDone(false)
                .careDone(false)
                .build();

        postRepository.save(post);

        return "200";
    }

    //게시글 조회
    @Transactional(readOnly = true)
    public List<PostEntity> getPostsByPetSpecies(String species) {
        return postRepository.findByPetId_Species(species);
    }

    //게시글 상세페이지 조회
    @Transactional(readOnly = true)
    public PostEntity getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }
}


