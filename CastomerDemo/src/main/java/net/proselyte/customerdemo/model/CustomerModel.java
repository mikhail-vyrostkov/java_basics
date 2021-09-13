package net.proselyte.customerdemo.model;

import javax.persistence.Column;
import lombok.Data;

@Data
public class CustomerModel {

  private long id;
  private String firstName;
  private String lastName;
  private String mail;

  public static CustomerModel toModel(Customer customer){
    CustomerModel model = new CustomerModel();
    model.setId(customer.getId());
    model.setFirstName(customer.getFirstName());
    model.setLastName(customer.getLastName());
    model.setMail(customer.getEmail());
    return model;
  }


}
