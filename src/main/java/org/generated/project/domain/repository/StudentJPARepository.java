package org.generated.project.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.generated.project.domain.model.Student;
import org.seedstack.business.specification.Specification;
import org.seedstack.business.specification.dsl.SpecificationBuilder;
import org.seedstack.jpa.BaseJpaRepository;

public class StudentJPARepository extends BaseJpaRepository<Student, Integer> implements StudentRepository
{
	@Inject
	private SpecificationBuilder specificationBuilder;
	
	@Inject
	private StudentRepository stdCustomRepository;
	
	public List<Student> getAllStudents()
	{
		String query = "select s from Student s";
		EntityManager entityManager = getEntityManager();
		@SuppressWarnings("unchecked")
		List<Student> stdList = entityManager.createQuery(query).getResultList();
		
		return stdList;
	}
	
	public List<Student> getAllStudentsByUsingSpecification()
	{
		Specification<Student> specification = specificationBuilder.of(Student.class).all().build();
//		specification = specification.and(specificationBuilder.of(Student.class)).;
		
		return stdCustomRepository.get(specification).collect(Collectors.toList());
	}
}
