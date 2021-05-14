package kasyan.springweb.repository;

import kasyan.springweb.bean.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    Product findById(int id);
    List<Product> findByCategory(String category);

    @Modifying
    @Query("UPDATE Product SET category= ?1, name= ?2, price=?3," +
            " discount=?4, actualPrice=?5, totalVolume=?6 WHERE id=?7")
    void update(String category, String name, double price,
                double discount, double actualPrice, double totalVolume, Integer id);


    @Override
    void deleteById(Integer id);

    @Override
    <S extends Product> S save(S s);

    @Query("FROM Product P ORDER BY P.id")
    List<Product> sortById();

    @Query("FROM Product P ORDER BY P.id DESC")
   List<Product> sortByIdReverse();

    @Query("FROM Product P ORDER BY P.category")
    List<Product> sortByCategory();

    @Query("FROM Product P ORDER BY P.category DESC")
    List<Product> sortByCategoryReverse();

    @Query("FROM Product P ORDER BY P.name")
    List<Product> sortByName();

    @Query("FROM Product P ORDER BY P.name DESC")
    List<Product> sortByNameReverse();

    @Query("FROM Product P ORDER BY P.price")
    List<Product> sortByPrice();

    @Query("FROM Product P ORDER BY P.price DESC")
     List<Product> sortByPriceReverse();

    @Query("FROM Product P ORDER BY P.discount")
     List<Product> sortByDiscount();

    @Query("FROM Product P ORDER BY P.discount DESC")
     List<Product> sortByDiscountReverse();

    @Query("FROM Product P ORDER BY P.actualPrice")
     List<Product> sortByActualPrice();

    @Query("FROM Product P ORDER BY P.actualPrice DESC")
     List<Product> sortByActualPriceReverse();

    @Query("FROM Product P ORDER BY P.totalVolume")
     List<Product> sortByTotalVolume();

    @Query("FROM Product P ORDER BY P.totalVolume DESC")
     List<Product> sortByTotalVolumeReverse();
}
