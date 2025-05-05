package testlib.utils;

import testlib.base.SelenideDriverFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {

    private static Properties properties;

    private static void loadProperties(){

        properties=new Properties();
        try(InputStream inputStream= SelenideDriverFactory
                .class.getClassLoader().getResourceAsStream("selenium.properties")){

            if(inputStream==null){
                System.out.println("Не удалось найти файл \"selenium.properties\"");
                return;
            }

            properties.load(inputStream);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static Properties getProperties(){
        return properties;
    }
}
