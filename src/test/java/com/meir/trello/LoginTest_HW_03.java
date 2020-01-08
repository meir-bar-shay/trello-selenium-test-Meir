package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_HW_03 extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.isAvatarPresentOnHeader()){
            app.logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        app.pause(20000);
       Assert.assertTrue(app.isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInWithAtlassianAcc1() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        app.pause(20000);
        Assert.assertTrue(app.isAvatarPresentOnHeader());
    }
}