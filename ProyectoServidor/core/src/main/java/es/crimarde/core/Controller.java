package es.crimarde.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.crimarde.core.model.Response;
import es.crimarde.core.model.ResponseList;
import es.crimarde.model.Book;
import es.crimarde.service.Service;

@RestController
public class Controller {
	
	@Autowired Service servicio;
	
    private static final String template = "Hello, %s!";
    
    @RequestMapping("/lista")
    public ResponseList retrieveList() {
        ResponseList response = new ResponseList();
    	List<Book> books = new ArrayList<>();
        books.add(new Book(1, "titulo", "autor", "sinopsis", null, 20L));
        books.add(new Book(2, "titulo2", "autor2", "sinopsis2", null, 20L));
        books.add(new Book(3, "titulo3", "auto3r", "sinopsis3", null, 20L));
        
        response.setStatus(Status.SUCCESS.getDesc());
        response.setData(books);
        
        return response;
    }
    
    @RequestMapping("/add")
    public Book add(@RequestParam(value="name", defaultValue="Usuario") String name) {
        return new Book();
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return ("deleted");
    }
    
    @RequestMapping("/update/{id}")
    public String edit(@PathVariable("id") Integer id) {
    	return ("edited");
    }
    
    @RequestMapping("/retrieve/{id}")
    public Response retrieve(@PathVariable("id") Integer id) {
    	Response response = new Response();
    	Book book = servicio.retrieve(id);
    	response.setStatus(Status.SUCCESS.getDesc());
        response.setData(book);
        
        return response;
    }
    
    @RequestMapping("/random")
    public Response random() {
    	Response response = new Response();
    	Book book = servicio.retrieve(1);		//TODO hacerlo random de verdad
    	response.setStatus(Status.SUCCESS.getDesc());
        response.setData(book);
        
        return response;

    }
}