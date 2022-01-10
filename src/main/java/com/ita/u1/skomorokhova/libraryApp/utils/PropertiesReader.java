package com.ita.u1.skomorokhova.libraryApp.utils;

import com.ita.u1.skomorokhova.libraryApp.consts.Errors;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class PropertiesReader {
    public static Properties getProperties(String resourceFileName) {
        val properties = new Properties();

        try {
            val is = PropertiesReader.class.getClassLoader().getResourceAsStream(resourceFileName);
            properties.load(is);

        } catch (FileNotFoundException e) {
            log.error(Errors.PROPERTIES_FILE_NOT_FOUND);
        } catch (IOException e) {
            log.error(Errors.CANNOT_GET_PROPERTY);
            e.printStackTrace();
        }
        return properties;
    }

    public static int castPropToInt(String prop) {
        try {
            return Integer.parseInt(prop);
        } catch (NumberFormatException e) {
            log.error(Errors.PROPERTY_NOT_INT);
        }
        return 0;
    }
}
