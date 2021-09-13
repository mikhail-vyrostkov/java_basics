package net.proselyte.customerdemo.service;

import java.util.List;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.CustomerModel;

public interface CustomerService {

  CustomerModel getById(Long id);

  void save(Customer customer);

  void delete(Long id);

  List<CustomerModel> getAll();

}
