package com.example.tutorialUpload.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    // Settiamo le costanti di configurazione con il servizio Cloud
    @Bean
    public Cloudinary configurazione(){
        Map<String, String> configurazione = new HashMap<>();
        configurazione.put("cloud_name", "dskaugxxk");
        configurazione.put("api_key", "489476569137377");
        configurazione.put("api_secret", "b8TS5w97UYRWLkBHhAnq6hEiZZM");
        return new Cloudinary(configurazione);
    }


}
