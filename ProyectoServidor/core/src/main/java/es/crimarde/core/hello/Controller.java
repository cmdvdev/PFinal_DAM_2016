package es.crimarde.core.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.crimarde.service.Servicio;

@RestController
public class Controller {
	
	@Autowired Servicio servicio;
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/lectura")
    public PruebaRespuesta lectura(@RequestParam(value="name", defaultValue="World") String name) {
        return new PruebaRespuesta("valor por defecto", Status.SUCCESS.getDesc());
    }
}