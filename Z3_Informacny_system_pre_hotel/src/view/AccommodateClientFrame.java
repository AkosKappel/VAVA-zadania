package view;

import controller.MainLogic;
import controller.Tool;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Accommodation;
import model.Client;
import model.Reservation;
import model.Room;

/**
 *
 * @author kappe
 */
public class AccommodateClientFrame extends javax.swing.JFrame {

    private final MainFrame parentFrame;
    private final MainLogic app;
    private ArrayList<Room> availableRooms;
    private Date fromDate;
    private Date untilDate;

    /**
     * Creates new form AccommodationFrame
     *
     * @param parentFrame
     */
    public AccommodateClientFrame(MainFrame parentFrame) {
        initComponents();

        this.parentFrame = parentFrame;
        this.app = parentFrame.app;

        populateTypeComboBox();
        populateClientComboBox();
        populateReservationsTable();
    }

    private void populateTypeComboBox() {
        String[] freelancerTypes = {"S rezerváciou", "Bez rezervácie"};
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(freelancerTypes));
        typeComboBox.setSelectedIndex(0);
    }

    private void populateClientComboBox() {
        String[] clients = app.getClientsDescription();
        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(clients));

        if (clientComboBox.getModel().getSize() > 0) {
            clientComboBox.setSelectedIndex(0);
        }
    }

    private void populateReservationsTable() {
        DefaultTableModel tblModel = (DefaultTableModel) reservationsTbl.getModel();
        tblModel.setRowCount(0);
        DecimalFormat formatter = new DecimalFormat("########0.00");

        ArrayList<Reservation> reservations = app.getReservations();
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);

            String[] row = {r.getClient().getName(), r.getRoom().getId(), formatter.format(r.getPrice()) + " €",
                Tool.dateToString(r.getFrom()), Tool.dateToString(r.getUntil())};
            tblModel.addRow(row);
        }
    }

    private void populateAvailableRoomsTable() {
        DefaultTableModel tblModel = (DefaultTableModel) availableRoomsTbl.getModel();
        tblModel.setRowCount(0);
        DecimalFormat formatter = new DecimalFormat("########0.00");

        for (int i = 0; i < availableRooms.size(); i++) {
            Room r = availableRooms.get(i);
            Double price = r.calculatePrice(fromDate, untilDate);

            String[] row = {r.getId(), r.getCategory().toString(), formatter.format(price) + " €"};
            tblModel.addRow(row);
        }
    }

    private void setAvailableRooms() {
        availableRooms = (ArrayList<Room>) app.getRooms().clone();
        Iterator<Room> roomIterator;
        String reservationRoomId;

        for (Reservation reservation : app.getReservations()) {

            if (!(Tool.isBefore(untilDate, reservation.getFrom()) || Tool.isAfter(fromDate, reservation.getUntil()))) {
                reservationRoomId = reservation.getRoom().getId();
                roomIterator = availableRooms.iterator();

                while (roomIterator.hasNext()) {
                    Room room = roomIterator.next();
                    if (room.getId().equals(reservationRoomId)) {
                        roomIterator.remove();
                        break;
                    }
                }
            }
        }

        for (Accommodation accommodation : app.getAccommodations()) {

            if (!(Tool.isBefore(untilDate, accommodation.getFrom()) || Tool.isAfter(fromDate, accommodation.getUntil()))) {
                reservationRoomId = accommodation.getRoom().getId();
                roomIterator = availableRooms.iterator();

                while (roomIterator.hasNext()) {
                    Room room = roomIterator.next();
                    if (room.getId().equals(reservationRoomId)) {
                        roomIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    private void makeAccommodationWithReservation() {
        int reservationIndex = reservationsTbl.getSelectedRow();

        if (reservationIndex < 0) {
            JOptionPane.showMessageDialog(null, "Prosím vyberte si rezerváciu na ubytovanie.", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reservation reservation = app.getSelectedReservation(reservationIndex);
        app.removeReservation(reservationIndex);
        app.addAccommodation(new Accommodation(reservation.getClient(), reservation.getRoom(), reservation.getPrice(),
                reservation.getFrom(), reservation.getUntil()));

        JOptionPane.showMessageDialog(null, "Ubytovanie bolo úspešne zaevidované.");
        populateReservationsTable();
    }

    private void makeAccommodationWithoutReservation() {
        int roomIndex = availableRoomsTbl.getSelectedRow();
        int clientIndex = clientComboBox.getSelectedIndex();

        if (roomIndex < 0) {
            JOptionPane.showMessageDialog(null, "Prosím vyberte si izbu pre ubytovanie.", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (clientIndex < 0) {
            JOptionPane.showMessageDialog(null, "Prosím vyberte zákazníka pre ubytovanie.", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Client client = app.getSelectedClient(clientIndex);
        Room room = availableRooms.get(roomIndex);
        double price = room.calculatePrice(fromDate, untilDate);

        app.addAccommodation(new Accommodation(client, room, price, fromDate, untilDate));
        JOptionPane.showMessageDialog(null, "Ubytovanie bolo úspešne zaevidované.");

        setAvailableRooms();
        populateAvailableRoomsTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        typeComboBox = new javax.swing.JComboBox<>();
        titleLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        withReservationPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationsTbl = new javax.swing.JTable();
        withoutReservationPanel = new javax.swing.JPanel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        untilDateChooser = new com.toedter.calendar.JDateChooser();
        showBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableRoomsTbl = new javax.swing.JTable();
        clientComboBox = new javax.swing.JComboBox<>();
        clientLbl = new javax.swing.JLabel();
        fromLbl = new javax.swing.JLabel();
        untilLbl = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        accommodateBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ubytovať zákazníka");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(204, 171, 244));
        topPanel.setMinimumSize(new java.awt.Dimension(700, 130));
        topPanel.setPreferredSize(new java.awt.Dimension(700, 130));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        topPanel.add(typeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 290, -1));

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(0, 0, 0));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Ubytovanie zákazníka");
        topPanel.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 50));

        nameLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(144, 14, 126));
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLbl.setText("Spôsob ubytovania:");
        topPanel.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 180, 30));

        mainPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        middlePanel.setLayout(new java.awt.CardLayout());

        withReservationPanel.setBackground(new java.awt.Color(204, 171, 244));
        withReservationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservationsTbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reservationsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zákazník", "Izba", "Cena", "Dátum od", "Dátum do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservationsTbl.setRowHeight(20);
        reservationsTbl.setSelectionBackground(new java.awt.Color(204, 0, 204));
        reservationsTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(reservationsTbl);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        dtcr.setBackground(new Color(114, 14, 126));
        dtcr.setForeground(new Color(255, 255, 255));

        for (int i = 0; i < reservationsTbl.getModel().getColumnCount(); i++) {
            reservationsTbl.getColumnModel().getColumn(i).setHeaderRenderer(dtcr);
        }

        withReservationPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 650, 250));

        middlePanel.add(withReservationPanel, "card2");

        withoutReservationPanel.setBackground(new java.awt.Color(204, 171, 244));
        withoutReservationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        withoutReservationPanel.add(fromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 180, -1));
        withoutReservationPanel.add(untilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 180, -1));

        showBtn.setBackground(new java.awt.Color(114, 14, 126));
        showBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showBtn.setForeground(new java.awt.Color(255, 255, 255));
        showBtn.setText("<html>\n<p style=\"text-align: center;\">\nZobraziť dostupné izby\n</p>\n</html>");
        showBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showBtnMouseReleased(evt);
            }
        });
        withoutReservationPanel.add(showBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 30));

        availableRoomsTbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        availableRoomsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Izba", "Kategória", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        availableRoomsTbl.setRowHeight(20);
        availableRoomsTbl.setSelectionBackground(new java.awt.Color(204, 0, 204));
        availableRoomsTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(availableRoomsTbl);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        headerRenderer.setBackground(new Color(114, 14, 126));
        headerRenderer.setForeground(new Color(255, 255, 255));

        for (int i = 0; i < availableRoomsTbl.getModel().getColumnCount(); i++) {
            availableRoomsTbl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        withoutReservationPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 630, 140));

        clientComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2" }));
        withoutReservationPanel.add(clientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 420, 30));

        clientLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clientLbl.setForeground(new java.awt.Color(144, 14, 126));
        clientLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        clientLbl.setText("Meno zákazníka:");
        withoutReservationPanel.add(clientLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 30));

        fromLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fromLbl.setForeground(new java.awt.Color(144, 14, 126));
        fromLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fromLbl.setText("Od:");
        withoutReservationPanel.add(fromLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 30, 30));

        untilLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        untilLbl.setForeground(new java.awt.Color(144, 14, 126));
        untilLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        untilLbl.setText("Do:");
        withoutReservationPanel.add(untilLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 30, 30));

        middlePanel.add(withoutReservationPanel, "card3");

        mainPanel.add(middlePanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setBackground(new java.awt.Color(204, 171, 244));
        bottomPanel.setMinimumSize(new java.awt.Dimension(700, 90));
        bottomPanel.setPreferredSize(new java.awt.Dimension(700, 90));
        bottomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accommodateBtn.setBackground(new java.awt.Color(114, 14, 126));
        accommodateBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        accommodateBtn.setForeground(new java.awt.Color(255, 255, 255));
        accommodateBtn.setText("<html>\n<p style=\"text-align: center;\">\nUbytovať\n</p>\n</html>");
        accommodateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accommodateBtnMouseReleased(evt);
            }
        });
        bottomPanel.add(accommodateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 110, 40));

        backBtn.setBackground(new java.awt.Color(114, 14, 126));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("<html>\n<p style=\"text-align: center;\">\nSpäť\n</p>\n</html>");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnMouseReleased(evt);
            }
        });
        bottomPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, 40));

        mainPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseReleased
        this.parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseReleased

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        int selectedIndex = typeComboBox.getSelectedIndex();

        withReservationPanel.setVisible(false);
        withoutReservationPanel.setVisible(false);

        switch (selectedIndex) {
            case 0:
                withReservationPanel.setVisible(true);
                break;
            case 1:
                withoutReservationPanel.setVisible(true);
                break;
        }
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void accommodateBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accommodateBtnMouseReleased
        int panelIndex = typeComboBox.getSelectedIndex();

        if (panelIndex == 0) {
            makeAccommodationWithReservation();
        } else if (panelIndex == 1) {
            makeAccommodationWithoutReservation();
        }
    }//GEN-LAST:event_accommodateBtnMouseReleased

    private void showBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseReleased
        fromDate = fromDateChooser.getDate();
        untilDate = untilDateChooser.getDate();

        if (fromDate == null || untilDate == null) {
            JOptionPane.showMessageDialog(null, "Prosím vyberte si dátum pre ubytovanie.", "Chybný dátum!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Tool.isBefore(fromDate, untilDate)) {
            JOptionPane.showMessageDialog(null, "Začiatočný dátum musí byť skôr ako dátum ukončenia.", "Nesprávny termín!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setAvailableRooms();
        populateAvailableRoomsTable();
    }//GEN-LAST:event_showBtnMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accommodateBtn;
    private javax.swing.JTable availableRoomsTbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JLabel clientLbl;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTable reservationsTbl;
    private javax.swing.JButton showBtn;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel topPanel;
    private javax.swing.JComboBox<String> typeComboBox;
    private com.toedter.calendar.JDateChooser untilDateChooser;
    private javax.swing.JLabel untilLbl;
    private javax.swing.JPanel withReservationPanel;
    private javax.swing.JPanel withoutReservationPanel;
    // End of variables declaration//GEN-END:variables
}
