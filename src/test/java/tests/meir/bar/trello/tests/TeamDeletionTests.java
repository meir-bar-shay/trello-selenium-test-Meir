package tests.meir.bar.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAtlassianAcc();
        }
    }


    @Test
    public void deletionBoardTests() throws InterruptedException {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getTeam().clickOnTheTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamButton();
        app.getTeam().submitDeletion();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, teamCountBefore - 1);
    }
    @Test
    public void deletionBoardTests1() throws InterruptedException {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getTeam().clickOnTheTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamButton();
        app.getTeam().submitDeletion();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, teamCountBefore - 1);
    }


}
