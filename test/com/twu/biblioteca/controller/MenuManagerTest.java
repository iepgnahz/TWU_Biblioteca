package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class MenuManagerTest {
    private MenuManager menuManager;
    @Before
    public void setUp() throws Exception {
        menuManager = new MenuManager();
    }

    @Test
    public void get_checkout_result_when_result_true() throws Exception {
        String result = menuManager.getCheckoutResult(true);
        assertThat(result,is())
    }


}
