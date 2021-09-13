package net.proselyte.customerdemo.rest;

import java.util.List;
import javax.validation.Valid;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.CustomerModel;
import net.proselyte.customerdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerRestControllerV1 {

  @Autowired
  private CustomerService customerService;


  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 // @PreAuthorize("hasAuthority('customer:read')")
  public ResponseEntity<CustomerModel> getCustomer(@PathVariable("id") Long customerId) {
    if (customerId == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    CustomerModel customer = this.customerService.getById(customerId);
    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(customer, HttpStatus.OK);

  }

  @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 // @PreAuthorize("hasAuthority('customer:write')")
  public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer) {
    HttpHeaders headers = new HttpHeaders();

    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    this.customerService.save(customer);
    return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
  }

  @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 // @PreAuthorize("hasAuthority('customer:write')")
  public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer,
      UriComponentsBuilder builder) {
    HttpHeaders headers = new HttpHeaders();

    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    this.customerService.save(customer);
    return new ResponseEntity<>(customer, headers, HttpStatus.OK);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 // @PreAuthorize("hasAuthority('customer:write')")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId) {
    CustomerModel customer = this.customerService.getById(customerId);

    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    this.customerService.delete(customerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 // @PreAuthorize("hasAuthority('customer:read')")
  public ResponseEntity<List<CustomerModel>> getAllCustomers() {
    List<CustomerModel> customers = this.customerService.getAll();
    if (customers.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }

}
