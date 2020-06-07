package com.learnapps.shorturl.util;

import org.apache.commons.validator.routines.UrlValidator;

public class URLValidatorUtil {

private static UrlValidator instance;

private static UrlValidator getInstance(){
    if(instance == null){
        instance = new UrlValidator(new String[]{"http", "https"});
    }
    return instance;
}

public static boolean isValidUrl(String url){
    return getInstance().isValid(url);
}


}
