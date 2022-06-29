package ucuenca.ejemplo.store.customerservice.service;

import java.util.List;


import ucuenca.ejemplo.store.customerservice.entity.Customer;
import ucuenca.ejemplo.store.customerservice.entity.Region;

public interface CustomerService {

    public List<Customer> findCustomerAll();

    public Customer findCustomerById(Long id);

    public List<Customer> findCustomerByRegion(Region region);

    public List<Customer> findCustomerByRegionId(Long id);

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Customer deleteCustomer(Customer customer);


}
