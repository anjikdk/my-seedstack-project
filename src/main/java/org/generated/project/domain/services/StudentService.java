package org.generated.project.domain.services;

import java.util.List;

import org.generated.project.domain.model.Student;
import org.seedstack.business.Service;

@Service
public interface StudentService {

	public Student saveStudent(Student std);

	public Student getStudent(Integer id);
	
	public List<Student> getAllStudents();
}
