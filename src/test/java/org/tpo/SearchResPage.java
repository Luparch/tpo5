package org.tpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResPage {

    @FindBy(xpath = "/html/body/div[5]/main/div/div[3]/div/ul/li")
    private List<WebElement> searchResult;

    private String innerXPath = "./div[2]/div[1]/div/a";

    public WebDriver driver;

    public SearchResPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean resultIsPresent(){
        return searchResult.size() > 0;
    }

    public boolean resultIsPresent(String s){
        WebElement inner;
        for(WebElement o : searchResult){
            inner = o.findElement(By.xpath(innerXPath));
            if(s.equals(inner.getText()))
                return true;
        }
        return false;
    }
}
