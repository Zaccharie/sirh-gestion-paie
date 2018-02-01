package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = {CotisationServiceJpa.class, DataSourceMySQLConfig.class, JpaConfig.class})

@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Cotisation nouvelleCotisation = new Cotisation("code-test","libelle-test", new BigDecimal("1.0"), new BigDecimal("5.0"));
		
		//sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(nouvelleCotisation);
		
		//vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		List<Cotisation> listCotisation = cotisationService.lister();
		Cotisation cotisFromList = listCotisation.get(listCotisation.size() - 1);
		assertThat(cotisFromList.getCode(), equalTo("code-test"));
		
		//modifier une cotisation
		cotisFromList.setCode("code_modif");
		cotisationService.mettreAJour(cotisFromList);
		
		//vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Cotisation> listeCotisationModif = cotisationService.lister();
		assertThat(listeCotisationModif.get(listeCotisationModif.size() - 1).getCode(), equalTo("code_modif"));
	}
}
