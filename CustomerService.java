package com.jspider.jdbc_prepared_statement_crud_project_architecture.Service;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.dao.CustomerDao;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;

public class CustomerService {
	CustomerDao customerdao = new CustomerDao();

	public int saveCustomerService(Customer customer) {
		int id = customer.getId();
		if (id > 9999 && id < 100000) {
			return customerdao.saveCustomerDao(customer);
		} else {
			System.out.println("you should pass id with 5 digits only");
			return 0;
		}
	}
	public int updateCustomerNameById(int id ,String name) {

		if (id > 9999 && id < 100000) {
			
			return customerdao.updateCustomerDao(id, name);
		} else {
			System.out.println("you should pass id with 5 digits only");
			return 0;
		}
		
	}
}
