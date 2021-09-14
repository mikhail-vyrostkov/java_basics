package net.proselyte.personAndCars.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Statistic {

  @Column(name = "personcount")
  private Long personCount;

  @Column(name = "cercount")
  private Long cerCount;

  @Column(name = "uniquevendorcount")
  private Long uniqueVendorCount;

}
