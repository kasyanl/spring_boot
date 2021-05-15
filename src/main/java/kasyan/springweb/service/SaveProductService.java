package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import kasyan.springweb.repository.BuyProductRepository;
import kasyan.springweb.repository.ProductOfDeleteRepository;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaveProductService {

    private GetProductService getProductService;
    private SortProductService sortProductService;
    private ProductOfDeleteRepository productOfDeleteRepository;
    private ProductRepository productRepository;
    private BuyProductRepository buyProductRepository;

    /* отправка запроса на добавление новой записи в БД Product
   и автоматическим расчетом цены с учетом скидки */
    @Transactional
    public void saveProduct(String category, String name, double price, double discount, double totalVolume) {
        List<Product> newList = getProductService.findAll();
        int id = createId(newList);
        double actualPrice = calculating(price, discount);

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

    @Transactional
    public void saveProductOfDelete(int id)  {

        var productOfDelete = new ProductOfDelete();
        var product = getProductService.findById(id);

        productOfDelete.setId(product.getId());
        productOfDelete.setCategory(product.getCategory());
        productOfDelete.setName(product.getName());
        productOfDelete.setPrice(product.getPrice());
        productOfDelete.setDiscount(product.getDiscount());
        productOfDelete.setActualPrice(product.getActualPrice());
        productOfDelete.setTotalVolume(product.getTotalVolume());
        productOfDeleteRepository.save(productOfDelete);
    }

    // выбор продукта для покупки (передаем количество или вес продукта), добавляем в отдельную БД
    @Transactional
    public void saveBayProduct(int id, double quantity) {
        var product = getProductService.findById(id);
        var buyProduct = new BuyProduct();
        double totalPrice = product.getActualPrice() * quantity;

        buyProduct.setId(product.getId());
        buyProduct.setName(product.getName());
        buyProduct.setActualPrice(product.getActualPrice());
        buyProduct.setQuantity(quantity);
        buyProduct.setTotalPrice(totalPrice);

        buyProductRepository.save(buyProduct);
    }

    // метод для расчета стоимости с учетом скидки
    public static double calculating(double price, double discount) {
        return (price - (price * discount / 100));
    }

    // формирование ID с одновременной проверкой (если есть пропуск (например 2, 3, ,5 то будет присвоен id=4))
    public int createId(List<Product> newList) {
        var id = 0; // по умолчанию id = 0
        if (!newList.isEmpty()) { // если записи имеются, проверяем на пропущенные id
            sortProductService.sortById(); //сортируем для корректной проверки
            int i = id;
            for (Product product : newList) { // проверяем
                if (product.getId() == i) i++; // теперь i больше текущего id на 1
                id = i; // присваиваем значение id (здесь id на 1 больше последнего проверенного)
            }
        }
        return id;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setSortProductService(SortProductService sortProductService) {
        this.sortProductService = sortProductService;
    }

    @Autowired
    public void setProductOfDeleteRepository(ProductOfDeleteRepository productOfDeleteRepository) {
        this.productOfDeleteRepository = productOfDeleteRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setBuyProductRepository(BuyProductRepository buyProductRepository) {
        this.buyProductRepository = buyProductRepository;
    }
}