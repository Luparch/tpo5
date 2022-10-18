package org.tpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[contains(@id, 'login_field')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@name, 'commit')]")
    private WebElement signBtn;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputLogin(String s){
        loginField.sendKeys(s);
    }

    public void inputPassword(String s){
        passwordField.sendKeys(s);
    }

    public void clickSignIn(){
        signBtn.click();
    }
}
