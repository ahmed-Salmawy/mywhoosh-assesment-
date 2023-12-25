package com.mywhoosh.studentresultManagment;

import com.mywhoosh.studentresultManagment.security.dto.RegisterRequest;
import com.mywhoosh.studentresultManagment.security.service.AuthenticationService;
import com.mywhoosh.studentresultManagment.security.service.UserRegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentResultManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentResultManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service, UserRegistrationService userRegistrationService
			) {
		return args -> {
			var admin = RegisterRequest.builder()
					.username("user")
					.password("password")
					.build();

			System.out.println("Admin token: " + userRegistrationService.register(admin).getAccessToken());


		};
	}
}
