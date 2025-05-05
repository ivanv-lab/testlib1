package testlib.pageObjects;

import com.codeborne.selenide.BaseElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class BasePage {

    protected SelenideDriver driver;

    public BasePage(SelenideDriver driver){
        this.driver=driver;
    }

    protected SelenideElement findElement(String locator){
        return driver.$x(locator);
    }

    protected List<SelenideElement> findElementsCollection(String locator){
        return driver.$$x(locator).stream().toList();
    }

    protected void clickElement(String locator){
        findElement(locator).click();
    }

    protected String getTitle(){
        return driver.title();
    }

    protected void goBack(){
        driver.back();
    }

    protected void refreshPage(){
        driver.refresh();
    }
}
