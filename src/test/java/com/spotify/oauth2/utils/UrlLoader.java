package com.spotify.oauth2.utils;

import java.util.Objects;
import java.util.Properties;

public class UrlLoader {
    private static UrlLoader urlLoader;
    private final Properties properties ;

    private UrlLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/url.properties");
    }

    public static UrlLoader getInstance()
    {
       if(Objects.isNull(urlLoader)) {
           urlLoader = new UrlLoader();
       }
        return urlLoader;
    }

    public String getUrlWebHook()
    {
        return Objects.requireNonNull(properties.getProperty("WEBHOOK_URL"));
    }


}
