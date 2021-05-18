package kasyan.springweb.service;

import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.ProductOfDeleteRepository;
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
class ProductOfDeleteServiceTest {

    @MockBean
    private ProductOfDeleteRepository productOfDeleteRepository;

    ProductOfDeleteService productOfDeleteService;

    @BeforeEach
    void setUp() {
        productOfDeleteService = new ProductOfDeleteService();
        productOfDeleteService.setProductOfDeleteRepository(productOfDeleteRepository);
    }
    @Test
    void findAllDeleted() {
        var data = new Date();
        Mockito.when(productOfDeleteRepository.findAll())
                .thenReturn(List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));

        List<ProductOfDelete> expected = List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data));

        List<ProductOfDelete> actual = productOfDeleteService.findAllDeleted();

        assertEquals(expected, actual);
    }

    @Test
    void findProductOfBasketByID() {
        var data = new Date();
        Mockito.when(productOfDeleteRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));

        Optional <ProductOfDelete> expected = Optional.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0,  data));

        Optional <ProductOfDelete> actual = productOfDeleteService.findProductOfBasketByID(1);

        assertEquals(expected, actual);
    }

    @Test
    void deleteOfBasket() {
        doNothing().when(productOfDeleteRepository).deleteById(1);
        productOfDeleteRepository.deleteById(1);

        verify(productOfDeleteRepository, times(1)).deleteById(1);
    }

    @Test
    void cleanBasket() {
        doNothing().when(productOfDeleteRepository).deleteAll();
        productOfDeleteRepository.deleteAll();

        verify(productOfDeleteRepository, times(1)).deleteAll();
    }
}