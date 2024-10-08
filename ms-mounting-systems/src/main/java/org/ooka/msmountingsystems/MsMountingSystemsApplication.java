package org.ooka.msmountingsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.ooka.msmountingsystems"})
public class MsMountingSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsMountingSystemsApplication.class, args);
    }

}
