package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private String item_id;
    private String name;
    private String qty;
    private double price;
    private String description;
    private Date date;
}
