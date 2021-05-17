package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.BuyProductRepository;
import kasyan.springweb.repository.ProductOfDeleteRepository;
import kasyan.springweb.repository.ProductRepository;
import kasyan.springweb.util.HibernateSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GetProductService {

    private ProductRepository productRepository;
    private ProductOfDeleteRepository productOfDeleteRepository;
    private BuyProductRepository buyProductRepository;

    //отправка запроса на получение всех продуктов из основной БД
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    @Transactional
    public List<ProductOfDelete> findAllDeleted() {
        return productOfDeleteRepository.findAll();
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    @Transactional
    public List<BuyProduct> findAllBuyProduct() {
        return buyProductRepository.findAll();
    }

    //находим конкретный Product по ID
    @Transactional
    public Optional <Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Optional <ProductOfDelete> findProductOfBasketByID(int id) {
        return productOfDeleteRepository.findById(id);
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    @Transactional
    public List<Product> fineCategoryForRead(String category) {
        return productRepository.findByCategory(category);
    }


    // расчет общей суммы покупок
    public double totalPrise() {
        var session = HibernateSessionFactory.getSessionFactory().openSession();
        List<BuyProduct> products = session.createQuery("FROM BuyProduct").getResultList();
        session.close();
        double count = 0;
        if (!products.isEmpty()) {
            for (BuyProduct product : products) {
                count += product.getTotalPrice();
            }
        }
        return count;
    }

    // проверка, чтобы не ввести больше количество,
    public boolean checkingForNumber(double quantity, double totalVolume) {
        return quantity <= totalVolume;
    }

    // проверка, пуста ли корзина
    @Transactional
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