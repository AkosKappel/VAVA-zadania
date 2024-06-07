package model;

import controller.Tool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author kappe
 */
public class Room implements Serializable {

    private String id;
    private String note;
    private RoomCategory category;
    private ArrayList<ImageIcon> pictures;

    public Room(String id, String note, RoomCategory category, ArrayList<ImageIcon> pictures) {
        this.id = id;
        this.note = note;
        this.category = category;
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return id + ", " + note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public double calculatePrice(Date fromDate, Date untilDate) {
        double categoryPrice = category.getPrice();

        int days = Tool.getDaysDifferenceCount(untilDate, fromDate);
        double price = days * categoryPrice;

        if (days >= 7) {  // Akcia 30% za rezervaciu dlhsiu ako 1 cely tyzden
            price -= days * 0.3 * categoryPrice;
        }

        return price;
    }

    public static boolean isUniqueID(ArrayList<Room> rooms, String newRoomID) {
        return rooms.stream().noneMatch(r -> (r.getId().equals(newRoomID)));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public RoomCategory getCategory() {
        return category;
    }

    public void setCategory(RoomCategory category) {
        this.category = category;
    }

    public ArrayList<ImageIcon> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<ImageIcon> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(ImageIcon imgIcon) {
        this.pictures.add(imgIcon);
    }

}
