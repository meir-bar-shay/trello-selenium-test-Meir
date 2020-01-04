package com.meir.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            logoutAtlassianAss();
        }
    }
    @Test
    public void deleteSingleBoard() throws InterruptedException {
        if(boardIsSuccessfullyClicked())
            boardDeletionProcess();

    }
    @Test
    public void deleteAllBoards() throws InterruptedException {
            
        while(boardIsSuccessfullyClicked())
        {
            boardDeletionProcess();
        }
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
}
