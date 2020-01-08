package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.loginAtlassianAcc();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int teamCountBefore = app.getTeamsCount();

        app.clickOnPlusButton();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("ddd", "ddd");
        app.submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))){
//            closeInviteToTheTeamForm();
//        }
        app.clickLaterButton();
        int teamCountAfter = app.getTeamsCount();

//        Assert.assertTrue(isElementPresent(By.cssSelector("[data-test-id=home-team-tab-name]")));
        Assert.assertEquals(teamCountBefore,teamCountAfter+1);
//        String overflowValue = wd.findElement(By.cssSelector("")).getCssValue("overflow");
    }

}
