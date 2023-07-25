package utils;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {
    static public Properties getProps(String filename) {
        Properties myProp = new Properties();
        try {
            File propFile = new File("src/test/resources/" + filename + ".properties");
            if (propFile.exists())
                myProp.load(new FileInputStream(propFile));
            else
                System.out.println("File not found");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return myProp;
    }
}
