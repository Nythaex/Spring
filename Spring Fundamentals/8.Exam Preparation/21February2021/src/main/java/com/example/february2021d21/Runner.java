package com.example.february2021d21;

import com.example.february2021d21.service.ArtistService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    private ArtistService artistService;

    public Runner(ArtistService artistService) {
        this.artistService = artistService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        artistService.init();


    }
}
