package telran.java52.person.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.java52.person.dto.CityPopulationDto;
import telran.java52.person.model.Child;
import telran.java52.person.model.Employee;
import telran.java52.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

//	@Query(value = "", nativeQuery = true) // <- nativeQuery, дурной тон писать на nativeQuery
	@Query("select p from Citizen p where p.name = ?1") // <- JPQL, лучше использовать JPQL - обьектно ориентированный язык sql запросов
	Stream<Person> findPersonsByNameIgnoreCase(String name);

	@Query("select p from Citizen p where p.address.city = :cityName") // <- JPQL
	Stream<Person> findPersonsByAddressCityIgnoreCase(@Param("cityName") String city);

//	@Query("SELECT p FROM Person p WHERE p.birthDate BETWEEN :maxAge AND :minAge") // <- JPQL
//	List<Person> findPersonsByBirthDateBetween(@Param("minAge") LocalDate minAge, @Param("maxAge") LocalDate maxAge);
	Stream<Person> findPersonsByBirthDateBetween(LocalDate from, LocalDate to);
	
	@Query("select new telran.java52.person.dto.CityPopulationDto(p.address.city, count(p)) from Citizen p group by p.address.city order by count(p) desc") // <- JPQL
	List<CityPopulationDto>  getCitiesPopulation(); // SELECT city,count(*) FROM  java52.person GROUP BY city ORDER BY count(*) DESC; <- SQL

    Stream<Child> findAllChildrenBy();
	
	List<Employee> findBySalaryBetween(Integer from,  Integer to);

	
}
