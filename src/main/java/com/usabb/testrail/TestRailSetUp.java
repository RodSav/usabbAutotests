package com.usabb.testrail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestRailSetUp {

    private static final Logger logger = LoggerFactory.getLogger(TestRailSetUp.class);

    InputStream inputStream;

    public Properties getProperties() throws IOException {
        Properties prop = new Properties();
        try {
            String propFilePath = "src/main/resources/testrail.properties";
            inputStream = new FileInputStream(propFilePath);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                logger.error("property file '" + propFilePath + "' not found in the classpath");
                throw new FileNotFoundException("property file '" + propFilePath + "' not found in the classpath");
            }
            return prop;
        } catch (IOException e) {
            logger.error("Exception {}" + e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return prop;
    }

}
