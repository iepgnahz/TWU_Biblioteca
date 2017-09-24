package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pezhang on 24/09/2017.
 */
public class UserRepositoryImp implements UserRepository {
    public static User user1 = new User("1-zhangpei", "123456", "zp", "134@163.com", "1348823237");
    public static User user2 = new User("2-xixi", "123456", "xx", "133@163.com", "1338823237");
    public static User user3 = new User("3-pipi", "123456", "xxx", "132@163.com", "1328823237");
    public static User[] userList = new User[]{user1, user2, user3};

    @Override
    public User findUser(String libraryNumber) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].getLibraryNumber().equals(libraryNumber)) {
                return userList[i];
            }
        }
        return null;
    }
}
