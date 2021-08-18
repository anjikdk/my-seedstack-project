package org.generated.project.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.generated.project.domain.model.Student;
import org.generated.project.domain.repository.StudentRepository;
import org.generated.project.exception.DataNotFoundException;
import org.seedstack.business.domain.Repository;
import org.seedstack.business.specification.Specification;
import org.seedstack.business.specification.dsl.SpecificationBuilder;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;

public class StudentServiceImpl implements StudentService
{
	@Inject
    private SpecificationBuilder specificationBuilder;
	
	@Inject
	@Jpa
	private Repository<Student, Integer> stdRepository;

	@Inject
	private StudentRepository stdCustomRepository;

	@Override
	@Transactional
	@JpaUnit("myUnit")
	public Student saveStudent(Student std) {

		stdRepository.add(std);

		return std;
	}

	@Override
	@Transactional
	@JpaUnit("myUnit")
	public Student getStudent(Integer id) {
		return stdRepository.get(id).orElseThrow(() -> new DataNotFoundException("Student Details are not found for Id: "+ id));
	}

	@Override
	@Transactional
	@JpaUnit("myUnit")
	public List<Student> getAllStudents() {

		return stdCustomRepository.getAllStudents();
	}

	@Override
	@Transactional
	@JpaUnit("myUnit")
	public List<Student> getStudentsByFname(String fname){
		
		Specification<Student> stdSpec = specificationBuilder.of(Student.class)
				.property("fname").equalTo(fname)
				.build();
		
		return stdRepository.get(stdSpec).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	@JpaUnit("myUnit")
	public List<Student> getStudentsByFnameOrLaname(String fnameOrLname){
		
		Specification<Student> stdSpec = specificationBuilder.of(Student.class)
				.property("fname").equalTo(fnameOrLname)
				.or()
				.property("lname").equalTo(fnameOrLname)
				.build();
		
		return stdRepository.get(stdSpec).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	@JpaUnit("myUnit")
	public List<Student> getAllStudentsByUsingSpecification() {

		return stdCustomRepository.getAllStudentsByUsingSpecification();
	}
}
