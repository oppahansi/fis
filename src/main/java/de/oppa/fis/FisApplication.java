package de.oppa.fis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class FisApplication {

  public static void main(String[] args) {
    SpringApplication.run(FisApplication.class, args);
  }
}
