package com.example.SplitExpense;

import com.example.SplitExpense.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitExpenseApplication implements CommandLineRunner {

	private final InitService initService;

	@Autowired
	public SplitExpenseApplication(InitService initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitExpenseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner from CommandLine");
		initService.init();
	}
}
