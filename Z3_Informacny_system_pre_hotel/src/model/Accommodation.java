package model;

import controller.Tool;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kappe
 */
public class Accommodation implements Serializable {

    private Client client;
    private Room room;
    private double price;
    private Date from;
    private Date until;
    private boolean paid;
    private ArrayList<Service> usedServices;

    public Accommodation(Client client, Room room, double price, Date from, Date until) {
        this.client = client;
        this.room = room;
        this.price = price;
        this.from = from;
        this.until = until;
        this.paid = false;  // Ubytovanie este nie je zaplatene
        this.usedServices = new ArrayList<>();  // Na zaciatku nie su zaevidovane ziadne vyuzite sluzby
    }

    @Override
    public String toString() {
        return client.getName() + ", " + room.getId();
    }

    public String getDetails() {
        DecimalFormat formatter = new DecimalFormat("########0.00");

        String msg = "Meno zákazníka: " + client.getName()
                + "\nE-mail: " + client.getEmail()
                + "\nTelefónne číslo: " + client.getPhoneNumber()
                + "\n\nIzba: " + room.getId()
                + "\nOd: " + Tool.dateToString(from)
                + "\nDo: " + Tool.dateToString(until)
                + "\nPocet nocí: " + Tool.getDaysDifferenceCount(until, from)
                + "\nCena za 1 noc: " + formatter.format(room.getCategory().getPrice()) + " €"
                + "\n\nVyužité služby: ";

        for (int i = 0; i < usedServices.size(); i++) {
            Service service = usedServices.get(i);
            msg += "\n" + service.getDescription() + "\t" + formatter.format(service.getPrice()) + " €";
        }

        msg += "\n\nCena celkom: " + formatter.format(getTotalPrice()) + " €"
                + "\nStav ubytovania: ";
        msg += paid ? "zaplatené" : "nezaplatené";
        return msg;
    }

    public void addService(Service service) {
        this.usedServices.add(service);
    }

    public double getTotalPrice() {
        return price + getServicesPrice();
    }

    public double getServicesPrice() {
        double servicePrice = 0;
        for (Service usedService : usedServices) {
            servicePrice += usedService.getPrice();
        }
        return servicePrice;
    }

    public String getFromUntilDate() {
        return Tool.dateToString(from) + " - " + Tool.dateToString(until);
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public ArrayList<Service> getUsedServices() {
        return usedServices;
    }

    public void setUsedServices(ArrayList<Service> usedServices) {
        this.usedServices = usedServices;
    }

}
