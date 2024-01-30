package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.UserDto;
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
            return userRepository.save(user).getUserId();
        }
    }

    public String login(UserDto userDto) {

        Optional<UserEntity> findUser = userRepository.findByUserId(userDto.getUserId());

        if(!findUser.isPresent()){
            return "존재하지 않는 ID 입니다.";
        } else if(findUser.get().getPassword().equals(userDto.getPassword())){
            return "비밀번호가 일치하지 않습니다.";
        } else{
            return findUser.get().getUserId();
        }
    }
}
