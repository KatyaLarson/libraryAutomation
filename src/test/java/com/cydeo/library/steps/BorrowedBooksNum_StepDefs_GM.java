package com.cydeo.library.steps;

import com.cydeo.library.pages.BorrowedBooksNumPage_GM;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BorrowedBooksNum_StepDefs_GM {

    String librarian;
    LoginPage loginPage = new LoginPage();
    BorrowedBooksNumPage_GM borrowedBooksNumPage_gm = new BorrowedBooksNumPage_GM();
    @Given("user logins as a librarian")
    public void user_logins_as_a_librarian() {
String keyWordFirstPart = "librarian";
        loginPage.login(keyWordFirstPart);
    }
    @When("user takes borrowed books number")
    public void user_takes_borrowed_books_number() {

        String expectedBorrowedNumber =  borrowedBooksNumPage_gm.borrowedBooksNumber.getText();
    }
    @Then("borrowed books number information must match with the DB")
    public void borrowed_books_number_information_must_match_with_the_db() {

        DB_Util.createConnection();
        String actualBorrowedBookNumbers =  borrowedBooksNumPage_gm.borrowedBooksNumber.getText();
        DB_Util.runQuery("select count(*) as borrowedBooks from users u\n" +
                "inner join book_borrow b on u.id = b.user_id where is_returned = 0");
        String expectedBorrowedBook = DB_Util.getFirstRowFirstColumn();
        //Compare
        Assert.assertEquals(expectedBorrowedBook,actualBorrowedBookNumbers);
    }

}


