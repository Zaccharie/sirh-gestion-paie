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
import dev.paie.entite.Grade;

@ContextConfiguration(classes = {GradeServiceJdbcTemplate.class, DataSourceMySQLConfig.class})

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Grade nouveauGrade = new Grade("test", new BigDecimal("35.0"), new BigDecimal("1.2"));
		
		//sauvegarder un nouveau grade
		gradeService.sauvegarder(nouveauGrade);
		
		//vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> listeGrade = gradeService.lister();
		Grade gradeFromList  = listeGrade.get(listeGrade.size() - 1);
		assertThat(gradeFromList.getCode(), equalTo("test"));
		
		//modifier un grade
		gradeFromList.setCode("test_modif");
		gradeService.mettreAJour(gradeFromList);
		
		//vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Grade> listeGradeModif = gradeService.lister();
		assertThat(listeGradeModif.get(listeGradeModif.size() - 1).getCode(), equalTo("test_modif"));
	}
}
