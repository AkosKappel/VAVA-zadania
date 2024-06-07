package controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kappe
 */
public final class DataSerializer {

    public static final String MAIN_DIRECTORY_NAME = "data\\";
    public static final String ROOMS_FILE = "Rooms.dat";
    public static final String ROOM_CATEGORIES_FILE = "RoomCategories.dat";
    public static final String SERVICES_FILE = "Services.dat";
    public static final String CLIENTS_FILE = "Clients.dat";
    public static final String RESERVATIONS_FILE = "Reservations.dat";
    public static final String ACCOMMODATIONS_FILE = "Accommodations.dat";
    public static final String PAYMENTS_FILE = "Payments.dat";
    private static final Logger LOG = Logger.getLogger(DataSerializer.class.getName());

    private DataSerializer() {
    }

    public static <T> ArrayList<T> loadFromFile(String filename) {
        ArrayList<T> lst = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(MAIN_DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        lst.add((T) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Súbor " + MAIN_DIRECTORY_NAME + "{0} sa nepodarilo nájsť!\n", filename);
        }

        LOG.log(Level.INFO, "Boli načítané údaje zo súboru " + MAIN_DIRECTORY_NAME + "{0}.\n", filename);
        return lst;
    }

    public static <T> void saveToFile(ArrayList<T> lst, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(MAIN_DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < lst.size(); i++) {
                    outputFile.writeObject(lst.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        LOG.log(Level.INFO, "Údaje boli uložené do súboru " + MAIN_DIRECTORY_NAME + "{0}\n", filename);
    }

}
