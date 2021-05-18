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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SortProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    SortProductService sortProductService;

    @BeforeEach
    void setUp() {
        sortProductService = new SortProductService();
        sortProductService.setProductRepository(productRepository);
    }

    @Test
    void sortById() {
        Date data = new Date();
        Mockito.when(productRepository.sortById())
                .thenReturn(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)));

        List<Product> expected = List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data));

        List<Product> actual = sortProductService.sortById();

        assertEquals(expected, actual);
    }

    @Test
    void sortByIdReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByIdReverse())
                .thenReturn(List.of(new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)));

        List<Product> expected = List.of(new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data));

        List<Product> actual = sortProductService.sortByIdReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByCategory() {
        Date data = new Date();
        Mockito.when(productRepository.sortByCategory())
                .thenReturn(List.of(
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)


                ));

        List<Product> expected = List.of(
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByCategory();

        assertEquals(expected, actual);
    }

    @Test
    void sortByCategoryReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByCategoryReverse())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByCategoryReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByName() {
        Date data = new Date();
        Mockito.when(productRepository.sortByName())
                .thenReturn(List.of(
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
                ));

        List<Product> expected = List.of(
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByName();

        assertEquals(expected, actual);
    }

    @Test
    void sortByNameReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByNameReverse())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByNameReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByPrice() {
        Date data = new Date();
        Mockito.when(productRepository.sortByPrice())
                .thenReturn(List.of(
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
                ));

        List<Product> expected = List.of(
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void sortByPriceReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByPriceReverse())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByPriceReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByDiscount() {
        Date data = new Date();
        Mockito.when(productRepository.sortByDiscount())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByDiscount();

        assertEquals(expected, actual);
    }

    @Test
    void sortByDiscountReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByDiscountReverse())
                .thenReturn(List.of(
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
                ));

        List<Product> expected = List.of(
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByDiscountReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByActualPrice() {
        Date data = new Date();
        Mockito.when(productRepository.sortByActualPrice())
                .thenReturn(List.of(
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
                ));

        List<Product> expected = List.of(
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByActualPrice();

        assertEquals(expected, actual);
    }

    @Test
    void sortByActualPriceReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByActualPriceReverse())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByActualPriceReverse();

        assertEquals(expected, actual);
    }

    @Test
    void sortByTotalVolume() {
        Date data = new Date();
        Mockito.when(productRepository.sortByTotalVolume())
                .thenReturn(List.of(
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
                ));

        List<Product> expected = List.of(
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data)
        );

        List<Product> actual = sortProductService.sortByTotalVolume();

        assertEquals(expected, actual);
    }

    @Test
    void sortByTotalVolumeReverse() {
        Date data = new Date();
        Mockito.when(productRepository.sortByTotalVolumeReverse())
                .thenReturn(List.of(
                        new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                        new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                        new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
                ));

        List<Product> expected = List.of(
                new Product(3, "Meat", "Pork", 30.0, 15.0, 25.5, 40.0, data),
                new Product(2, "Berries", "Apple", 20.0, 20.0, 16.0, 10.0, data),
                new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data)
        );

        List<Product> actual = sortProductService.sortByTotalVolumeReverse();

        assertEquals(expected, actual);
    }
}