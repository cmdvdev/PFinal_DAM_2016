package es.crimarde.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

//@Configuration
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages ="es.crimarde.dao")
public class Config {

//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//	    return new HibernateJpaSessionFactoryBean();
//	}
	
}
