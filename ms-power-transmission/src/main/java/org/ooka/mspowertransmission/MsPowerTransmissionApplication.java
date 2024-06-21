package org.ooka.mspowertransmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.ooka.mspowertransmission", "org.ooka.commons.analyser"})
public class MsPowerTransmissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPowerTransmissionApplication.class, args);
	}

}
