package kasyan.springweb.repository;

import kasyan.springweb.bean.ProductOfDelete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOfDeleteRepository extends CrudRepository<ProductOfDelete, Integer> {
    List<ProductOfDelete> findAll();
    ProductOfDelete findById(int id);

    @Override
    <S extends ProductOfDelete> S save(S s);

    @Override
    void deleteById(Integer id);

    @Override
    void deleteAll();
}
