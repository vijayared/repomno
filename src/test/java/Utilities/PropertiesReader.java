package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    
	 Properties  prop = new Properties();
    public void loadProperties() {
        String propPath = System.getProperty("user.dir") + "\\Configuration\\data.properties";
        
        try {
            FileInputStream fis = new FileInputStream(propPath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Handle file not found error
        } catch (IOException e) {
            e.printStackTrace();
            // Handle IO error
        }
        
    }
    
    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getURL() {
        return prop.getProperty("url");
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}

