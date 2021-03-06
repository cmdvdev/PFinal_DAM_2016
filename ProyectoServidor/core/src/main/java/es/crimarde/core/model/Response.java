package es.crimarde.core.model;

import org.springframework.http.HttpStatus;

import es.crimarde.negocio.BookDTO;

public class Response {
	
	private String status;
	private BookDTO data;
	
	public Response() {
	}
	
	public Response(HttpStatus status) {
		this.status = status.getReasonPhrase();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BookDTO getData() {
		return data;
	}

	public void setData(BookDTO data) {
		this.data = data;
	}
	
	
}
