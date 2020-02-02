package tests.meir.bar.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.meir.bar.trello.model.TeamData;

public class TeamCreationTests extends TestBase{


  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getSession().isAvatarPresentOnHeader()){
      app.getSession().loginAtlassianAcc();
    }
  }

  @Test(dataProvider = "validTeamsCSV",dataProviderClass = DataProviders.class)
  public void teamCreationTestFromHeaderCSV (TeamData team) throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();

    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(team);
    Thread.sleep(5000);

    app.getTeam().submitTeamCreation();

    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

  @Test(dataProvider = "validTeams",dataProviderClass = DataProviders.class)
  public void teamCreationTestFromHeaderWithDP(String teamName, String teamDescr) throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();

    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName("teamName")
            .withTeamDescr("teamDescr"));
    Thread.sleep(5000);

    app.getTeam().submitTeamCreation();

    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }


  @Test
  public void teamCreationTestFromHeader() throws InterruptedException {
int teamCountBefore = app.getTeam().getTeamsCount();
//    String teamId =
//            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
   // System.out.println(teamId);
    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName("teamName")
            .withTeamDescr("teamDescr"));
    Thread.sleep(5000);

    app.getTeam().submitTeamCreation();
    if(app.getBase().isElementPresent(By.cssSelector("[name='close']"))){
      app.getTeam().closeInviteToTheTeamForm();
    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
int teamCountAfter = app.getTeam().getTeamsCount();
  Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }
  @Test
  public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();
//    String teamId =
//            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
    // System.out.println(teamId);
    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName("teamName"));
    Thread.sleep(5000);

    app.getTeam().submitTeamCreation();
    if(app.getBase().isElementPresent(By.cssSelector("[name='close']"))){
      app.getTeam().closeInviteToTheTeamForm();
    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

}
