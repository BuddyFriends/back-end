package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.UserDto;
import com.buddyFriends.buddyFriends.base.projection.GetUser;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
                .smell(userDto.getSmell())
                .grade(userDto.getGrade())
                .build();

        Optional<UserEntity> findUser = userRepository.findByUserId(user.getUserId());
        if(findUser.isPresent()){
            return "이미 사용 중인 ID입니다.";
        } else {
            return "200";
        }
    }

    //로그인
    public GetUser login(UserDto userDto) {

        Optional<UserEntity> findUser = userRepository.findByUserId(userDto.getUserId());

        return entityToProjectionUser(findUser);
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
        };
        return userInfo;
    }
}
