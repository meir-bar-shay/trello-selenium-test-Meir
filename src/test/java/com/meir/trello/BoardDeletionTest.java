package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logoutAtlassianAss();
        }
    }
    @Test
    public void deleteSingleBoard() throws InterruptedException {
        if(app.boardIsSuccessfullyClicked())
            app.boardDeletionProcess();

    }
    @Test
    public void deleteAllBoards() throws InterruptedException {
            
        while(app.boardIsSuccessfullyClicked())
        {
            app.boardDeletionProcess();
        }
    }


}
