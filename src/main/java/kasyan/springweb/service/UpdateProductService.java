package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdateProductService {

    private GetProductService getProductService;
    private ProductRepository productRepository;

    // отправляем запрос в БД на обновление Product по ID
    @Transactional
    public void update(int id, String category, String name, double price, double discount, double totalVolume) {
        double actualPrice = SaveProductService.calculating(price, discount);
       productRepository.update(category, name, price, discount, actualPrice, totalVolume, id);
    }

    // установка скидки для одной категории
    @Transactional
    public void updateDiscountForCategory(String category, double discount) {

        List<Product> listCategory = getProductService.fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount, product.getTotalVolume());
        }
    }

    // сохранение данных после изменения
    @Transactional
    public void endTransaction() {
        for (BuyProduct buyProduct : getProductService.findAllBuyProduct()) {
            var products = getProductService.findById(buyProduct.getId());
            if (products.isPresent()) {
                var product = products.get();
                double totalVolume = product.getTotalVolume() - buyProduct.getQuantity();
                update(product.getId(), product.getCategory(), product.getName(),
                        product.getPrice(), product.getDiscount(), totalVolume);
            }
        }
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}