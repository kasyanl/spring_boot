package kasyan.springweb.service;

import kasyan.springweb.bean.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GetProductServiceTest {

    @Test
    void findAllBuyProduct() {
        GetProductService getProductService = new GetProductService();

        List<Product> productList = getProductService.findAll();
        for(Product product : productList){
            System.out.println(product.toString());
        }
    }

    @Test
    void totalPrise() {
        GetProductService getProductService = new GetProductService();
        Double t = getProductService.totalPrise();
        System.out.println(t);
    }
}