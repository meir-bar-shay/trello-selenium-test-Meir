package com.meir.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void testLogin() throws InterruptedException {
        //click login
        clickLogin();
    }

    public void clickLogin() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("meir.bar.shay@gmail.com");
Thread.sleep(10000);
        if (wd.findElement(By.id("password")).isDisplayed()){
            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("Trello2019");
        }
            wd.findElement(By.id("login")).click();

        if (isElementPresent(By.id("login-submit"))){
            wd.findElement(By.id("login-submit")).click();

            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("Trello2019");
            wd.findElement(By.id("login-submit")).click();
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

}

