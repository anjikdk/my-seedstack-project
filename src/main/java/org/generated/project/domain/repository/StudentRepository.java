package org.generated.project.domain.repository;

import java.util.List;

import org.generated.project.domain.model.Student;
import org.seedstack.business.domain.Repository;

public interface StudentRepository extends Repository<Student, Integer>
{
	public List<Student> getAllStudents();
	
	public List<Student> getAllStudentsByUsingSpecification();
}
