package ucuenca.ejemplo.store.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ucuenca.ejemplo.store.customerservice.entity.Customer;
import ucuenca.ejemplo.store.customerservice.entity.Region;
import ucuenca.ejemplo.store.customerservice.repository.CustomerRepository;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    public static org.slf4j.Logger getLog() {
        return log;
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        // TODO Auto-generated method stub

        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        // TODO Auto-generated method stub
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findCustomerByRegion(Region region) {
        // TODO Auto-generated method stub
        return customerRepository.findByRegion(region);
    }

    @Override
    public List<Customer> findCustomerByRegionId(Long id) {
        // TODO Auto-generated method stub
        return customerRepository.findByRegionId(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        Customer customerUpdate = findCustomerById(customer.getId());
        if (customerUpdate != null) {
            customerUpdate.setFirstName(customer.getFirstName());
            customerUpdate.setLastName(customer.getLastName());
            customerUpdate.setEmail(customer.getEmail());
            customerUpdate.setPhotoUrl(customer.getPhotoUrl());
            return customerRepository.save(customerUpdate);
        } else {
            return null;
        }
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        // TODO Auto-generated method stub
        // Delete customer
        Customer customerUpdate = findCustomerById(customer.getId());
        if (customerUpdate != null) {
            customerUpdate.setState("DELETED");
            return customerRepository.save(customerUpdate);
        } else {
            return null;
        }

    }

}
