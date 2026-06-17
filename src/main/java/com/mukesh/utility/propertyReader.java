package com.mukesh.utility;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyReader {


    public static String readKeys(String key)
    {
        Properties p  =new Properties();
        try {

            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/resources/data.properties");

            p.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return p.getProperty(key);
    }
}
