package kasyan.springweb.repository;

import kasyan.springweb.bean.BuyProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyProductRepository extends CrudRepository<BuyProduct, Integer> {
    List<BuyProduct> findAll();

    @Override
    void deleteById(Integer id);

    @Override
    void deleteAll();

    @Override
    <S extends BuyProduct> S save(S s);
}
