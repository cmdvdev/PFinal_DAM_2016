
public class FlujoBasico {
/*
	@startuml
		actor cliente
		
		cliente -> controlador : retrieveList(Integer indice)
		activate controlador
		
		controlador -> servicio : retrieveAllPaged(Integer indice)
		activate servicio
		
		servicio -> repositorio : retrieveAllPaged(Integer pageNumber)
		activate repositorio
		
		database BD
		
		repositorio -> BD : query
		activate BD
		BD --> repositorio : List<Book>
		deactivate BD
		
		repositorio --> servicio : List<Book>
		deactivate repositorio
		
		servicio -> transformer : List<Book>
		activate transformer
		transformer --> servicio : List<BookDTO>
		deactivate transformer
		
		servicio --> controlador : List<BookDTO>
		deactivate servicio
		
		controlador --> cliente : Response
		deactivate controlador
	
	@enduml
*/
}
