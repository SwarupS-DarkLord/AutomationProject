package com.spotify.oauth2.utils;

import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties ;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static synchronized ConfigLoader getInstance()
    {
       if(Objects.isNull(configLoader)) {
           configLoader = new ConfigLoader();
       }
        return configLoader;
    }


    public String getGrantType()
    {
        return Objects.requireNonNull(properties.getProperty("grant_type"),"grant_type is not " +
                "specified in config.properties file. Please check ");
    }

    public String getRefreshToken()
    {
        return Objects.requireNonNull(properties.getProperty("refresh_token"),"refresh_token is not " +
                "specified in config.properties file. Please check ");
    }

    public String getClientId()
    {
        return Objects.requireNonNull(properties.getProperty("client_id"),"client_id is not " +
                "specified in config.properties file. Please check ");
    }

    public String getClientSecret()
    {
        return Objects.requireNonNull(properties.getProperty("client_secret"),"client_secret is not " +
                "specified in config.properties file. Please check ");
    }

    public String getUserId()
    {
        return Objects.requireNonNull(properties.getProperty("user_id"),"user_id is not " +
                "specified in config.properties file. Please check ");
    }


}
