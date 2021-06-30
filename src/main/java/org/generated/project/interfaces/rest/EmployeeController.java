package org.generated.project.interfaces.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.generated.project.domain.Employee;
import org.generated.project.kafka.KafkaEmpProducer;

@Path("employee")
public class EmployeeController {

	@Inject
	private KafkaEmpProducer kafkaEmpProducer;
	
	@POST
	@Path("empKafka")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee sendEmpToKafka(Employee emp) throws InterruptedException, IOException {

		kafkaEmpProducer.empProduce(emp);
		
		return emp;
	}
	
	

}
