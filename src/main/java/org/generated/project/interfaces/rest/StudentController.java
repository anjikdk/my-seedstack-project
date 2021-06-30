package org.generated.project.interfaces.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.generated.project.domain.model.Student;
import org.generated.project.domain.services.StudentService;

@Path("/student")
public class StudentController {

	@Inject
	private StudentService stdService;
	
	@POST
	@Path("saveStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Student saveStudent(Student std)
	{
		stdService.saveStudent(std);
		
		return std;
	}
}
