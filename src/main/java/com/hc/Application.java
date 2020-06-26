package com.hc;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("***************************************************** starting DCRM Application	...");
		//ApplicationUtill.Clock c = new ApplicationUtill.Clock();
		logger.info("***************************************************** ");
		//logger.info("Server started in "+c);
		logger.info("***************************************************** ");

	}
}