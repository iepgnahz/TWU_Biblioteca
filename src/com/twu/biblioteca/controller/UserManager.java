package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;

import java.util.Scanner;

public class UserManager {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String libraryNumber, String password) {
        User user = userRepository.findUser(libraryNumber);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public User alertUserLogin() {
        Scanner scanner = new Scanner(System.in);
        String libraryNumber = scanner.next().trim();
        System.out.println("请输入您的密码：");
        Scanner scannerPassword = new Scanner(System.in);
        String password = scannerPassword.next().trim();
        return this.login(libraryNumber, password);
    }
}
