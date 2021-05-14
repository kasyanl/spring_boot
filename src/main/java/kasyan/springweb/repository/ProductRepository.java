package kasyan.springweb.repository;

import kasyan.springweb.bean.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    Product findById(int id);
    List<Product> findByCategory(String category);

    @Override
    void deleteById(Integer id);
}
