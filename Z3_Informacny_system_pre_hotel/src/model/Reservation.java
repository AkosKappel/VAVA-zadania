package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author kappe
 */
public class Reservation implements Serializable {

    private Client client;
    private Room room;
    private double price;
    private Date from;
    private Date until;

    public Reservation(Client client, Room room, double price, Date from, Date until) {
        this.client = client;
        this.room = room;
        this.price = price;
        this.from = from;
        this.until = until;
    }

    @Override
    public String toString() {
        return client.getName() + ", " + room.getId() + ", " + new DecimalFormat("########0.00").format(price) + " €, od: " + from + ", do: " + until;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

}
