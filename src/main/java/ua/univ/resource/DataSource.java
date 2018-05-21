package ua.univ.resource;

import java.util.ResourceBundle;

public class DataSource {
    private final static ResourceBundle resourceBundle =  ResourceBundle.getBundle("properties.datasource");
    private DataSource(){}
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
