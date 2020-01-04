package com.meir.trello;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test(enabled = false)
    public void testLogIn() throws InterruptedException {
        clickLoginLink();
        loginWhithBothAccs();

    }
}