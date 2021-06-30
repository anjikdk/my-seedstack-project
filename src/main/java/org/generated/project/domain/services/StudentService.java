package org.generated.project.domain.services;

import org.generated.project.domain.model.Student;
import org.seedstack.business.Service;

@Service
public interface StudentService {

	public Student saveStudent(Student std);
}
