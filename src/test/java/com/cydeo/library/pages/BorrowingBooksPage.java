package com.cydeo.library.pages;

import com.cydeo.library.utility.Driver;
import io.cucumber.java.it.Ma;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BorrowingBooksPage extends BasePage {


    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooks;

    @FindBy(xpath = "//table[@id='borrowed_list']//tr/th")
    public List<WebElement> allTableHeaders;

    @FindBy(xpath = "//tbody//td/a[not (contains(@class,'disabled'))]/../..")
    public List<WebElement> allTableRows;





    public Map<String,String> lastRow(){  // last row in the table
        List<WebElement> allColumnsEle = allTableRows.get(allTableRows.size()-1)
                .findElements(By.tagName("td"));

        LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
        for (int j = 0; j < allColumnsEle.size(); j++) {
            // Getting cell value
            String cellValue = allColumnsEle.get(j).getText();
            // We will put in to map with header name and value with iteration
            // Get jth index value from allHeaderNames and jth cell value of row
            rowData.put(allTableHeaders.get(j).getText(), cellValue);
        }
        return rowData;
    }


    public void clickReturnBtn(){
        WebElement lastRowBtn=allTableRows.get(allTableRows.size()-1).findElement(By.xpath("//td/a[not (contains(@class,'disabled'))]"));
        lastRowBtn.click();
    }

}