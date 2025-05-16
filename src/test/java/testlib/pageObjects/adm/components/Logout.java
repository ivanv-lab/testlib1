package testlib.pageObjects.adm.components;

import com.codeborne.selenide.SelenideElement;
import testlib.pageObjects.adm.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class Logout {

    SelenideElement adminLogin=$x(".//span[contains(@class,'top-user-link')]");
    SelenideElement logoutButton=$x(".//button[div/div/i[contains(.,'logout')]]");

    public void logOut(){
        logoutButton.click();
    }

    public String getAdminLogin(){
        return adminLogin.getValue().trim();
    }
}
