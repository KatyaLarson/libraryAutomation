package com.cydeo.library.steps;

import com.cydeo.library.pages.BorrowedBooksNumberPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_BorrowedBooksNumbersStepDefs {

    LoginPage loginPage = new LoginPage();
    BorrowedBooksNumberPage borrowedBooksNumberPage = new BorrowedBooksNumberPage();

    @Given("user login as a {string}")
    public void userLoginAsA(String arg0) {

        loginPage.login(arg0);

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
      String expectedBorrowedNumber =  borrowedBooksNumberPage.borrowedBookNumber.getText();


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.createConnection();
        String actualBorrowedNumber =  borrowedBooksNumberPage.borrowedBookNumber.getText();
        DB_Util.runQuery("select count(*) from book_borrow\n" +
                "where is_returned=0;");
        String expectedBorrowedNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedNumber,actualBorrowedNumber);

    }



}
