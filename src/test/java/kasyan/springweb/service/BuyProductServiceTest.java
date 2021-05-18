package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.repository.BuyProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BuyProductServiceTest {

    @MockBean
    private ProductService productService;
    @MockBean
    private BuyProductRepository buyProductRepository;

   BuyProductService buyProductService;

    @BeforeEach
    void setUp() {
        buyProductService = new BuyProductService();
        buyProductService.setBuyProductRepository(buyProductRepository);
        buyProductService.setProductService(productService);
    }

    @Test
    void findAllBuyProduct() {
        Mockito.when(buyProductRepository.findAll())
                .thenReturn(List.of(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0),
                        new BuyProduct(2, "Apple", 20.0, 20.0, 400.0)));

        List<BuyProduct> expected = List.of(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0),
                new BuyProduct(2, "Apple", 20.0, 20.0, 400.0));

        List<BuyProduct> actual = buyProductService.findAllBuyProduct();

        assertEquals(expected, actual);
    }

    @Test
    void deleteBuy() {
        doNothing().when(buyProductRepository).deleteById(isA(Integer.class));
        buyProductRepository.deleteById(0);

        verify(buyProductRepository, times(1)).deleteById(0);
    }

    @Test
    void cleanBuyDB() {
        doNothing().when(buyProductRepository).deleteAll();
        buyProductRepository.deleteAll();

        verify(buyProductRepository, times(1)).deleteAll();
    }

    @Test
    void saveBayProduct() {
//
//        var data = new Date();
//        Mockito.when(productService.findById(Mockito.any(Integer.class)))
//                .thenReturn(Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));
//
//        Optional <Product> expected = Optional.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0,  data));
//
//        Optional <Product> actual = buyProductService.saveBayProduct(1, 10);
//
//        BuyProduct buyProduct =

//
//
//        doNothing().doThrow(new RuntimeException()).when(buyProductRepository).save(isA(BuyProduct.class));
//        doNothing().when(buyProductRepository).save(isA(BuyProduct.class));
//        buyProductRepository.save(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0));
//
//        verify(buyProductRepository, times(1)).save(new BuyProduct(1, "Banana", 10.0, 20.0, 200.0));
    }
}