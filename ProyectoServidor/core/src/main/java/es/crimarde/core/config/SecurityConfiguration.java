package es.crimarde.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@PropertySource("classpath:application.properties")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Value("${crimarde.dam.security.realm.name}")
    private String REALM;
	
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("pass").roles("ADMIN","USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.csrf().disable()
        .authorizeRequests()
        	.antMatchers(HttpMethod.GET,"/lista").permitAll()
        	.antMatchers(HttpMethod.GET,"/search/*").permitAll()
        	//.antMatchers("/book/**")..hasAnyRole("USER","ADMIN")
        	.antMatchers(HttpMethod.POST,"/book/add").hasAnyRole("USER","ADMIN")
        	.antMatchers(HttpMethod.GET,"/book/retrieve/**").hasAnyRole("USER","ADMIN")
        	.antMatchers(HttpMethod.GET,"/book/random").hasAnyRole("USER","ADMIN")
        	.antMatchers(HttpMethod.DELETE,"/delete/**").hasRole("ADMIN")
        	.antMatchers(HttpMethod.PUT,"/update/**").hasAnyRole("USER","ADMIN")
        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);//No hace falta crear una sesion      
    }
     
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }
     
    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
        	.ignoring()
        		.antMatchers(HttpMethod.OPTIONS, "/**");
    }
}


//https://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/