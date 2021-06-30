package org.generated.project.domain.repository;

import org.generated.project.domain.model.Student;
import org.seedstack.business.domain.Repository;

public interface StudentRepository extends Repository<Student, Integer>
{
	public Student saveStudent(Student std);
}
