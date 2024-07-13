package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    static public Properties getProps(String filename){
        Properties myProp = new Properties();
        try {
            File propFile = new File("src/main/java/PageObjectModel/resources/"+filename+".properties");
            if (propFile.exists()){
                myProp.load(new FileInputStream(propFile));

            }
            else {
                System.out.println("File not found: "+filename);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return myProp;

    }
}
