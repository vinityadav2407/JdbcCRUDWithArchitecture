package com.jspider.jdbc_prepared_statement_crud_project_architecture.Controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.Service.CustomerService;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dao.CustomerDao;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;

public class CustomerController {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("1.INSERT\n2.DISPLAY_BYID\n3.UPDATE_NAME\n4.DELETE_DATA_BY_ID\n5.DISPALY_ALLDATA_BYID");
			System.out.println("Enter your choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the customer id");
				int id = s.nextInt();
				System.out.println("Enter the customer name");
				String name = s.next();

				System.out.println("Enter the customer email");
				String email = s.next();
				System.out.println("Enter the customer phone");
				Long phone = s.nextLong();
				Customer c1 = new Customer();
				c1.setId(id);
				c1.setName(name);
				c1.setEmail(email);
				c1.setPhone(phone);
				CustomerService service = new CustomerService();
				int result = service.saveCustomerService(c1);
				String response = (result != 0) ? "Data Stored " : "Data not stored pls check sql query";
				System.out.println(response);

			}
				break;

			case 2: {
				System.out.println("Enter the customer id");
				int id = s.nextInt();
				CustomerDao dao = new CustomerDao();
				Customer customerdetails = dao.displayCustomerbyId(id);
				System.out.println(customerdetails);
			}
				break;
			case 3: {
				System.out.println("enter the customer id to update");
				int id = s.nextInt();
				System.out.println("Enter the new name");
				String name = s.next();
				CustomerService service = new CustomerService();
				int result = service.updateCustomerNameById(id, name);
				String response = (result != 0) ? "Name updated " : "Name not updated pls check sql query";
				System.out.println(response);

			}
				break;
			case 4: {
				System.out.println("Enter the customer id to delete");
				int id = s.nextInt();
				CustomerDao dao = new CustomerDao();
				boolean response = dao.deleteCustomerbyId(id);
				System.out.println("data deletion processe is" + response);
			}
				break;
			case 5:{
				System.out.println("Enter the customer id to Disaplay alldata");
				int id = s.nextInt();
				CustomerDao dao = new CustomerDao();
				List<Customer>customer=dao.displayAllCustomerbyId(id);
				for(Customer cus: customer) {
					System.out.println(cus);
				}
				
			}break;

			default: {

			}

			}

		}

	}

}
