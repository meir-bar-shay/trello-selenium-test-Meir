package com.meir.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   WebDriver wd;

    public void init() {
        String browser =System.getProperty("browser", BrowserType.CHROME);
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void stop() {
        wd.quit();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
        type(By.id("user"), user);
        pause(2000);
        click(By.id("login"));
        click(By.id("login-submit"));
        type(By.id("password"), pwd);
        pause(2000);
        click(By.id("login-submit"));
    }

    public void confirmLogin() throws InterruptedException {
        click(By.id("login"));
    }

    public void click(By locator) throws InterruptedException {
        wd.findElement(locator).click();
        pause(2000);
    }

    public void fillLoginFormOldAcc(String userName, String password) throws InterruptedException {
        type(By.id("user"), userName);
        type(By.id("password"), password);
    }

    public void type(By locator, String text) throws InterruptedException {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickLoginLink() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

        type(By.id("user"), "meir.bar.shay@gmail.com");
        Thread.sleep(8000);
        if(wd.findElement(By.id("password")).isDisplayed()){
            type(By.id("password"), "Trello2019");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))){
            click(By.id("login-submit"));

            type(By.id("password"), "Trello2019");
            click(By.id("login-submit"));
        }
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() throws InterruptedException {
        clickOnAvatar();
        clickLogoutButton();
    }

    public void logoutAtlassianAss() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        pause(5000);
    }

    public void loginAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        pause(20000);

    }

    public void clickLogoutButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void confirmBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),boardName);
    }

    public void selectCreateBoardFromDropDown() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void clickOnPlusButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public  int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public boolean isThereBoard() {
        return getBoardsCount() >1;
    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22"+ System.currentTimeMillis());
        confirmBoardCreation();
        pause(15000);
        returnToHomePage();
    }

    public void boardDeletionProcess() throws InterruptedException {
        openMore();
        selectCloseBoardButton();
        clickButtonClose();
        permanentlyBoard();
        permanentlyDeleteBoard();
        returnToHomePage();
        pause(5000);
    }

    public void permanentlyDeleteBoard() throws InterruptedException {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void permanentlyBoard() throws InterruptedException {
        click(By.cssSelector("[class='quiet js-delete']"));
    }

    public void clickButtonClose() throws InterruptedException {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void selectCloseBoardButton() throws InterruptedException {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void openMore() throws InterruptedException {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
    }

    public boolean boardIsSuccessfullyClicked()
    {
        try
        {
            click(By.xpath("//*[@class='boards-page-board-section-list']//li[1 != last()]"));
            return true;
        }catch(Exception exception)
        {
            return false;
        }
    }

    public void confirmCloseBoard() throws InterruptedException {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    public void startCloseBoard() throws InterruptedException {
        pause(5000);
        click(By.cssSelector(".js-close-board"));
    }

    public void clickOpenMore() throws InterruptedException {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstBoard() throws InterruptedException {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void deleteBoard() throws InterruptedException {
        openFirstBoard();
        pause(10000);
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        returnToHomePage();
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void clickLaterButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public void submitTeamCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void closeInviteToTheTeamForm() throws InterruptedException {
        click(By.cssSelector("[name='close']"));
    }

    public void fillTeamCreationForm(String teamName, String teamDescr) throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("[id$= description]"), teamDescr);
    }

    public void selectCreateTeamFromDropDown() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }
}
