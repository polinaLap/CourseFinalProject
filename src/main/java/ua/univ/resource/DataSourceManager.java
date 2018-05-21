package ua.univ.resource;

import java.util.ResourceBundle;

public class DataSourceManager {
    private final static ResourceBundle resourceBundle =  ResourceBundle.getBundle("properties.datasource");
    private DataSourceManager(){}
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
