package net.proselyte.personAndCars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "cars")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_car")
  private long carId;

  @Column(name = "vendor")
  private String vendor;

  @Column(name = "model")
  private String model;

  @Column(name = "horsepower")
  private Integer horsepower;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Person person;

}
