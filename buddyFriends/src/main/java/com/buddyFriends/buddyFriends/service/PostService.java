package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.PostDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PetRepository petRepository;

    public PostService(PostRepository postRepository, PetRepository petRepository) {
        this.postRepository = postRepository;
        this.petRepository=petRepository;
    }

    @Transactional
    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PostEntity getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void deletePost(Long postId) {
        PostEntity post = getPost(postId);
        postRepository.delete(post);
    }

    @Transactional
    public PostEntity updatePost(Long postId, PostDto postDetailsDto) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다. " + postId));

        if (postDetailsDto.getTitle() != null) post.setTitle(postDetailsDto.getTitle());
        if (postDetailsDto.getContent() != null) post.setContent(postDetailsDto.getContent());
        if (postDetailsDto.getPeriodStart() != null) post.setPeriodStart(postDetailsDto.getPeriodStart());
        if (postDetailsDto.getPeriodEnd() != null) post.setPeriodEnd(postDetailsDto.getPeriodEnd());
        if (postDetailsDto.getPickId() != null) post.setPickId(postDetailsDto.getPickId());

        post.setHelperSex(postDetailsDto.isHelperSex());
        post.setDone(postDetailsDto.isDone());
        post.setCareDone(postDetailsDto.isCareDone());

        /*
        if (postDetailsDto.getPetId() != null) {
            PetEntity pet = petRepository.findById(postDetailsDto.getPetId())
                    .orElseThrow(() -> new EntityNotFoundException("반려동물을 찾을 수 없습니다" + postDetailsDto.getPetId()));
            post.setPetId(pet);
        }
         */

        return postRepository.save(post);
    }

}


