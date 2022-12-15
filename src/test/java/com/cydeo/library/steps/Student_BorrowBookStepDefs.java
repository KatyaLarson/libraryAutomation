package com.cydeo.library.steps;


import com.cydeo.library.pages.BookPage1;
import com.cydeo.library.pages.BorrowingBooksPage;
import com.cydeo.library.utility.BrowserUtil;
import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class Student_BorrowBookStepDefs {
    BookPage1 bookPage = new BookPage1();
    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();
     String bookName;
     String borrowedDate;

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String books) {
        bookPage.books.click();
        BrowserUtil.waitFor(2);

    }

    @Given("I search book name called {string}")
    public void i_search_book_name_called(String bookName) {
        bookPage.search.sendKeys(bookName + Keys.ENTER);
        BrowserUtil.waitFor(2);
        BrowserUtil.selectByVisibleText(bookPage.NumberOfBooksDropdown,"500");
        this.bookName=bookName;
        BrowserUtil.waitFor(3);
    }

    @When("I click Borrow Book")
    public void i_click_borrow_book() {
        bookPage.borrowBookBtn.click();
        BrowserUtil.waitForVisibility(bookPage.toastMsg, 2);
        Assert.assertEquals("The book has been borrowed...", bookPage.toastMsg.getText());
       // BrowserUtil.waitFor(2);


    }

    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verify_that_book_is_shown_in_borrowing_books_page() {
        borrowingBooksPage.borrowingBooks.click();
        borrowedDate=borrowingBooksPage.lastRow().get("Borrowed Date");
        Assert.assertEquals(bookName, borrowingBooksPage.lastRow().get("Book Name"));




    }






    @Then("verify logged {string} has same book in database")
    public void verifyLoggedHasSameBookInDatabase(String student) {
        DB_Util.runQuery("select full_name,name,is_returned,borrowed_date from users inner join book_borrow bb on users.id = bb.user_id inner join books b on bb.book_id = b.id where is_returned=0 and full_name='"+student+"' order by 4 desc");

        Map<String,String> firstRow=DB_Util.getRowMap(1);
        System.out.println(firstRow);

        Assert.assertEquals(bookName,firstRow.get("name"));
        Assert.assertEquals(borrowedDate,firstRow.get("borrowed_date"));

        BrowserUtil.waitFor(3);
        borrowingBooksPage.clickReturnBtn();
    }
}