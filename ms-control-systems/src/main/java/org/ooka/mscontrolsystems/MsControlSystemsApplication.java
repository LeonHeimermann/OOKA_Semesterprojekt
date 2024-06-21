package org.ooka.mscontrolsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.ooka.mscontrolsystems", "org.ooka.commons.analyser"})
public class MsControlSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsControlSystemsApplication.class, args);
    }

}
