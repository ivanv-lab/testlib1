package testlib.pageObjects.adm;

import com.codeborne.selenide.SelenideDriver;
import testlib.pageObjects.BasePage;

public class HomePage extends BasePage {


    public HomePage(SelenideDriver driver) {
        super(driver);

        if(!driver.url().contains("/acui/dashboard")){
            throw new IllegalStateException("This in not home (dashboard) page!");
        }
    }


}
