package testlib.base;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected SelenideDriver driver;

    @BeforeEach
    public void setup(){
        driver=SelenideDriverFactory.getDriver();
        driver.open("https://practice-automation.com/form-fields/");
    }

    @AfterEach
    public void tearDown(){
        SelenideDriverFactory.quitDriver();
    }
}
