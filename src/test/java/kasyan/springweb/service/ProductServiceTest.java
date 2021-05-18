package kasyan.springweb.service;

import kasyan.springweb.bean.Product;
import kasyan.springweb.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private UtilService utilService;

    ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
        productService.setProductRepository(productRepository);
        productService.setUtilService(utilService);
    }

    @Test
    void findAll() {
        var data = new Date();
        Mockito.when(productRepository.findAll())
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data)));

        List<Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data));

        List<Product> actual = productService.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void findById() {
        var data = new Date();
        Mockito.when(productRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));

        Optional<Product> expected = Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data));

        Optional<Product> actual = productService.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    void fineCategoryForRead() {
        var data = new Date();
        Mockito.when(productRepository.findByCategory(Mockito.any(String.class)))
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data)));

        List<Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data));

        List<Product> actual = productService.fineCategoryForRead("Fruits");

        assertEquals(expected, actual);
    }

    @Test
    void deleteProduct() {

        doNothing().when(productRepository).deleteById((isA(Integer.class)));
        productService.deleteProduct(0);

        verify(productRepository).deleteById(0);
    }

    @Test
    void saveProduct() {

    }

    @Test
    void update() {
        Mockito.when(utilService.calculating(10.0, 50.0))
                .thenReturn(5.0);

        doNothing().when(productRepository).update(isA(String.class), isA(String.class),
                isA(Double.class), isA(Double.class), isA(Double.class), isA(Double.class), isA(Integer.class));

        productService.update(0, "Fruits", "Apple", 10.0, 50.0, 30.0);

        verify(productRepository).update("Fruits", "Apple", 10.0, 50.0, 5.0, 30.0, 0);

    }

    @Test
    void updateDiscountForCategory() {
//        var data = new Date();
//        Mockito.when(productRepository.findByCategory(Mockito.any(String.class)))
//                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 50.0, 5.0, 10.0, data),
//                        new Product(2, "Fruits", "Apple", 10.0, 50.0, 5.0, 10.0, data)));
//
//        Mockito.when(utilService.calculating(10.0, 50.0))
//                .thenReturn(5.0);
//
//        doNothing().when(productRepository).update(isA(String.class), isA(String.class),
//                isA(Double.class), isA(Double.class), isA(Double.class), isA(Double.class), isA(Integer.class));
//
//        productService.update(0, "Fruits", "Apple", 10.0, 50.0, 30.0);
//
//        List<Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 50.0, 5.0, 10.0, data),
//                new Product(2, "Fruits", "Apple", 10.0, 50.0, 5.0, 10.0, data));
//
//        List <Product> actual = productService.updateDiscountForCategory("Fruits", 50.0);
    }
}