package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop = new Properties();

    static {
        FileInputStream fis;
        {
            try {
                fis = new FileInputStream("src/test/resources/config/config.properties");
                prop.load(fis);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }


}
