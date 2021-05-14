package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.BuyProductRepository;
import kasyan.springweb.repository.ProductOfDeleteRepository;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {

    private ProductRepository productRepository;
    private ProductOfDeleteRepository productOfDeleteRepository;
    private BuyProductRepository buyProductRepository;

    //отправка запроса на получение всех продуктов из основной БД
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<ProductOfDelete> findAllDeleted() {
        return productOfDeleteRepository.findAll();
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<BuyProduct> findAllBuyProduct() {
        return buyProductRepository.findAll();
    }

    //находим конкретный Product по ID
    public Product findById(int id) {
       return productRepository.findById(id);
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    public List<Product> fineCategoryForRead(String category) {
        return productRepository.findByCategory(category);
    }

    // расчет общей суммы покупок
    public double totalPrise() {
        List<BuyProduct> newList = findAllBuyProduct();
        double count = 0;
        for (BuyProduct product : newList) {
            count += product.getTotalPrice();
        }
        return count;
    }

    // проверка, чтобы не ввести больше количество,
    public boolean checkingForNumber(double quantity, double totalVolume) {
        return quantity <= totalVolume;
    }

    // проверка, пуста ли корзина
    public boolean basketIsEmpty() {
        List<ProductOfDelete> newList = findAllDeleted();
        return newList.isEmpty();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductOfDeleteRepository(ProductOfDeleteRepository productOfDeleteRepository) {
        this.productOfDeleteRepository = productOfDeleteRepository;
    }

    @Autowired
    public void setBuyProductRepository(BuyProductRepository buyProductRepository) {
        this.buyProductRepository = buyProductRepository;
    }
}