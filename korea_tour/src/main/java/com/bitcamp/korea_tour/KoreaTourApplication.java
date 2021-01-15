package com.bitcamp.korea_tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.bitcamp.*","boot.tour.*"})
public class KoreaTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoreaTourApplication.class, args);
	}

}
