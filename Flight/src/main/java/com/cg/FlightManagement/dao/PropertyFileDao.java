package com.cg.FlightManagement.dao;

import java.util.Properties;

public interface PropertyFileDao {
    public Properties read(String fileName) throws Exception;
}
