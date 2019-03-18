package fr.fazam.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableAutoConfiguration
@EnableJpaRepositories("fr.fazam.dao")
@ComponentScan(basePackages = { "fr.fazam.service", "fr.fazam.api" })
@EntityScan("fr.fazam.entites")
public class FazamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FazamApplication.class, args);
	}

}
