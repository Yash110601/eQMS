package com.example.documentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "com.example.documentmanagement")
@SpringBootApplication
public class DocumentManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(DocumentManagementSystemApplication.class, args);
		System.out.println("Welcome to Document Management System !!!");
	}
}
