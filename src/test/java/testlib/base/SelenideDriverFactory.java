package testlib.base;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import testlib.utils.PropertiesHandler;

public class SelenideDriverFactory {

    private static SelenideDriver driver;

    public static SelenideDriver createDriver(){

        String browser=PropertiesHandler.getProperties()
                .getProperty("browser","chrome");
        String selenoidUrl=PropertiesHandler.getProperties()
                .getProperty("selenoid.url");
        boolean headless=Boolean.parseBoolean(PropertiesHandler
                .getProperties().getProperty("headless","false"));
        String browserVersion=PropertiesHandler.getProperties()
                .getProperty("browser.version");

        SelenideConfig config=new SelenideConfig();

        try{
            if(selenoidUrl!=null && !selenoidUrl.isEmpty()){

                config.browser(browser);
                config.browserVersion(browserVersion);

                if(browser.equalsIgnoreCase("chrome")) {

                    if (headless) config.headless(true);
                }
            }

            int implicitWait=Integer.parseInt(PropertiesHandler
                    .getProperties().getProperty("implicit.wait","10"));
            config.timeout(implicitWait);

            driver=new SelenideDriver(config);
            return driver;
        } catch (Exception e){

            System.err.println("Ошибка при создании SelenideDriver: "+e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Ошибка при создании SelenideDriver",e);
        }
    }

    public static SelenideDriver getDriver(){
        if(driver==null)
            driver=createDriver();
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null)
            driver.close();

        driver=null;
    }
}
