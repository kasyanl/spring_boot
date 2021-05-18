package kasyan.springweb.service;

import kasyan.springweb.bean.Product;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private UtilService utilService;

    //отправка запроса на получение всех продуктов из основной БД
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //находим конкретный Product по ID
    @Transactional
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    @Transactional
    public List<Product> fineCategoryForRead(String category) {
        return productRepository.findByCategory(category);
    }

    //находим Product по его ID и отправка запроса в БД для удаления
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
    /* отправка запроса на добавление новой записи в БД Product
 и автоматическим расчетом цены с учетом скидки */
    @Transactional
    public void saveProduct(String category, String name, double price, double discount, double totalVolume) {
        int id = utilService.createId();
        double actualPrice = utilService.calculating(price, discount);
        var product = new Product();
        product.setId(id);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setActualPrice(actualPrice);
        product.setTotalVolume(totalVolume);

        productRepository.save(product);
    }

    // отправляем запрос в БД на обновление Product по ID
    @Transactional
    public void update(int id, String category, String name, double price, double discount, double totalVolume) {
        double actualPrice = utilService.calculating(price, discount);
        productRepository.update(category, name, price, discount, actualPrice, totalVolume, id);
    }

    // установка скидки для одной категории
    @Transactional
    public void updateDiscountForCategory(String category, double discount) {

        List<Product> listCategory = fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount, product.getTotalVolume());
        }
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }
}
