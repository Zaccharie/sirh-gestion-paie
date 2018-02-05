package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//Import de la configuration XML dans une configuration Java
@ImportResource({"classpath:entreprises.xml", "classpath:cotisations-imposables.xml",
	"classpath:cotisations-non-imposables.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml"})
public class JeuxDonneesConfig {
}