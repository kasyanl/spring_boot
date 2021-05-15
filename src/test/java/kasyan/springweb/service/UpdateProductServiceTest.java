package kasyan.springweb.service;

import kasyan.springweb.bean.Product;
import kasyan.springweb.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpdateProductServiceTest {

    @MockBean
    ProductRepository productRepository;

    UpdateProductService updateProductService;
    @BeforeEach
    void setUp() {
        updateProductService = new UpdateProductService();
        updateProductService.setProductRepository(productRepository);
    }

    @Test
    void update() {
//        Mockito.when(productRepository.update("Fruits", "Apple", 10.0, 50.0, 5.0, 15.0, 1))
//                .thenReturn(new Product(1, "Fruits", "Apple", 10.0, 50.0, 5.0, 15.0, new Date()));
//
//       Product expected = new Product(1, "Fruits", "Apple", 10.0, 50.0, 5.0, 15.0, new Date());
//
//        Product actual = updateProductService.update(1,"Fruits", "Apple", 10.0, 50.0, 15.0);
//
//        assertEquals(expected, actual);
    }


    @Test
    void updateDiscountForCategory() {
    }

    @Test
    void endTransaction() {
    }

    @Test
    void setGetProductService() {
    }

    @Test
    void setProductRepository() {
    }
}