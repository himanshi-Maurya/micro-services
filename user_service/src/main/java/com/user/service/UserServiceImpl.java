package com.user.service;

import com.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    //fake User list
    List<User> list = List.of(
            new User(1311L,"name1","76565444"),
            new User(1312L,"name2","76565444"),
            new User(1313L,"name3","76565444"),
            new User(1314L,"name4","76565444")
    );


    @Override
    public User getUser(Long id) {
        log.info("Inside getUser method of UserService");
        return list.stream().filter(user -> Objects.equals(user.getUserId(), id)).findAny().orElse(null);
    }
}
