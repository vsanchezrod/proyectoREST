package es.vsanchezrod.proyectorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ProyectoRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoRestApplication.class, args);
	}
}
