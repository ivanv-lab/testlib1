package testlib.pageObjects.adm;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import testlib.pageObjects.BasePage;
import testlib.utils.PropertiesHandler;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    SelenideElement emailInput=$x(".//input[@id='login']");
    SelenideElement passwordInput=$x(".//input[@id='password']");
    SelenideElement languageChangeButton=$x(".//div[label[@for='language']]//input");
    SelenideElement submitButton=$x(".//button[@id='button_auth']");

    public LoginPage(SelenideDriver driver){
        super(driver);
        driver.open(driver.url()+"/acui/login");

        if(!driver.url().contains("/acui/login")){
            throw new IllegalStateException("This in not login page!");
        }
    }

    public LoginPage typeLogin(String login){
        emailInput.sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage changeLanguage(){
        languageChangeButton.click(ClickOptions.usingJavaScript());
        if($x(".//button[@id='button_auth']").getValue().contains("Консоль администратора"))
            $x(".//button[div/span[contains(.,'English')]]").click();
        else $x(".//button[div/span[contains(.,'Русский')]]").click();
        return this;
    }

    public LoginPage submitButtonClick(){
        submitButton.click();
        return this;
    }

    public LoginPage loginAs(String login,String password){
        typeLogin(login);
        typePassword(password);
        return submitButtonClick();
    }

    public HomePage loginSuccess(String login,String password){
        typeLogin(login);
        typePassword(password);
        submitButton.click();
        return new HomePage(driver);
    }

    public HomePage loginAdminUser(){
        typeLogin(PropertiesHandler.getProperties()
                .getProperty("acui.login"));
        typePassword(PropertiesHandler.getProperties()
                .getProperty("acui.password"));
        submitButton.click();
        return new HomePage(driver);
    }
}
