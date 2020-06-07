package com.learnapps.shorturl.service;

import com.google.common.hash.Hashing;
import com.learnapps.shorturl.util.URLValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class ShortURLService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getOriginalURL(String shortURL){
        String originalURL = stringRedisTemplate.opsForValue().get(shortURL);
        return originalURL!=null?originalURL:"NO URL Found";
    }

    public String generateShortURL(String originalURL){
        String shortUrl= null;
        if(URLValidatorUtil.isValidUrl(originalURL)){
            shortUrl = Hashing.crc32().hashString(originalURL, StandardCharsets.UTF_8).toString();
            stringRedisTemplate.opsForValue().set(shortUrl , originalURL);
        }else{
            return "Invalid URL";
        }
        return shortUrl;
    }
}
