package com.jeiker.oauth2.service.impl;

import com.jeiker.oauth2.model.MyUserDetails;
import com.jeiker.oauth2.model.User;
import com.jeiker.oauth2.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Primary
@Service("userService")
public class UserServiceImpl implements UserService{

    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User(1, "test-user1", "123451"));
        users.add(new User(2, "test-user2", "123452"));
        users.add(new User(3, "test-user3", "123453"));
        users.add(new User(4, "test-user4", "123454"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = users.stream()
                .filter((u) -> u.getUserName().equals(s))
                .findFirst();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("there's no user founded!");

        } else {
            return new MyUserDetails(user.get());
        }
    }
}
