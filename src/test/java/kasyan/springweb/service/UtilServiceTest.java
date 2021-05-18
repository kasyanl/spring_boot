package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilServiceTest {
    @MockBean
    private BuyProductService buyProductService;
    @MockBean
    private ProductOfDeleteService productOfDeleteService;
    @MockBean
    private ProductService productService;

    UtilService utilService;
    @BeforeEach
    void setUp() {
        utilService = new UtilService();
        utilService.setBuyProductService(buyProductService);
        utilService.setProductOfDeleteService(productOfDeleteService);
        utilService.setProductService(productService);
    }

    @Test
    void totalPriseNotZero() {
        Mockito.when(buyProductService.findAllBuyProduct())
                .thenReturn(List.of(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0),
                        new BuyProduct(2, "Apple", 20.0, 20.0, 400.0)));
      assertEquals(600.0, utilService.totalPrise());
    }

    @Test
    void totalPriseZero() {
        Mockito.when(buyProductService.findAllBuyProduct())
                .thenReturn(List.of());
        assertEquals(0.0, utilService.totalPrise());
    }

    @Test
    void checkingForNumberTrue() {
        assertTrue(utilService.checkingForNumber(120, 200));
    }

    @Test
    void checkingForNumberFalse() {
        assertFalse(utilService.checkingForNumber(320, 200));
    }

    @Test
    void basketIsEmptyTrue() {
        Mockito.when(productOfDeleteService.findAllDeleted())
                .thenReturn(List.of());
        assertTrue(utilService.basketIsEmpty());
    }

    @Test
    void basketIsEmptyFalse() {
        var data = new Date();
        Mockito.when(productOfDeleteService.findAllDeleted())
                .thenReturn(List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));
        assertFalse(utilService.basketIsEmpty());
    }

    @Test
    void calculating() {
        assertEquals(50.0, utilService.calculating(100.0, 50.0));
    }

    @Test
    void createIdIsZero() {
        var data = new Date();
        Mockito.when(productService.findAll())
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));
        assertEquals(0, utilService.createId());
    }

    @Test
    void createIdIsFirst() {
        var data = new Date();
        Mockito.when(productService.findAll())
                .thenReturn(List.of(new Product(0, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));
        assertEquals(1, utilService.createId());
    }

    @Test
    void createIdIsSecond() {
        var data = new Date();
        Mockito.when(productService.findAll())
                .thenReturn(List.of(new Product(0, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new Product(1, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));
        assertEquals(2, utilService.createId());
    }
    @Test
    void createIdIsEmpty() {
        Mockito.when(productService.findAll())
                .thenReturn(List.of());
        assertEquals(0, utilService.createId());
    }

    @Test
    void endTransaction() {
    }

    @Test
    void recoveryAllProduct() {
    }

    @Test
    void recovered() {
    }
}