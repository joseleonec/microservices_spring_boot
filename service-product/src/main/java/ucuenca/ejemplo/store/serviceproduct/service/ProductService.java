package ucuenca.ejemplo.store.serviceproduct.service;

import java.util.List;

import ucuenca.ejemplo.store.serviceproduct.entity.Category;
import ucuenca.ejemplo.store.serviceproduct.entity.Product;

public interface ProductService {

    public List<Product> listAllProducts();

    public Product getProduct(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Product product);

    public Product deleteProduct(Long id);

    public List<Product> findByCategory(Category category);

    public List<Product> findByCategoryId(Long id);

    public Product updateStock(Long id, Double quantity);

}
