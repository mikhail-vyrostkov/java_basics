package net.proselyte.personAndCars.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "personwithcars")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithCars {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

 // @OneToMany(cascade = CascadeType.ALL, mappedBy = "personWithCars")
 // private List<Car> cars;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "personWithCars")
  private Person person;

}

