package es.crimarde.core.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Imports sin Spring Security
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;

//Imports para Spring Security
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebConfiguration {
	
	/**
	 * Bean para dar de alta la consola de H2 sn Spring Security
	 * la url para acceder a la consola es http://localhost:8080/console
	 * 
	 * Cambio la base de datos empotrada por una base de datos mysql
	 */
//	@Bean
//	ServletRegistrationBean h2servletRegistration() {
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//		registrationBean.addUrlMappings("/console/*");
//		return registrationBean;
//	}
	
	/**
	 * Bean para acceder a la consola de H2 con Spring Security
	 */

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/console/**").permitAll();
// 
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//    }
	
}