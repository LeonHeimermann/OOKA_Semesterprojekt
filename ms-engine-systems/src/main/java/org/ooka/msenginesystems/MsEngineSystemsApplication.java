package org.ooka.msenginesystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.ooka.msenginesystems"})
public class MsEngineSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEngineSystemsApplication.class, args);
    }

}
