package ucuenca.ejemplo.store.serviceproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucuenca.ejemplo.store.serviceproduct.entity.Category;
import ucuenca.ejemplo.store.serviceproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    public List<Product> findByCategory(Category category);

    public List<Product> findByCategoryId(Long categoryId);

}