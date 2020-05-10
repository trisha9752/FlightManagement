package com.cg.FlightManagement.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileImpl implements PropertyFileDao{
    @Override
    public Properties read(String fileName) throws Exception{
            FileInputStream fis = null;
            Properties prop = null;
            try {
                fis = new FileInputStream(fileName);
                // create Properties class object
                prop = new Properties();
                // load properties file into it
                prop.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fis.close();
            }

            return prop;
    }
}
