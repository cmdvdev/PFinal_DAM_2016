package es.crimarde.core.model;

import es.crimarde.model.Book;

public class Response {
	
	private String status;
	private Book data;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Book getData() {
		return data;
	}

	public void setData(Book data) {
		this.data = data;
	}
	
	
}
