package es.crimarde.core.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
    private static final String template = "Hello, %s!";
    
    @RequestMapping("/test")
    public TestResponse lectura(@RequestParam(value="name", defaultValue="Usuario") String name) {
        return new TestResponse(String.format(template, name), Status.SUCCESS.getDesc());
    }
}