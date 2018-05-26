package com.jeiker.oauth2.model;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class MyUserDetails extends User{

    private com.jeiker.oauth2.model.User user;

    public MyUserDetails(com.jeiker.oauth2.model.User user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public com.jeiker.oauth2.model.User getUser() {
        return user;
    }

    public void setUser(com.jeiker.oauth2.model.User user) {
        this.user = user;
    }
}
