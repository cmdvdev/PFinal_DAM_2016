package es.crimarde.core.model;

import java.util.List;

import es.crimarde.negocio.BookDTO;

public class ResponseList {
	
	private String status;
	private List<BookDTO> data;
	
	public ResponseList() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookDTO> getData() {
		return data;
	}

	public void setData(List<BookDTO> data) {
		this.data = data;
	}
	
	
}
