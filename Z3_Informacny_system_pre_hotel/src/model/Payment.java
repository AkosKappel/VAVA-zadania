package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kappe
 */
public class Payment implements Serializable {

    private double totalPrice;
    private Accommodation accommodation;
    private boolean inCash;
    private Date date;

    public Payment(double totalPrice, Accommodation accommodation, boolean inCash, Date date) {
        this.totalPrice = totalPrice;
        this.accommodation = accommodation;
        this.inCash = inCash;
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public boolean isInCash() {
        return inCash;
    }

    public void setInCash(boolean inCash) {
        this.inCash = inCash;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
