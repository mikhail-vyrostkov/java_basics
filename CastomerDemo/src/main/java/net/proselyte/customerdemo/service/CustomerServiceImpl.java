package net.proselyte.customerdemo.service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.CustomerModel;
import net.proselyte.customerdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public CustomerModel getById(Long id) {
    log.info("IN CustomerServiceImp getById {}", id);
    return CustomerModel.toModel(customerRepository.findById(id).get());
  }

  @Override
  public void save(Customer customer) {
    log.info("IN CustomerServiceImp save {}", customer);
    customerRepository.save(customer);
  }

  @Override
  public void delete(Long id) {
    log.info("IN CustomerServiceImp delete {}", id);
    customerRepository.deleteById(id);
  }

  @Override
  public List<CustomerModel> getAll() {
    log.info("IN CustomerServiceImp getAll");
    Iterable<Customer> customerIterable = customerRepository.findAll();
    List<CustomerModel> customers = new ArrayList<>();
    for (Customer customer : customerIterable){
      customers.add(CustomerModel.toModel(customer));
    }
    return customers;
  }
}
