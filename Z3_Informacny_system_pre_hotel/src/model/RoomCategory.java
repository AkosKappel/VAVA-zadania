package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author kappe
 */
public class RoomCategory implements Serializable {

    private double price;
    private String description;

    public RoomCategory(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return description + ", " + new DecimalFormat("########0.00").format(price) + " €";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
