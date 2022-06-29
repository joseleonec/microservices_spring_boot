package ucuenca.ejemplo.store.serviceproduct.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ucuenca.ejemplo.store.serviceproduct.entity.Category;
import ucuenca.ejemplo.store.serviceproduct.entity.Product;
import ucuenca.ejemplo.store.serviceproduct.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // insert constructor
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {

        Product p = productRepository.findById(id).orElse(null);
        return p;
    }

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        // TODO Auto-generated method stub
        Product productUpdate = getProduct(product.getId());
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setCategory(product.getCategory());
            productUpdate.setPrice(product.getPrice());
            return productRepository.save(productUpdate);
        } else {
            return null;
        }
    }

    @Override
    public Product deleteProduct(Long id) {
        // TODO Auto-generated method stub

        Product productUpdate = getProduct(id);

        if (productUpdate != null) {
            productUpdate.setStatus("DELETED");
            return productRepository.save(productUpdate);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        // TODO Auto-generated method stub
        return productRepository.findByCategory(category);
    }

    // @Override
    // public Product updateStock(Long id, double stock) {
    // // TODO Auto-generated method stub

    // Product productUpdate = getProduct(id);

    // if (productUpdate != null) {
    // productUpdate.setStock(stock);
    // return productRepository.save(productUpdate);
    // } else {
    // return null;
    // }
    // }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB = getProduct(id);
        if (null == productDB) {
            return null;
        }
        Double stock = productDB.getStock() + quantity;
        productDB.setStock(stock);
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        // TODO Auto-generated method stub
        return productRepository.findByCategoryId(id);
    }

}