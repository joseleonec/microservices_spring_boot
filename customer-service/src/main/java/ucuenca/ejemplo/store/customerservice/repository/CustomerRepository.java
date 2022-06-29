package ucuenca.ejemplo.store.customerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucuenca.ejemplo.store.customerservice.entity.Customer;
import ucuenca.ejemplo.store.customerservice.entity.Region;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByNumberID(String numberID);

    public List<Customer> findByLastName(String lastName);

    public List<Customer> findByRegion(Region region);

    public List<Customer> findByRegionId(long id);
}