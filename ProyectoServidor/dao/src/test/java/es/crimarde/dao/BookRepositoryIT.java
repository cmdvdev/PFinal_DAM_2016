package es.crimarde.dao;

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
	public void testt(){
	Book b = repo.findOne(1L);
	System.out.println("--");
	}
	
}
