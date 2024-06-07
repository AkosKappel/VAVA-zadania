package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author kappe
 */
public class Service implements Serializable {

    private double price;
    private String description;
    private Date dateOfUse;

    public Service(double price, String description) {
        this.price = price;
        this.description = description;
        this.dateOfUse = null;
    }

    public Service(double price, String description, Date dateOfUse) {
        this.price = price;
        this.description = description;
        this.dateOfUse = dateOfUse;
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

    public Date getDateOfUse() {
        return dateOfUse;
    }

    public void setDateOfUse(Date dateOfUse) {
        this.dateOfUse = dateOfUse;
    }

}
