package org.generated.project.domain.repository;

import javax.persistence.EntityManager;

import org.generated.project.domain.model.Student;
import org.seedstack.jpa.BaseJpaRepository;

//@Jpa
public class StudentJPARepository extends BaseJpaRepository<Student, Integer> implements StudentRepository
{
	public Student saveStudent(Student std)
	{
		EntityManager entityManager = getEntityManager();
		entityManager.persist(std);
		
		return std;
	}
}
