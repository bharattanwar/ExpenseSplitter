package com.example.SplitExpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitExpenseApplication.class, args);
	}

}
