package net.proselyte.customerdemo.security;

import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customerDetailsServiceImpl")
public class CustomerDetailsServiceImpl implements UserDetailsService {

  private  final CustomerRepository customerRepository;

  @Autowired
  public CustomerDetailsServiceImpl(
      CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Customer customer = customerRepository.findByEmail(email).orElseThrow(() ->
        new UsernameNotFoundException("Customer doesn't exists"));
    return SecurityCustomer.fromCustomer(customer);
  }
}
