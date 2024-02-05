package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.ProfileDto;
import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.entity.PostEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.PostRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostService postService;

    //회원가입
    public String join(UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .nickName(userDto.getNickName())
                .address(userDto.getAddress())
                .sex(userDto.isSex())
                .age(userDto.getAge())
                .intro(userDto.getIntro())
                .chat(userDto.getChat())
                .smell((float)3) // 초기 꼬순내 값은 3으로 지정
                .grade(userDto.getGrade())
                .build();

        Optional<UserEntity> findUser = userRepository.findByUserId(user.getUserId());
        if(findUser.isPresent()){
            return "이미 사용 중인 ID입니다.";
        } else {
            UserEntity createUser = userRepository.save(user);
            return "200";
        }
    }

    //로그인
    public GetUser login(UserDto userDto) {

        Optional<UserEntity> findUser = userRepository.findByUserId(userDto.getUserId());

        return entityToProjectionUser(findUser);
    }

    public String logout(String userId) {

        Optional<UserEntity> findUser = userRepository.findByUserId(userId);

        if(findUser.isPresent()) {
            return "200";
        } else {
            return "회원정보가 존재하지 않습니다.";
        }
    }

    public String editProfile(ProfileDto profileDto) {

        Optional<UserEntity> findUser = userRepository.findByUserId(profileDto.getUserId());

        if(!findUser.isPresent()) {
            return "유저 정보를 찾을 수 없습니다.";
        }

        findUser.get().setUserId(profileDto.getUserId());
        findUser.get().setNickName(profileDto.getNickName());
        findUser.get().setAddress(profileDto.getAddress());
        findUser.get().setSex(profileDto.isSex());
        findUser.get().setAge(profileDto.getAge());
        findUser.get().setIntro(profileDto.getIntro());
        findUser.get().setUserImage(profileDto.getUserImage());


        userRepository.save(findUser.get());

        return "200";
    }

    public String updateSmell(Long postId, String userId, float smell) {

        Optional<PostEntity> findPost = postRepository.findByPostId(postId);
        Optional<UserEntity> findUser = userRepository.findByUserId(userId);

        if(findPost.get().getUserId().equals(userId)) { //버디에게 꼬순내 점수 평가
            float existingSmell = findUser.get().getSmell();

            if(findUser.get().getSmell() == 0) { // 처음 평가 받았을때
                findUser.get().setSmell(smell);
                userRepository.save(findUser.get());

                return "200";
            } else { // 여러번 평가 받았을때
                BigDecimal avgSmell = BigDecimal.valueOf((existingSmell + smell) / 2.0);
                BigDecimal roundedAverage = avgSmell.setScale(1, BigDecimal.ROUND_HALF_UP);
                findUser.get().setSmell(roundedAverage.floatValue());
                userRepository.save(findUser.get());

                return "200";
            }

        } else { //버디 헬퍼를 평가

            float existingSmell = findUser.get().getSmell();

            if(findUser.get().getSmell() == 0) { // 처음 평가 받았을때
                findUser.get().setSmell(smell);

                userRepository.save(findUser.get());
                return "200";
            } else { // 여러번 평가 받았을때
                BigDecimal avgSmell = BigDecimal.valueOf((existingSmell + smell) / 2.0);
                BigDecimal roundedAverage = avgSmell.setScale(1, BigDecimal.ROUND_HALF_UP);
                findUser.get().setSmell(roundedAverage.floatValue());

                userRepository.save(findUser.get());
                return "200";
            }
        }

    }

    //로그인 정보 - 프로젝션 설정
    private GetUser entityToProjectionUser(Optional<UserEntity> user){

        GetUser userInfo = new GetUser() {
            @Override
            public String getUserId() {
                return user.get().getUserId();
            }

            @Override
            public String getUserName() {
                return user.get().getUserName();
            }

            @Override
            public String getUserNickName() {
                return user.get().getNickName();
            }

            @Override
            public String getAddress() {
                return user.get().getAddress();
            }

            @Override
            public boolean getSex() {
                return user.get().isSex();
            }

            @Override
            public Integer getAge() {
                return user.get().getAge();
            }

            @Override
            public String getIntro() {
                return user.get().getIntro();
            }

            @Override
            public String getChat() {
                return user.get().getChat();
            }

            @Override
            public float getSmell() {
                return user.get().getSmell();
            }

            @Override
            public String getGrade() {
                return user.get().getGrade();
            }
        };
        return userInfo;
    }
}
