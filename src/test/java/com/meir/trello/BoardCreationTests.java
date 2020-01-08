package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logoutAtlassianAss();
        }
    }
   @Test
   public void CreateBoard() throws InterruptedException {
       final int NUMBER_OF_BOARDS = 3; // number of boards to create
       int before = app.getBoardsCount();

       for(int i = 0; i < NUMBER_OF_BOARDS; i++) {
           app.clickOnPlusButton();
           app.selectCreateBoardFromDropDown();
           app.fillBoardForm("QA_22" + System.currentTimeMillis());
           app.confirmBoardCreation();
           app.pause(5000);
           app.returnToHomePage();
           app.pause(5000);
       }
       int actualRes = app.getBoardsCount();
       int expectedRes = before + NUMBER_OF_BOARDS;
       Assert.assertEquals(actualRes,expectedRes);
       System.out.println("actualRes = " + actualRes);
       System.out.println("expectedRes = " + expectedRes);
   }
   @AfterClass
   public void boardCleaning() throws InterruptedException {
       while(app.boardIsSuccessfullyClicked())
       {
           app.boardDeletionProcess();
       }
   }





}
