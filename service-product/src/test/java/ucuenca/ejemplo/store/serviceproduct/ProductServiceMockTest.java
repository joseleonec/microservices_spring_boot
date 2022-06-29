package ucuenca.ejemplo.store.serviceproduct;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import ucuenca.ejemplo.store.serviceproduct.entity.Category;
import ucuenca.ejemplo.store.serviceproduct.entity.Product;
import ucuenca.ejemplo.store.serviceproduct.repository.ProductRepository;
import ucuenca.ejemplo.store.serviceproduct.service.ProductService;
import ucuenca.ejemplo.store.serviceproduct.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    // @Autowired
    private ProductService productService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);

        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .description("Computer description")
                .category(Category.builder().id(1L).build())
                .price(100.0).status("CREATED")
                .stock(10.0)
                .createAt(new Date()).build();

        Mockito.when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct() {
        Product product = productService.getProduct(1L);
        Assertions.assertThat(product.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock() {
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("pservice: " + newStock.toString());
        Assertions.assertThat(newStock.getStock()).isEqualTo(18);
    }

}
