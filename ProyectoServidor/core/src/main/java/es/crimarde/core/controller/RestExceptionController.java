package es.crimarde.core.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus; 

/**
 * La anotación @ControllerAdvice aplicará todos los gestores 
 * de excepciones definidos en esta clase a todos los controladores 
 * anotados con @RequestMapping.
 * 
 * De esta forma, cuando algún método de la API produzca el 
 * lanzamiento de una excepción se invocará automáticamente 
 * el método que gestiona la excepciondevolviendo el mensaje 
 * configurado y un código de errorgracias a la anotación 
 * @ResponseStatus
 */
@ControllerAdvice //anotación para aplicar a todos los controladores 
public class RestExceptionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerHandler(NullPointerException e){
        logger.error("NullPointerException!!!");
        StringBuilder errorMsg = new StringBuilder();
    	errorMsg.append(e.getClass()).append(" NullPointerException -> ").append(e.getStackTrace());
        return  errorMsg.toString();
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String numberFormatHandler(NumberFormatException e){
        logger.error("NumberFormatException!!!");
        StringBuilder errorMsg = new StringBuilder();
    	String message = e.getMessage();
 		errorMsg.append(e.getClass()).append(" Identificafor no valido -> ").append(message);
 		
 		return errorMsg.toString();
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public String ioExceptionHandler(NumberFormatException e){
        logger.error("IOException!!!");
        StringBuilder errorMsg = new StringBuilder();
    	String message = e.getMessage();
 		errorMsg.append(e.getClass()).append(" Error al subir el archivo -> ").append(message);
 		
 		return errorMsg.toString();
    }
    
//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
//    
//    @ExceptionHandler(IncorrectGetMethodException.class)
//    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
	  
}