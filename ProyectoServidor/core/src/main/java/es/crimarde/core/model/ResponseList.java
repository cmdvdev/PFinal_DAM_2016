package es.crimarde.core.model;

import java.util.List;

import es.crimarde.model.Book;

public class ResponseList {
	
	private String status;
	private List<Book> data;
	
	public ResponseList() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Book> getData() {
		return data;
	}

	public void setData(List<Book> data) {
		this.data = data;
	}
	
	
}