package kasyan.springweb.repository;

import kasyan.springweb.bean.BuyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyProductRepository extends JpaRepository<BuyProduct, Integer> {



    @Override
    void deleteById(Integer id);

    @Override
    void deleteAll();

    @Override
    <S extends BuyProduct> S save(S s);
}