package kasyan.springweb.repository;

import kasyan.springweb.bean.BuyProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuyProductRepository extends CrudRepository<BuyProduct, Integer> {
    List<BuyProduct> findAll();

    @Override
    void deleteById(Integer id);

    @Override
    void deleteAll();
}
