package telran.java52.person.service;

import telran.java52.person.dto.AddressDto;
import telran.java52.person.dto.CityPopulationDto;
import telran.java52.person.dto.PersonDto;

public interface PersonService {
	Boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(Integer id);
	
	PersonDto removePerson(Integer id);

    PersonDto updatePersonName(Integer id, String name);

    PersonDto updatePersonAddress(Integer id, AddressDto addressDto);

    PersonDto[] findPersonsByCity(String city);

    PersonDto[] findPersonsByName(String name);

    PersonDto[] findPersonsBetweenAge(Integer minAge, Integer maxAge);

    Iterable<CityPopulationDto> getCitiesPopulation();

	PersonDto[] findAllChildren();

	PersonDto[] findEmployeesBySalary(Integer from, Integer to);


}
