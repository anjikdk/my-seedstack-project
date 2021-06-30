package org.generated.project.domain.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.generated.project.domain.model.Student;
import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;

public class StudentServiceImpl implements StudentService
{
	@Inject
	@Jpa
	private Repository<Student, Integer> stdRepository;
	
	@Override
	@Transactional
    @JpaUnit("myUnit")
	public Student saveStudent(Student std) {
		
//		System.out.println("Repositiry: "+stdRepository);
		System.out.println("Student Object: "+std);
//		StudentRepository stdRepository = new StudentJPARepository();
		System.out.println("Repositiry: "+stdRepository);
		
		stdRepository.add(std);
		
		return std;
	}
	
}
