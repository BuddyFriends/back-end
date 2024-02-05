package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.post.PostDto;
import com.buddyFriends.buddyFriends.base.dto.post.SimplifiedPostDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    //게시글 작성
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
                .helperSex(postDto.getHelperSex())
                .done(false)
                .pickId("Null")
                .careDone(false)
                .smellDone(false)
                .build();

        postRepository.save(post);

        return "200";
    }

    //게시글 조회
    public List<PostEntity> getPostsByPetSpecies(String species) {

        if(species.equals("all")) {
            List<PostEntity> list = postRepository.findAll();
            return list;
        } else {
            List<PostEntity> list = postRepository.findByPetId_Species(species);
            return list;
        }
    }

    //게시글 상세페이지 조회
    public PostEntity getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }

    public String selectApplicant(Long postId, String userId) {
        Optional<UserEntity> findUser = userRepository.findByUserId(userId);
        Optional<PostEntity> findPost = postRepository.findByPostId(postId);

        findPost.get().setDone(true);
        findPost.get().setPickId(userId);

        postRepository.save(findPost.get());

        return "200";
    }

    // 로그 조회
     public List<SimplifiedPostDto> getLog(boolean careDone, String userId, String role) {
        List<PostEntity> posts;
        if ("buddy".equals(role)) {
            UserEntity user = userRepository.findByUserId(userId)
                    .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다 " + userId));
            posts = postRepository.findByCareDoneAndUserId(careDone, user);
        } else {
            posts = postRepository.findByCareDoneAndPickId(careDone, userId);
        }

        return posts.stream().map(post -> new SimplifiedPostDto(
                post.getPostId(),
                post.getUserId().getUserId(),
                post.getUserId().getNickName(),
                post.getUserId().getSmell(),
                post.getUserId().getGrade(),
                post.getPetId().getPetId(),
                post.getPetId().getPetName(),
                post.getPetId().getPetImage(),
                post.getTitle(),
                post.getContent(),
                post.getPeriodStart(),
                post.getPeriodEnd(),
                post.getHelperSex(),
                post.isDone(),
                post.getPickId(),
                post.isCareDone(),
                post.isSmellDone()
        )).collect(Collectors.toList());
    }

    //케어 완료
    public String careDone(Long postId) {
        Optional<PostEntity> findPost = postRepository.findByPostId(postId);

        findPost.get().setCareDone(true);

        postRepository.save(findPost.get());

        return "200";
    }

    public String smellDone(Long postId) {
        Optional<PostEntity> findPost = postRepository.findByPostId(postId);

        findPost.get().setSmellDone(true);

        postRepository.save(findPost.get());

        return "200";
    }
}


