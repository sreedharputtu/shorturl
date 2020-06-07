package com.learnapps.shorturl.rest;

import com.learnapps.shorturl.service.ShortURLService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shorturl")
public class ShortURLResource {

    @Autowired
    ShortURLService shortURLService;

    @GetMapping("/{shortURL}")
    public String getOriginalURL(@PathVariable("shortURL") String shortURL){
        return shortURLService.getOriginalURL(shortURL);
    }

    @PostMapping
    public String createShortURL(@RequestBody String  originalUrl){
       return shortURLService.generateShortURL(originalUrl);
    }

}
