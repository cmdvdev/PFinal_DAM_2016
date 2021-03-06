package es.crimarde.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import es.crimarde.core.model.ResponseList;
import es.crimarde.negocio.BookDTO;
import es.crimarde.service.BookService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes =Application.class)
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	
	@Mock private BookService servicio;
	@InjectMocks private Controller controller = new Controller();
	
	
	@Test
	public void responseList(){
		MockitoAnnotations.initMocks(ControllerTest.class);
		
		List<BookDTO> lista = buildBookList(5);
		Mockito.when(servicio.retrieveAll()).thenReturn(lista);
		
		ResponseList response = controller.retrieveList(1);
		
		Assert.assertThat(response, Matchers.isA(ResponseList.class));
		Assert.assertThat(response.getStatus(), Matchers.is(HttpStatus.OK.name()));
		Assert.assertThat(response.getData(), Matchers.not(Matchers.is(Matchers.empty())));
		Assert.assertThat(response.getData().size(), Matchers.is(lista.size()));
		
	}
	
	
	private List<BookDTO> buildBookList(int elementos){
		
		List<BookDTO> lista = new ArrayList<>();
		
		for(int i = 0; i<elementos; i++){
			lista.add(buildBook(i));
		}
		
		return lista;
		
	}
	
	private BookDTO buildBook(int order){
		BookDTO book = new BookDTO().builder()
				.whithId(1L)
				.whithAutor("autor".concat(String.valueOf(order)))
				.whithPrecio(new Long(order))
				.whithSinopsis("resumen libro ".concat(String.valueOf(order)))
				.whithTitulo("Titulo".concat(String.valueOf(order)))
				.build();
		
		return book;
	}
}
