package org.tpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    @FindBy(xpath = "/html/body/div[1]/header/div[1]/a/svg")
    private WebElement home;
    @FindBy(xpath = "/html/body/div[1]/header/div[7]/details")
    private WebElement menu;
    @FindBy(xpath = "/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a")
    private WebElement user;
    @FindBy(xpath = "//*[contains(text(), 'Sign out')]/..")
    private WebElement signOutBtn;
    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/form/label/input[1]")
    private WebElement searchField;
    @FindBy(linkText  = "Settings")
    private WebElement settingsBtn;

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterMenu(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        menu.click();
    }

    public void undoMenu(){
        menu.click();
    }
    public String getUserName(){
        return user.getText();
    }

    public void signOut(){
        signOutBtn.click();
    }

    public void search(String s){
        searchField.clear();
        searchField.sendKeys(s + "\n");
    }

    public void clearSearchField(){
        searchField.clear();
    }

    public void enterSettings(){
        settingsBtn.click();
    }

    public void enterHome(){
        home.click();
    }

}
