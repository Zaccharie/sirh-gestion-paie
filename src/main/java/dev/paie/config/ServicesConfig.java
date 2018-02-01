package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"dev.paie.service"})
@Import(DataSourceMySQLConfig.class)
public class ServicesConfig {
	
}