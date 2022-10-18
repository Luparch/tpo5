package org.tpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingsPage {

    @FindBy(xpath = "//*[@id=\"edit_user_116062503\"]/div/dl")
    private List<WebElement> fieldsList;

    @FindBy(xpath = "//*[@id=\"user_profile_name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"user_profile_company\"]")
    private WebElement companyInput;

    @FindBy(xpath = "//*[@id=\"edit_user_116062503\"]/div/p[2]/button")
    private WebElement updateBtn;
    public WebDriver driver;

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterName(String s){
        nameInput.clear();
        nameInput.sendKeys(s);
    }

    public void enterCompany(String s){
        companyInput.clear();
        companyInput.sendKeys(s);
    }

    public void clickUpdate(){
        updateBtn.click();
    }

    public String getName(){
        return nameInput.getAttribute("value");
    }

    public String getCompany(){
        return companyInput.getAttribute("value");
    }

}
