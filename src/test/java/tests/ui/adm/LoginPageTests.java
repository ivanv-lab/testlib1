package tests.ui.adm;

import com.codeborne.selenide.SelenideDriver;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import testlib.pageObjects.adm.LoginPage;
import testlib.utils.PropertiesHandler;

public class LoginPageTests {
    static SelenideDriver driver;

    @Test
    @Description("Только логин")
    void loginOnlyTest(){
        LoginPage loginPage=new LoginPage(new SelenideDriver(driver.config()));
        loginPage.typeLogin(PropertiesHandler.getProperties()
                .getProperty("acui.login"))
                .submitButtonClick();
    }

    @Test
    @Description("Только пароль")
    void passwordOnlyTest(){

    }

    @Test
    @Description("Неверные логин/пароль")
    void incorrectLoginPassTest(){

    }

    @Test
    @Description("Корректный вход")
    void login(){

    }

    @Test
    @Description("Проверка смены языка на Английский")
    void englishCheck(){

    }

    @Test
    @Description("Проверка смены языка на Русский")
    void russianCheck(){

    }
}
