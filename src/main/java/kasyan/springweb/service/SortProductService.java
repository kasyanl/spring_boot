package kasyan.springweb.service;

import kasyan.springweb.bean.Product;
import kasyan.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortProductService {

    private ProductRepository productRepository;

    public List<Product> sortById() {
        return productRepository.sortById();
    }

    public List<Product> sortByIdReverse() {
        return productRepository.sortByIdReverse();
    }

    public List<Product> sortByCategory() {
        return productRepository.sortByCategory();
    }

    public List<Product> sortByCategoryReverse() {
        return productRepository.sortByCategoryReverse();
    }

    public List<Product> sortByName() {
        return productRepository.sortByName();
    }

    public List<Product> sortByNameReverse() {
        return productRepository.sortByNameReverse();
    }

    public List<Product> sortByPrice() {
        return productRepository.sortByPrice();
    }

    public List<Product> sortByPriceReverse() {
        return productRepository.sortByPriceReverse();
    }

    public List<Product> sortByDiscount() {
        return productRepository.sortByDiscount();
    }

    public List<Product> sortByDiscountReverse() {
        return productRepository.sortByDiscountReverse();
    }

    public List<Product> sortByActualPrice() {
        return productRepository.sortByActualPrice();
    }

    public List<Product> sortByActualPriceReverse() {
        return productRepository.sortByActualPriceReverse();
    }

    public List<Product> sortByTotalVolume() {
        return productRepository.sortByTotalVolume();
    }

    public List<Product> sortByTotalVolumeReverse() {
        return productRepository.sortByTotalVolumeReverse();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
