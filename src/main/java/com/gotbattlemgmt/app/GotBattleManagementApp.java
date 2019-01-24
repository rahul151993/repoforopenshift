package com.gotbattlemgmt.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gotbattlemgmt.service.BattleService;
import com.gotbattlemgmt.serviceimpl.BattleServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.gotbattlemgmt")
@EntityScan(basePackages="com.gotbattlemgmt.entities")
@EnableJpaRepositories(basePackages="com.gotbattlemgmt.repository")
public class GotBattleManagementApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(GotBattleManagementApp.class, args);
		BattleService battleService = applicationContext.getBean("battleServiceImpl", BattleServiceImpl.class);
		try {
			battleService.readCsvFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
