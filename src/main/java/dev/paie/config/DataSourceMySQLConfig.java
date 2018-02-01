package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceMySQLConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://baonubvno-mysql.services.clever-cloud.com:3306/baonubvno");
		dataSource.setUsername("uoyzvhftlvqsiqse");
		dataSource.setPassword("BZrPhrNL1PZk66LV5QB");
		return dataSource;
	}
}
