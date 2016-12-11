package es.crimarde.core.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.crimarde.negocio.BookDTO;

@SuppressWarnings("serial")
public class ResponseList implements Serializable {
	
	private String status;
	private List<BookDTO> data;
	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	private Integer numOfPages;
	private Integer actualPage;
	private Integer pageSize;
	private long totalElements;
	private boolean isFirst;
	private boolean isLast;

	public ResponseList() {
	}
	
	public ResponseList(Page<BookDTO> pagedList) {
		this.data = pagedList.getContent();
		this.actualPage = pagedList.getNumber();
		this.numOfPages = pagedList.getTotalPages();
		this.pageSize = pagedList.getSize();
		this.isFirst = pagedList.isFirst();
		this.isLast = pagedList.isLast();
		this.totalElements = pagedList.getTotalElements();
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

	public Integer getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}

	public Integer getActualPage() {
		return actualPage;
	}

	public void setActualPage(Integer actualPage) {
		this.actualPage = actualPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
