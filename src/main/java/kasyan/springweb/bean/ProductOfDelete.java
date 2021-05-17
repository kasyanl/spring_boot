package kasyan.springweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productofdelete")
public class ProductOfDelete {
    @Id
    private Integer id;
    @Column(name = "category")
    private String category;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "discount")
    private double discount;
    @Column(name = "actual_price")
    private double actualPrice;
    @Column(name = "total_volume")
    private double totalVolume;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date data;
}