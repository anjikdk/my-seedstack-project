package org.generated.project.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.generated.project.domain.model.Student;
import org.seedstack.jpa.BaseJpaRepository;

public class StudentJPARepository extends BaseJpaRepository<Student, Integer> implements StudentRepository
{
	public List<Student> getAllStudents()
	{
		String query = "select s from Student s";
		EntityManager entityManager = getEntityManager();
		@SuppressWarnings("unchecked")
		List<Student> stdList = entityManager.createQuery(query).getResultList();
		
		return stdList;
	}
}
