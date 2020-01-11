package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_HW_03 extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(isAvatarPresentOnHeader()){
            logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        pause(20000);
       Assert.assertTrue(isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInWithAtlassianAcc1() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        pause(20000);
        Assert.assertTrue(isAvatarPresentOnHeader());
    }
}