package com.twu.biblioteca.controller;

import com.twu.biblioteca.controller.WelcomeSpeaker;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class WelcomeSpeakerTest {
    @Test
    public void sayWelcome() throws Exception {
        PrintStream out = Mockito.spy(System.out);

        WelcomeSpeaker welcomeSpeaker = new WelcomeSpeaker(out);
        welcomeSpeaker.sayWelcome();

        Mockito.verify(out).println("Welcome to Bangalore Public Library!");
    }
}