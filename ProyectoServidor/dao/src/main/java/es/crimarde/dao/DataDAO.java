package es.crimarde.dao;

import java.util.List;

import es.crimarde.model.Employee;

public interface DataDAO {
	
	public long insertRow(Employee employee);

	public List<Employee> getList();

	public Employee getRowById(long id);

	public void updateRow(Employee employee);

	public long deleteRow(long id);
	
	public Employee checkDuplicateInsert(Employee emp);

}
