package org.tpo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignInTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static SearchResPage searchResPage;
    public static SettingsPage settingsPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver",ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        searchResPage = new SearchResPage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @AfterAll
    public static void signOut(){
        profilePage.enterMenu();
        profilePage.signOut();
        driver.quit();
    }

    @Order(1)
    @Test
    public void testLogin(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickSignIn();
        profilePage.enterMenu();
        String user = profilePage.getUserName();
        profilePage.undoMenu();
        Assertions.assertEquals("Signed in as " + ConfProperties.getProperty("login"), user);
    }

    @Order(2)
    @Test
    public void testSearch(){
        profilePage.search(ConfProperties.getProperty("request"));
        Assertions.assertTrue(searchResPage.resultIsPresent());
        profilePage.clearSearchField();
    }

    @Order(3)
    @Test
    public void testResultPresence(){
        String expected = ConfProperties.getProperty("request");
        profilePage.search(expected);
        Assertions.assertTrue(searchResPage.resultIsPresent(expected));
    }

    @Order(4)
    @Test
    public void testSettings(){
        profilePage.enterMenu();
        profilePage.enterSettings();
        profilePage.undoMenu();
        settingsPage.enterName(ConfProperties.getProperty("name"));
        settingsPage.enterCompany(ConfProperties.getProperty("company"));
        settingsPage.clickUpdate();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String name = settingsPage.getName();
        String company = settingsPage.getCompany();
        Assertions.assertEquals(ConfProperties.getProperty("name"), name);
        Assertions.assertEquals(ConfProperties.getProperty("company"), company);
    }
}
