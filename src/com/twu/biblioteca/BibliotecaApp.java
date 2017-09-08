package com.twu.biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        WelcomeSpeaker welcomeSpeaker = new WelcomeSpeaker(System.out);
        welcomeSpeaker.sayWelcome();
    }
}
