package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.User;

/**
 * Created by pezhang on 24/09/2017.
 */
public interface UserRepository {
    User findUser(String libraryNumber);
}
