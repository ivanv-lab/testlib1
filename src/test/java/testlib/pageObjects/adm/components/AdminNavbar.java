package testlib.pageObjects.adm.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import testlib.pageObjects.adm.HomePage;

import static com.codeborne.selenide.Selenide.$x;

public class AdminNavbar {

    SelenideElement closedNavbar=$x(".//body[contains(@class,'sidebar-mini')]//div[@class='sidebar-wrapper md-scrollbar ps']");
    SelenideElement openedNavbar=$x(".//body[not(contains(@class,'sidebar-mini'))]//div[@class='sidebar-wrapper md-scrollbar ps']");
    SelenideElement subSection=openedNavbar.$x("//li/a/p");
    SelenideElement section=openedNavbar.$x("//li/div/ul/li/a/span[@class='sidebar-normal']");

    public static void subSectionClick(String section,String subsection){

    }

    public static void sectionClick(String section){

    }

    public void openNavbar(){
        closedNavbar.
    }
}
