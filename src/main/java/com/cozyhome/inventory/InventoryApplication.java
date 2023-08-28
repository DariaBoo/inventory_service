package com.cozyhome.inventory;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.cozyhome.inventory.model"})
@EnableJpaRepositories(basePackages = {"com.cozyhome.inventory.repository"})
@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		String path = new File("root.crt").getAbsolutePath();
        System.out.println("Absolute path to root.crt: " + path);
		SpringApplication.run(InventoryApplication.class, args);
		
	}	
}
