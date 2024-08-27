package org.majestic.majesticMusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Specifies the package from which to scan the entities.
@EntityScan(basePackages = "org.majestic.majesticMusic.entity")
// Enables and configures JPA repositories in a specific package
@EnableJpaRepositories(basePackages = "org.majestic.majesticMusic.repository")
public class MajesticMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajesticMusicApplication.class, args);
	}
}