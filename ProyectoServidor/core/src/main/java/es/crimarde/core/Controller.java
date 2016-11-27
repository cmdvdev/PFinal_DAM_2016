package es.crimarde.core.hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.crimarde.service.Service;

@RestController
public class Controller {
	
	@Autowired Service servicio;
	
    private static final String template = "Hello, %s!";
    
    @RequestMapping("/lista")
    public List<TestResponse> retrieveList() {
        return null;
    }
    
    @RequestMapping("/add")
    public List<String> add(@RequestParam(value="name", defaultValue="Usuario") String name) {
        return Arrays.asList("add");
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="name", defaultValue="Usuario") String name) {
        return ("deleted");
    }
    
    @RequestMapping("/edit")
    public String edit(@RequestParam(value="name", defaultValue="Usuario") String name) {
    	return ("edited");
    }
    
    @RequestMapping("/retrieve")
    public String retrieve(@RequestParam(value="name", defaultValue="Usuario") String name) {
    	return servicio.retrieve();
    }
}