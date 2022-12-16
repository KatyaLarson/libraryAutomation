package com.cydeo.library.pages;

import com.cydeo.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage1 extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(xpath = "//span[@class='title'][.='Books']")
    public WebElement books;

    @FindBy(xpath = "//*[@id=\"tbl_books\"]/tbody/tr/td[1]/a")
    public WebElement editBook;


    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;


    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement NumberOfBooksDropdown;

    @FindBy(xpath = "(//td/a[not (contains(@class,'disabled'))])[1]") // added new locator for borrow button
    public WebElement borrowBookBtn;

    @FindBy(className = "toast-message")
    public WebElement toastMsg; //added new locator for toast message

    public void clickBooks(){
        books.click();
    }



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    public void clickEdit(){
        editBook.click();
    }

}
