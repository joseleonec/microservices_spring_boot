package ucuenca.ejemplo.store.serviceproduct;


import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ucuenca.ejemplo.store.serviceproduct.entity.Category;
import ucuenca.ejemplo.store.serviceproduct.entity.Product;
import ucuenca.ejemplo.store.serviceproduct.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct() {

        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("CREATED")
                .createAt(new Date()).build();
        // Product product02 = new Product(1L, "computer",
        // Category.builder().id(1L).build(), 10, 10.0, "CREATED", new Date());
        // Product product02 = new Product();

        // product02.setName("name");
        // product02.setCategory(Category.builder().id(1L).build());
        // product02.setDescription("description");
        // product02.setStock(10.0);
        // product02.setPrice(10.0);
        // product02.setStatus("CREATED");
        // product02.setCreateAt(new Date());

        // System.out.println(product02.toString());

        this.productRepository.save(product01);

        List<Product> founds = this.productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);

    }

    // @Test
    // public void testFindByName() {
    //     Product product = productRepository.findByName("Product 1");
    //     assert product == null;
    // }
}
