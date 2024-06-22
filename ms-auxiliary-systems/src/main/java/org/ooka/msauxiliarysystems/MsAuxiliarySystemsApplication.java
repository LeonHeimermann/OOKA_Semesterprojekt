package org.ooka.msauxiliarysystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.ooka.msauxiliarysystems", "org.ooka.commons.analyser"})
public class MsAuxiliarySystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAuxiliarySystemsApplication.class, args);
    }

}
