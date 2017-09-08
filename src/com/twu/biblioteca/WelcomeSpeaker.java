package com.twu.biblioteca;

import java.io.PrintStream;

public class WelcomeSpeaker {
    private PrintStream printStream;

    public WelcomeSpeaker(PrintStream printStream) {
        this.printStream = printStream;
    }

    void sayWelcome() {
        printStream.println("Welcome to Bangalore Public Library!");
    }
}
