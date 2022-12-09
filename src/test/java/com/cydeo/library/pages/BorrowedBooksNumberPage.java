package com.cydeo.library.pages;

import com.cydeo.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BorrowedBooksNumberPage {

    public BorrowedBooksNumberPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "borrowed_books")
    public WebElement borrowedBookNumber;


}
