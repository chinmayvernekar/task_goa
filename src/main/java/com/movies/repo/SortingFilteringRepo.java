/*
 * package com.movies.repo;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.criteria.CriteriaBuilder;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository public class SortingFilteringRepo {
 * 
 * @Autowired EntityManager entityManager;
 * 
 * @Autowired CriteriaBuilder criteriaBuilder;
 * 
 * // private static void executeQuery() { //
 * System.out.println("-- executing query --"); // EntityManager em =
 * entityManagerFactory.createEntityManager(); // Query query =
 * em.createQuery("SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t"); //
 * List<Employee> resultList = query.getResultList(); //
 * resultList.forEach(System.out::println); // em.close(); // }
 * 
 * }
 */