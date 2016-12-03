package es.crimarde.core.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.crimarde.core.model.Response;
import es.crimarde.core.model.ResponseList;
import es.crimarde.negocio.BookDTO;
import es.crimarde.service.Service;

@RestController
public class Controller {
	
	@Autowired Service servicio;
    
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ResponseList retrieveList() {
        ResponseList response = new ResponseList();
        List<BookDTO> books = servicio.retrieveAll(); 
        //servicio.retrieveAll().forEach(books::add);
        
        if(books.isEmpty()) {
        	response.setStatus(HttpStatus.NO_CONTENT.getReasonPhrase());
        } else {
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
    	}
        response.setData(books);
        
        return response;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@RequestBody BookDTO bookDTO) {
    	Response response = new Response();
    	String status;
    	if(servicio.existsBook(bookDTO)){
    		status = HttpStatus.CONFLICT.getReasonPhrase();
    	} else {
    		servicio.add(bookDTO);
    		status = HttpStatus.CREATED.getReasonPhrase();
    	}
    	
    	response.setStatus(status);
    	return response;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") Integer id) {
    	BookDTO bookDTO = servicio.retrieve(id);
        
    	if(null != bookDTO){
    		servicio.delete(bookDTO.getId());
    		return new Response(HttpStatus.OK);
    	}
    	return new Response(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String edit(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO) {
    	Response response = new Response();
    	BookDTO bookDtoFromDB = servicio.retrieve(id);
    	
    	if(null != bookDtoFromDB) {
    		BeanUtils.copyProperties(bookDTO, bookDtoFromDB, "id");
    		servicio.update(bookDtoFromDB);
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
        } else {
        	response.setStatus(HttpStatus.NO_CONTENT.getReasonPhrase());
    	}
    	
    	return response.getStatus();
    	
    }
    
    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response retrieve(@PathVariable("id") Integer id) {
    	Response response = new Response();
    	BookDTO book = servicio.retrieve(id);
    	
    	if(null == book){
    		response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
    	} else {
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
    	}
        response.setData(book);
        
        return response;
    }
    
    @RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response random() {
    	Response response = new Response();
    	
    	BookDTO book = servicio.retrieve( (int) (Math.random() * servicio.countBooks() + 1));		//TODO hacerlo random de verdad
    	response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(book);
        
        return response;

    }
}

/*
 * 	To Create a resource : HTTP POST should be used
 *	To Retrieve a resource : HTTP GET should be used
 *	To Update a resource : HTTP PUT should be used
 *	To Delete a resource : HTTP DELETE should be used 
 *
- Spring 4 -
@RestController : Esta anotaci'on elimina la necesidad e anotar cada uno de los metodos con @ResponseBody. Es una combinacion of @Controller and @ResponseBody.

@RequestBody : Si el parametro de un metodo se anota con @RequestBody Spring trata de hacer un bind entre la HTTP Request y el parametro. Deserializa el objeto de la request en un objeto de dominio
				
@ResponseBody : Si un metodo es anotado con @ResponseBody, Spring intentara hacer un binding con el valor de retorno Serializa el objeto.

ResponseEntity representa la HTTP response completa. Se puede especificar el status code, los headers, y el body.

@PathVariable Iindica que este parametro pasado al metodo debe tomar su valor de una variable de la URI entre '{}'.

MediaType : Con la anotacion @RequestMapping se puede especificar el MediaType que produce o consume un metodo en particular del controlador.
 */