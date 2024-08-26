package org.majestic.majesticMusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.majestic.majesticMusic.entity")
@EnableJpaRepositories(basePackages = "org.majestic.majesticMusic.repository")
public class MajesticMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajesticMusicApplication.class, args);
	}
}
