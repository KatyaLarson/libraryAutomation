package com.cydeo.library.pages;

import com.cydeo.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BorrowedBooksNumPage_GM {

    public BorrowedBooksNumPage_GM(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//h6[normalize-space()='Borrowed Books']")
        public WebElement borrowedBooksName;

        @FindBy(id = "borrowed_books")
        public WebElement borrowedBooksNumber;

    }

