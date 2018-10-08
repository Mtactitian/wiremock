package com.alexb.wiremockstandalone;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootApplication
public class WireMockStandaloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(WireMockStandaloneApplication.class);
    }

    @Bean
    CommandLineRunner wireMockServer() {
        return args -> {
            WireMockServer wireMockServer = new WireMockServer(options().port(8000)
                    .fileSource(new SingleRootFileSource("src/main/resources/stubs/")));
            wireMockServer.start();
        };
    }
}