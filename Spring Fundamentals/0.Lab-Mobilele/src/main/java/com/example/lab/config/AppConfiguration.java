package com.example.lab.config;

import com.example.lab.models.entity.Offer;
import com.example.lab.models.view.OfferView;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper mapper(){
        ModelMapper modelMapper=new ModelMapper();
//        modelMapper.typeMap(Offer.class,OfferView.class).addMappings(Offer::)
//
//        }

        return modelMapper;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }
}
