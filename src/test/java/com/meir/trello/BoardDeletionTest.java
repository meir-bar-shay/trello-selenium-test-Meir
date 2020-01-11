package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            loginAtlassianAcc();
        }
    }
    @Test
    public void testDeleteSingleBoard() throws InterruptedException {
        if(boardIsSuccessfullyClicked())
            boardDeletionProcess();

    }
    @Test
    public void testDeleteAllBoards() throws InterruptedException {

        while(boardIsSuccessfullyClicked())
        {
            boardDeletionProcess();
        }
    }


    public void boardDeletionProcess() throws InterruptedException {
        openBoardMore();
        selectCloseBoardButton();
        clickBoardButtonClose();
        permanentlyBoard();
        permanentlyDeletionBoard();
        returnToHomePage();
        pause(5000);
    }

}
