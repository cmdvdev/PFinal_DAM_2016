package es.crimarde.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.crimarde.dao.DataDAO;
import es.crimarde.model.Employee;

@Repository("dataDAOImpl")
public class DataDAOImpl extends BaseDAOImpl<Employee, Long> implements DataDAO {

	public DataDAOImpl() {
		super();
		setMyClass(Employee.class);
	}
	
	@Override
	public long insertRow(Employee employee) {
		save(employee);
		return employee.getId();
	}

	@Override
	public Employee findById(Long key) {
		return (Employee) getSession().load(getMyClass(), key);
	}
	
	@Override
	public List<Employee> getList() {
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = getSession().createQuery("from Employee").list();
		return employeeList;
	}

	@Override
	public Employee getRowById(long id) {
		Employee employee = findById(id);
		return employee;
	}

	@Override
	public void updateRow(Employee employee) {
		update(employee);
	}

	@Override
	public long deleteRow(long id) {
		delete(getRowById(id));
		return (Long) id;
	}
	
	public Employee checkDuplicateInsert(Employee emp){
		Employee employee = null;
		Criteria criteria = getSession().createCriteria(getMyClass());
		criteria.add(Restrictions.eq("firstName", emp.getFirstName()))
			.add(Restrictions.eq("lastName", emp.getFirstName()))
			.add(Restrictions.eq("email", emp.getFirstName()))
			.add(Restrictions.eq("phone", emp.getFirstName()));
		employee = (Employee) criteria.uniqueResult();
		return employee;
	}

}
