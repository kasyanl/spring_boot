package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.BuyProductRepository;
import kasyan.springweb.repository.ProductOfDeleteRepository;
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

@SpringBootTest
class GetProductServiceTest {

    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private ProductOfDeleteRepository productOfDeleteRepository;
    @MockBean
    private BuyProductRepository buyProductRepository;

    GetProductService getProductService;

    @BeforeEach
    void setUp() {
        getProductService = new GetProductService();
        getProductService.setProductRepository(productRepository);
        getProductService.setProductOfDeleteRepository(productOfDeleteRepository);
        getProductService.setBuyProductRepository(buyProductRepository);
    }

    @Test
    void findAll() {
        var data = new Date();
        Mockito.when(productRepository.findAll())
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));

        List<Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data));

        List<Product> actual = getProductService.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void findAllDeleted() {
        var data = new Date();
        Mockito.when(productOfDeleteRepository.findAll())
                .thenReturn(List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));

        List<ProductOfDelete> expected = List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data));

        List<ProductOfDelete> actual = getProductService.findAllDeleted();

        assertEquals(expected, actual);
    }

    @Test
    void findAllBuyProduct() {
        Mockito.when(buyProductRepository.findAll())
                .thenReturn(List.of(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0),
                        new BuyProduct(2, "Apple", 20.0, 20.0, 400.0)));

        List<BuyProduct> expected = List.of(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0),
                new BuyProduct(2, "Apple", 20.0, 20.0, 400.0));

        List<BuyProduct> actual = getProductService.findAllBuyProduct();

        assertEquals(expected, actual);
    }

    @Test
    void findById() {
        var data = new Date();
        Mockito.when(productRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));

        Optional <Product> expected = Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0,  data));

        Optional <Product> actual = getProductService.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    void findProductOfBasketByID() {
        var data = new Date();
        Mockito.when(productOfDeleteRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));

        Optional <ProductOfDelete> expected = Optional.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0,  data));

        Optional <ProductOfDelete> actual = getProductService.findProductOfBasketByID(1);

        assertEquals(expected, actual);
    }

    @Test
    void fineCategoryForRead() {
        var data = new Date();
        Mockito.when(productRepository.findByCategory(Mockito.any(String.class)))
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));

        List <Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data));

        List <Product> actual = getProductService.fineCategoryForRead("Fruits");

        assertEquals(expected, actual);
    }

    @Test
    void checkingForNumberIsTrue() {
        assertTrue(getProductService.checkingForNumber(10.0, 30.0));
    }
    @Test
    void checkingForNumberIsFalse() {
        assertFalse(getProductService.checkingForNumber(40.0, 30.0));
    }

    @Test
    void basketIsEmptyTrue() {
        var data = new Date();
        Mockito.when(productOfDeleteRepository.findAll())
                .thenReturn(List.of(new ProductOfDelete(1, "Fruits", "Banana", 10.0, 20.0, 8.0,10.0, data),
                        new ProductOfDelete(2, "Fruits", "Apple", 20.0, 20.0, 16.0,10.0, data)));
        assertFalse(getProductService.basketIsEmpty());
    }

    @Test
    void basketIsEmptyFalse() {
        Mockito.when(productOfDeleteRepository.findAll()).thenReturn(List.of());
        assertTrue(getProductService.basketIsEmpty());
    }
}