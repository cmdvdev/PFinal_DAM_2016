package es.crimarde.core.aplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Genera la autoconfiguracion de SpringBoot
@SpringBootApplication	

// Por defecto SpringBoot busca las clases en el mismo proyecto en que está el main. 
//Esta anotación hace que busque en otros proyectos anidados. De hecho busca en los paquetes que se indican en la anotacion 
@ComponentScan(basePackages="es.crimarde")
@EnableJpaRepositories("es.crimarde")
@EntityScan("es.crimarde")

//It turns out there can only be 1 application.properties file in the final jar that spring boot creates. 
//To have multiple files you have to rename one of the files to something custom.
@PropertySource(value = {"application.properties", "dao-application.properties"})
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
       
        logger.info("-- Alicacion cargada --");

    }
}