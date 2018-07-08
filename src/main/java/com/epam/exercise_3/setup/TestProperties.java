package com.epam.exercise_3.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.exercise_3.enums.PropertyFile.DEFAULT_PATH_TO_PROPERTY;

class TestProperties {


    static public Properties getCurrentProp(String fileName){
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(DEFAULT_PATH_TO_PROPERTY.title+fileName)){
            properties.load(inputStream);
        }catch (IOException e) {
            properties = null;
            e.printStackTrace();
        }
        return properties;
    }

}
