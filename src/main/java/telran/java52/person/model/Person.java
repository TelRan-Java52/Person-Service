package telran.java52.person.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name="Citizen") // это будет сущность таблицы
@Table(name="person") // название таблицы с которой будут связяны сущности
public class Person implements Serializable {
	private static final long serialVersionUID = 2881753026638817581L;
	@Id
	Integer id;
	@Setter
	String name;
	LocalDate birthDate;
	@Setter
	Address address;
}
