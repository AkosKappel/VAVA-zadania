package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Accommodation;
import model.Client;
import model.Payment;
import model.Service;
import model.Reservation;
import model.Room;
import model.RoomCategory;
import view.MainFrame;

/**
 *
 * @author Akos Kappel
 */
public class MainLogic {

    public MainFrame GUI;
    private ArrayList<Room> rooms;
    private ArrayList<RoomCategory> roomCategories;
    private ArrayList<Service> services;
    private ArrayList<Client> clients;
    private ArrayList<Reservation> reservations;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<Payment> payments;

    public MainLogic(MainFrame GUI) {
        this.GUI = GUI;
        initModels();
    }

    private void initModels() {
        this.rooms = DataSerializer.loadFromFile(DataSerializer.ROOMS_FILE);
        this.roomCategories = DataSerializer.loadFromFile(DataSerializer.ROOM_CATEGORIES_FILE);
        this.services = DataSerializer.loadFromFile(DataSerializer.SERVICES_FILE);
        this.clients = DataSerializer.loadFromFile(DataSerializer.CLIENTS_FILE);
        this.reservations = DataSerializer.loadFromFile(DataSerializer.RESERVATIONS_FILE);
        this.accommodations = DataSerializer.loadFromFile(DataSerializer.ACCOMMODATIONS_FILE);
        this.payments = DataSerializer.loadFromFile(DataSerializer.PAYMENTS_FILE);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
        DataSerializer.saveToFile(rooms, DataSerializer.ROOMS_FILE);
    }

    public void addRoomCategory(RoomCategory roomCategory) {
        this.roomCategories.add(roomCategory);
        DataSerializer.saveToFile(roomCategories, DataSerializer.ROOM_CATEGORIES_FILE);
    }

    public void addService(Service service) {
        this.services.add(service);
        DataSerializer.saveToFile(services, DataSerializer.SERVICES_FILE);
    }

    public void addClient(Client client) {
        this.clients.add(client);
        DataSerializer.saveToFile(clients, DataSerializer.CLIENTS_FILE);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        DataSerializer.saveToFile(reservations, DataSerializer.RESERVATIONS_FILE);
    }

    public void removeReservation(int index) {
        this.reservations.remove(index);
        DataSerializer.saveToFile(reservations, DataSerializer.RESERVATIONS_FILE);
    }

    public void addAccommodation(Accommodation accommodation) {
        this.accommodations.add(accommodation);
        DataSerializer.saveToFile(accommodations, DataSerializer.ACCOMMODATIONS_FILE);
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
        DataSerializer.saveToFile(payments, DataSerializer.PAYMENTS_FILE);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<RoomCategory> getRoomCategories() {
        return roomCategories;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public ArrayList<Accommodation> getUnpaidAccommodations() {
        ArrayList<Accommodation> unpaidAccommodations = new ArrayList<>();
        for (int i = 0; i < accommodations.size(); i++) {
            Accommodation a = accommodations.get(i);

            if (!a.isPaid()) {
                unpaidAccommodations.add(a);
            }
        }
        return unpaidAccommodations;
    }

    public ArrayList<Accommodation> getAccommodationsByRoom(Room room) {
        ArrayList<Accommodation> roomAccommodations = new ArrayList<>();
        for (int i = 0; i < accommodations.size(); i++) {
            Accommodation a = accommodations.get(i);

            if (a.getRoom().getId().equals(room.getId())) {
                roomAccommodations.add(a);
            }
        }
        return roomAccommodations;
    }

    public ArrayList<Accommodation> getAccommodationsByClient(Client client) {
        ArrayList<Accommodation> clientAccommodations = new ArrayList<>();
        for (int i = 0; i < accommodations.size(); i++) {
            Accommodation a = accommodations.get(i);

            if (a.getClient().equals(client)) {
                clientAccommodations.add(a);
            }
        }
        return clientAccommodations;
    }

    public ArrayList<Accommodation> getEndedUnpaidAccommodations() {
        Date now = GUI.getCurrentSystemTime().getTime();

        ArrayList<Accommodation> endedAccommodations = new ArrayList<>();
        for (int i = 0; i < accommodations.size(); i++) {
            Accommodation a = accommodations.get(i);

            if (!a.isPaid() && Tool.isAfter(now, a.getUntil())) {
                endedAccommodations.add(a);
            }
        }
        return endedAccommodations;
    }

    public Room getSelectedRoom(int index) {
        return rooms.get(index);
    }

    public RoomCategory getSelectedRoomCategory(int index) {
        return roomCategories.get(index);
    }

    public Service getSelectedService(int index) {
        return services.get(index);
    }

    public Client getSelectedClient(int index) {
        return clients.get(index);
    }

    public Reservation getSelectedReservation(int index) {
        return reservations.get(index);
    }

    public Accommodation getSelectedAccommodation(int index) {
        return accommodations.get(index);
    }

    public Payment getSelectedPayment(int index) {
        return payments.get(index);
    }

    public String[] getRoomsId() {
        String[] ids = new String[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            ids[i] = rooms.get(i).getId();
        }
        return ids;
    }

    public String[] getRoomCategoriesDsescription() {
        String[] descriptions = new String[roomCategories.size()];
        for (int i = 0; i < roomCategories.size(); i++) {
            descriptions[i] = roomCategories.get(i).toString();
        }
        return descriptions;
    }

    public String[] getServicesDescription() {
        String[] descriptions = new String[services.size()];
        for (int i = 0; i < services.size(); i++) {
            descriptions[i] = services.get(i).getDescription();
        }
        return descriptions;
    }

    public String[] getClientsDescription() {
        String[] descriptions = new String[clients.size()];
        for (int i = 0; i < clients.size(); i++) {
            descriptions[i] = clients.get(i).toString();
        }
        return descriptions;
    }

    public String[] getUnpaidAccommodationsDetail(ArrayList<Accommodation> unpaidAccommodations) {
        String[] details = new String[unpaidAccommodations.size()];
        for (int i = 0; i < unpaidAccommodations.size(); i++) {
            Accommodation a = unpaidAccommodations.get(i);
            details[i] = a.getClient().getName() + ", " + a.getRoom().getId() + ", " + a.getFromUntilDate();
        }
        return details;
    }

    public void saveAccommodations() {
        DataSerializer.saveToFile(accommodations, DataSerializer.ACCOMMODATIONS_FILE);
    }

}
