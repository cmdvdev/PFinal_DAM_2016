package es.crimarde.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Genera la autoconfiguracion de SpringBoot
@SpringBootApplication	

/*
 * Por defecto SpringBoot busca las clases en el mismo proyecto en que está el main. 
 * Esta anotación hace que busque en otros proyectos anidados. 
 * De hecho busca en los paquetes que se indican en la anotacion
*/
@ComponentScan(basePackages="es.crimarde")
@EnableJpaRepositories("es.crimarde")
@EntityScan("es.crimarde")
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}