package com.Lti.microservices_producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Lti.microservices_producer.model.*;

@RestController
public class Controller {
	@RequestMapping(value="/staffservice")
	public String getStaffdetails() {
		return "Staff details service";
	}
	

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

}
