package telran.java52.person.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java52.person.dto.AddressDto;
import telran.java52.person.dto.CityPopulationDto;
import telran.java52.person.dto.PersonDto;
import telran.java52.person.service.PersonService;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
	final PersonService personService;
	
	
	@PostMapping
	public Boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
	
	@GetMapping("/{id}")
	public PersonDto findPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}
	
	@DeleteMapping("/{id}")
    public PersonDto removePerson(@PathVariable Integer id) {
        return personService.removePerson(id);
    }

    @PutMapping("/{id}/name/{name}")
    public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
        return personService.updatePersonName(id, name);
    }

    @PutMapping("/{id}/address")
    public PersonDto updatePersonAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        return personService.updatePersonAddress(id, addressDto);
    }

    @GetMapping("/name/{name}")
    public PersonDto[] findByName(@PathVariable String name) {
        return personService.findPersonsByName(name);
    }

    @GetMapping("/city/{city}")
    public PersonDto[] findByCity(@PathVariable String city) {
        return personService.findPersonsByCity(city);
    }

    @GetMapping("/ages/{min}/{max}")
    public PersonDto[] findPersonsBetweenAge(@PathVariable Integer min, @PathVariable Integer max) {
        return personService.findPersonsBetweenAge(min, max);
    }

    @GetMapping("/population/city")
    public Iterable<CityPopulationDto> getCitiesPopulation() {
        return personService.getCitiesPopulation();
    }
    @GetMapping("/children")
	public PersonDto[] findAllChildren() {
		return personService.findAllChildren();
	}

	@GetMapping("/salary/{from}/{to}")
	public PersonDto[] findEmployeesBySalary(@PathVariable Integer from, @PathVariable Integer to) {
		return personService.findEmployeesBySalary(from, to);
	}
}
