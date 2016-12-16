package es.crimarde.dao;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.crimarde.Application;
import es.crimarde.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { Application.class })
@TestPropertySource(locations="classpath:/application-test.properties")
public class BookRepositoryIT {

	@Autowired BookRepository repo;
	
	@Test
	public void testRetieveBookWithId1 (){
		Book b = repo.findOne(1L);
	
		final String TITULO = "Los tres cerditos";
		final String AUTOR = "Autor1";
		
		Assert.assertThat(b,Matchers.notNullValue());
		Assert.assertThat(b.getId(), Matchers.is(1L));
		Assert.assertThat(b.getAutor(), Matchers.is(AUTOR));
		Assert.assertThat(b.getTitulo(), Matchers.is(TITULO));
		
	}
}
