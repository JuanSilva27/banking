package com.ar.bankingonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BankingOnline {

	public static void main(String[] args) {
		SpringApplication.run(BankingOnline.class,
				args);
	}

	
}
