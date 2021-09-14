package net.proselyte.personAndCars.model;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "persons")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_person")
  private long personId;
  @Column(name = "name")
  private String name;
  @Column(name = "birthdate")
  private LocalDate birthdate;


 // @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
 // private List<Car> cars;

  @JoinColumn(name = "id")
  @OneToOne
  private PersonWithCars personWithCars;
}
