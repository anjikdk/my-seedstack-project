package org.generated.project.interfaces.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.generated.project.domain.model.Student;
import org.generated.project.domain.services.StudentService;

@Path("student")
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
	
	@GET
	@Path("getStudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("id") Integer id)
	{
		return stdService.getStudent(id);
	}
	
	@GET
	@Path("getStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent()
	{
		return stdService.getAllStudents();
	}
	
	@GET
	@Path("getStudentsByFname/{fname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByFname(@PathParam("fname") String fname)
	{
		return stdService.getStudentsByFname(fname);
	}
	
	@GET
	@Path("getStudentsByFnameOrLname/{fnameOrLname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByFnameOrLname(@PathParam("fnameOrLname") String fnameOrLname)
	{
		return stdService.getStudentsByFnameOrLaname(fnameOrLname);
	}
	
	@GET
	@Path("getAllStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentList()
	{
		return stdService.getAllStudentsByUsingSpecification();
	}
}
