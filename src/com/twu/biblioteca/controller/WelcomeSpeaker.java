package com.twu.biblioteca.controller;

import java.io.PrintStream;

public class WelcomeSpeaker {
    private PrintStream printStream;

    public WelcomeSpeaker(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void sayWelcome() {
        printStream.println("Welcome to Bangalore Public Library!");
    }
}
