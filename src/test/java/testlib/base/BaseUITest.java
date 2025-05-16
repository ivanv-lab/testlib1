package testlib.base;

import com.codeborne.selenide.SelenideDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import testlib.utils.PropertiesHandler;

public class BaseUITest {

    protected SelenideDriver driver;

    @BeforeEach
    public void setup(){
        driver=SelenideDriverFactory.getDriver();
        driver.open("http://"+PropertiesHandler.getProperties().getProperty("baseURL"));
    }

    @AfterEach
    public void tearDown(){
        SelenideDriverFactory.quitDriver();
    }
}
