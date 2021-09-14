package net.proselyte.personAndCars.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "clear")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Clear {
  private Person person;
  private Car Car;
}
