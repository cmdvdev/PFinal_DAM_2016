package es.crimarde.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.crimarde.core.model.Response;
import es.crimarde.core.model.ResponseList;
import es.crimarde.negocio.BookDTO;
import es.crimarde.negocio.ImageDTO;
import es.crimarde.service.BookService;
import es.crimarde.service.ImageService;

@CrossOrigin()
@RestController
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BookService bookservice;
	@Autowired ImageService imageService;

	//@CrossOrigin(origins = "http://localhost:3000")
	@ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value = "/lista/{indice}", method = RequestMethod.GET)
    public ResponseList retrieveList(@PathVariable("indice") Integer indice) {
    	
    	logger.info("-- Listado de todos los libros --");
        
    	Page<BookDTO> books = bookservice.retrieveAllPaged(indice);
    	//List<BookDTO> books = bookservice.retrieveAll();
        //servicio.retrieveAll().forEach(books::add);
    	
    	ResponseList response = new ResponseList(books);
                
        if(books.getContent().isEmpty()) {
        	response.setStatus(HttpStatus.NO_CONTENT.getReasonPhrase());
        	logger.debug("Se devuelve un mensaje de error. No hay libros en la base de datos");
        } else {
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
    		response.setData(books.getContent());
    		logger.info("Se devuelve lista de libros\n".concat(objectToJson(response)));
    	}
        
        return response;
    }
    
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/book/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response add(@RequestBody BookDTO bookDTO) {
    	
    	logger.info("-- Añadir libro --");
    	logger.info(String.format("-- Se intenta añadir el titulo: '%s' --", bookDTO.getTitulo()));
    	
    	Response response = new Response();
    	String status;
    	if(bookservice.existsBook(bookDTO)){
    		status = HttpStatus.CONFLICT.getReasonPhrase();
    		logger.info("El libro ya existe");
    	} else {
    		ImageDTO imageDTO = imageService.loadImage(bookDTO.getIdImagen());
    		bookDTO.setImagen(imageDTO);
    		bookservice.add(bookDTO);
    		status = HttpStatus.CREATED.getReasonPhrase();
    		logger.info("Libro añadido correctamente");
    	}
    	
    	response.setStatus(status);
    	return response;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") Long id) {
    	
    	logger.info(String.format("-- Eliminacion del libro con id %d --",id.intValue()));
    	
    	BookDTO bookDTO = bookservice.retrieve(id);
        
    	if(null != bookDTO){
    		bookservice.delete(bookDTO.getId());
    		logger.info("Libro eliminado correctamente");
    		return new Response(HttpStatus.OK);
    	}
    	logger.info("El libro no existe");
    	return new Response(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Response edit(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
    	
    	logger.info(String.format("-- Edicion de libro con id %d --",id.intValue()));
    	
    	Response response = new Response();
    	BookDTO bookDtoFromDB = bookservice.retrieve(id);
    	
    	if(null != bookDtoFromDB) {
    		
    		if(bookDTO.getIdImagen() != null){
    			ImageDTO imageDTO = imageService.loadImage(bookDTO.getIdImagen());
    			bookDTO.setImagen(imageDTO);
    		}
    		
    		String[] ignoreProperties = {"id"};
    		BeanUtils.copyProperties(bookDTO, bookDtoFromDB, ignoreProperties);
    		
    		bookservice.update(bookDtoFromDB);
    		logger.info("Libro modificado correctamente");
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
        } else {
        	logger.info("El libro no se ha podido modificar");
        	response.setStatus(HttpStatus.NO_CONTENT.getReasonPhrase());
    	}
    	
    	return response;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/book/retrieve/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response retrieve(@PathVariable("id") String id) {
    	
    	Long identificador = Long.valueOf(id);
    	
    	logger.info(String.format("-- Recuperacion de libro con %d --",identificador.intValue()));
    	
    	Response response = new Response();
    	BookDTO book = bookservice.retrieve(identificador);
    	
    	if(null == book){
    		response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
    		logger.info("El Libro no existe y no se hapodido eliminar");
    	} else {
    		response.setStatus(HttpStatus.OK.getReasonPhrase());
    		logger.info("Libro recuperado correctamente");
    	}
        response.setData(book);
        
        //header("Access-Control-Allow-Origin: *");
        //header("Access-Control-Request-Headers: Content-Type, Authorization");
        
        return response;
    }
    
    @RequestMapping(value = "/book/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response random() {
    	
    	logger.info("Solicitado libro aleatorio");
    	
    	Response response = new Response();
    	
    	BookDTO book = bookservice.retrieve( (long) (Math.random() * bookservice.countBooks() + 1));		//TODO hacerlo random de verdad
    	response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setData(book);
        
        logger.info("Devuelto libro aleatorio");
        return response;

    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/search/{searchWord}/page/{page}", method = RequestMethod.GET)
    public ResponseList search(@PathVariable("searchWord") String searchWord,@PathVariable("page") String page) {
    	
    	logger.info(String.format("-- Busqueda de libro por la palabra %s --", searchWord));
    	
    	Integer numPag = Integer.valueOf(page);  //Control de errores (RestExceptionController)
    	
    	//List<BookDTO> bookDTOList = bookservice.searchBooks(searchWord);
    	Page<BookDTO> pageResponseDTO = bookservice.searchBooksPaged(numPag, searchWord);
        
    	ResponseList response = new ResponseList(pageResponseDTO);
    	response.setStatus(HttpStatus.OK.getReasonPhrase());
    	
    	return response;
    }
    
    private String objectToJson(Object object){
    	String stringResponse = null;
    	ObjectMapper objectMapper = new ObjectMapper();
		
    	try {
			stringResponse = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("Error al transformar el objeto de salida a json");
		}
    	
    	return stringResponse;
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