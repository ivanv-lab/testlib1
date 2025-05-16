package testlib.pageObjects.adm.settings;

import com.codeborne.selenide.SelenideDriver;
import testlib.pageObjects.BasePage;

public class ClientsPage extends BasePage {

    public ClientsPage(SelenideDriver driver) {
        super(driver);
        if(!driver.url().contains("/acui/settings/partners"))
            throw new IllegalStateException("This is not partners page!");
    }
}
