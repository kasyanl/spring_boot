package kasyan.springweb.service;

import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.ProductOfDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOfDeleteService {

    private ProductOfDeleteRepository productOfDeleteRepository;
    private ProductService productService;

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    @Transactional
    public List<ProductOfDelete> findAllDeleted() {
        return productOfDeleteRepository.findAll();
    }

    @Transactional
    public Optional<ProductOfDelete> findProductOfBasketByID(int id) {
        return productOfDeleteRepository.findById(id);
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    @Transactional
    public void deleteOfBasket(int id) {
        productOfDeleteRepository.deleteById(id);
    }

    //очистка всех данных из корзины
    @Transactional
    public void cleanBasket() {
        productOfDeleteRepository.deleteAll();
    }

    @Transactional
    public void saveProductOfDelete(int id) {

        var productOfDelete = new ProductOfDelete();
        var product = productService.findById(id);

            productOfDelete.setId(product.getId());
            productOfDelete.setCategory(product.getCategory());
            productOfDelete.setName(product.getName());
            productOfDelete.setPrice(product.getPrice());
            productOfDelete.setDiscount(product.getDiscount());
            productOfDelete.setActualPrice(product.getActualPrice());
            productOfDelete.setTotalVolume(product.getTotalVolume());
            productOfDeleteRepository.save(productOfDelete);
        }

    @Autowired
    public void setProductOfDeleteRepository(ProductOfDeleteRepository productOfDeleteRepository) {
        this.productOfDeleteRepository = productOfDeleteRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}