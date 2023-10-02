package configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {

    private Properties prop;
    private FileInputStream ip;

    public void initLangProp(String language) throws FileNotFoundException {
        System.out.println("lang is : " + language);
        prop = new Properties();
        //passing lang in any case either lowercase or uppercase
        try {
            switch (language.toLowerCase()) {
                case "english":
                    ip = new FileInputStream("C:\\Users\\radwa\\OneDrive\\Desktop\\Automation\\FajrWebApp\\src\\main\\resources\\lang.english.properties");
                    break;
                case "arabic":
                    ip = new FileInputStream("C:\\Users\\radwa\\OneDrive\\Desktop\\Automation\\FajrWebApp\\src\\main\\resources\\lang.arabic.properties");
                default:
                    System.out.println("lang is not found" + language);
                    break;
            }
            prop.load(ip);
        } catch (IOException e) {
        }

    }
}
