package com.spotify.oauth2.utils;

import java.util.Objects;
import java.util.Properties;

public class DataLoader {
    private static DataLoader dataLoader;
    private final Properties properties ;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance()
    {
       if(Objects.isNull(dataLoader)) {
           dataLoader = new DataLoader();
       }
        return dataLoader;
    }

    public String getGetPlaylistId()
    {
        return Objects.requireNonNull(properties.getProperty("getPlaylistId"),"getPlaylistId is not " +
                "specified in data.properties file. Please check ");
    }

    public String getUpdatePlaylistId()
    {
        return Objects.requireNonNull(properties.getProperty("updatePlaylistId"),"updatePlaylistId is not " +
                "specified in data.properties file. Please check ");
    }


}
