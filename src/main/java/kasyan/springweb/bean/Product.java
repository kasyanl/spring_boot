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
public class Product {

    @Id
    private Integer id;
    private String category;
    private String name;
    private double price;
    private double discount;
    private double actualPrice;
    private double totalVolume;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date data;

}