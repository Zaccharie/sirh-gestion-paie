package dev.paie.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = {ServicesConfig.class})

@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Avantage avantage  = new Avantage("code-test","nom-test", new BigDecimal("2.0"));
		
		//sauvegarder un nouvel avantage
		avantageRepository.save(avantage);
		
		//vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage av = avantageRepository.findOne(avantage.getId());
		assertThat(av.getCode(), equalTo("code-test"));
	
		// TODO modifier un avantage
		av.setCode("code-modif");
		avantageRepository.save(av);
		
		// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		Avantage avModif = avantageRepository.findOne(av.getId());
		assertThat(avModif.getCode(), equalTo("code-modif"));
	}
}