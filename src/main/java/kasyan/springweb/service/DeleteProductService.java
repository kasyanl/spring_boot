package kasyan.springweb.service;

import kasyan.springweb.repository.BuyProductRepository;
import kasyan.springweb.repository.ProductOfDeleteRepository;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {

    private SaveProductService saveProductService;
    private ProductRepository productRepository;
    private BuyProductRepository buyProductRepository;
    private ProductOfDeleteRepository productOfDeleteRepository;

    //находим Product по его ID и отправка запроса в БД для удаления и одновременно добавления в "корзину" (и добавляем дату удаления)
    public void deleteProduct(int id)  {

        saveProductService.saveProductOfDelete(id);
        productRepository.deleteById(id);
    }

    //находим Product по его ID с писке покупок и отправляем запрос на его даление
    public void deleteBuy(int id) {
        buyProductRepository.deleteById(id);
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void deleteOfBasket(int id) {
        productOfDeleteRepository.deleteById(id);
    }

    //очистка всех данных из корзины
    public void cleanBasket() {
        productOfDeleteRepository.deleteAll();
    }

    // очистка БД с покупками
    public void cleanBuyDB() {
        buyProductRepository.deleteAll();
    }

    @Autowired
    public void setSaveProductService(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setBuyProductRepository(BuyProductRepository buyProductRepository) {
        this.buyProductRepository = buyProductRepository;
    }

    @Autowired
    public void setProductOfDeleteRepository(ProductOfDeleteRepository productOfDeleteRepository) {
        this.productOfDeleteRepository = productOfDeleteRepository;
    }
}