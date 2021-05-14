package kasyan.springweb.repository;

import kasyan.springweb.bean.ProductOfDelete;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductOfDeleteRepository extends CrudRepository<ProductOfDelete, Integer> {
    List<ProductOfDelete> findAll();

    @Override
    <S extends ProductOfDelete> S save(S s);

    @Override
    void deleteById(Integer id);

    @Override
    void deleteAll();
}
