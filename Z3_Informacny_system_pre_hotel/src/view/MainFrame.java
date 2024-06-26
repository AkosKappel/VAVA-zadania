package view;

import controller.MainLogic;
import controller.DataSerializer;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author kappe
 */
public class MainFrame extends javax.swing.JFrame {

    public MainLogic app;
    private int timeOffset;
    private String language;
    private String country;
    private static final Logger LOG = Logger.getLogger(MainFrame.class.getName());

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        this.app = new MainLogic(this);
        this.timeOffset = 0;
        this.language = "en";
        this.country = "US";

        showDateAndTime();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ev) {
                LOG.log(Level.INFO, "Ukončenie aplikácie.\n");
                dispose();
                System.exit(0);
            }
        });
    }

    private static void initMainDirectory() {
        File mainDirectory = new File(DataSerializer.MAIN_DIRECTORY_NAME);
        if (!mainDirectory.exists()) {
            mainDirectory.mkdir();
            LOG.log(Level.INFO, "Bol vytvorený nový priečinok: " + DataSerializer.MAIN_DIRECTORY_NAME + "\n");
        }
    }

    private void showDateAndTime() {
        new Timer(0, (ActionEvent e) -> {
            if (this.isVisible()) {
                Calendar calendar = new GregorianCalendar();
                calendar.add(Calendar.DATE, timeOffset);

                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH) + 1;
                int year = calendar.get(Calendar.YEAR);

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);

                String dateString = String.format("%02d", day) + ". " + String.format("%02d", month) + ". " + year;
                String timeString = String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);

                dateLbl.setText(dateString);
                timeLbl.setText(timeString);
            }
        }).start();
    }

    // Aktualne nastaveny cas v systeme
    public Calendar getCurrentSystemTime() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, timeOffset);
        return calendar;
    }

    public void setLanguage(ResourceBundle rb) {
        language = rb.getLocale().getLanguage();
        country = rb.getLocale().getCountry();
        LOG.log(Level.INFO, "Jazyk aplik\u00e1cie bol zmenen\u00fd na {0}-{1}.\n", new Object[]{language, country});

        addRoomCategoryBtn.setText(rb.getString("ADD ROOM CATEGORIES"));
        addRoomBtn.setText(rb.getString("ADD ROOMS"));
        editRoomBtn.setText(rb.getString("EDIT ROOMS"));
        addServiceBtn.setText(rb.getString("ADD NEW SERVICES"));

        createClientBtn.setText(rb.getString("CREATE CLIENTS"));
        createReservationBtn.setText(rb.getString("CREATE RESERVATIONS"));
        cancelReservationBtn.setText(rb.getString("CANCEL RESERVATIONS"));
        accommodateClientBtn.setText(rb.getString("ACCOMMODATE CLIENTS"));

        registerServiceBtn.setText(rb.getString("REGISTER USED SERVICES"));
        unpaidAccomodationsBtn.setText(rb.getString("FINISHED ACCOMMODATIONS"));
        bookingHistoryBtn.setText(rb.getString("HISTORY OF ACCOMMODATIONS"));
        settingsBtn.setText(rb.getString("SETTINGS"));
    }

    public int getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(int timeOffset) {
        this.timeOffset = timeOffset;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        addRoomCategoryBtn = new javax.swing.JButton();
        addRoomBtn = new javax.swing.JButton();
        editRoomBtn = new javax.swing.JButton();
        addServiceBtn = new javax.swing.JButton();
        createClientBtn = new javax.swing.JButton();
        createReservationBtn = new javax.swing.JButton();
        cancelReservationBtn = new javax.swing.JButton();
        accommodateClientBtn = new javax.swing.JButton();
        registerServiceBtn = new javax.swing.JButton();
        unpaidAccomodationsBtn = new javax.swing.JButton();
        bookingHistoryBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();
        timeLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        logoLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Bundle"); // NOI18N
        setTitle(bundle.getString("MainFrame.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(204, 171, 244));
        mainPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addRoomCategoryBtn.setBackground(new java.awt.Color(114, 14, 126));
        addRoomCategoryBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addRoomCategoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomCategoryBtn.setText(bundle.getString("ADD ROOM CATEGORIES")); // NOI18N
        addRoomCategoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addRoomCategoryBtnMouseReleased(evt);
            }
        });
        mainPanel.add(addRoomCategoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 230, 40));

        addRoomBtn.setBackground(new java.awt.Color(114, 14, 126));
        addRoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomBtn.setText(bundle.getString("ADD ROOMS")); // NOI18N
        addRoomBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addRoomBtnMouseReleased(evt);
            }
        });
        mainPanel.add(addRoomBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 230, 40));

        editRoomBtn.setBackground(new java.awt.Color(114, 14, 126));
        editRoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        editRoomBtn.setText(bundle.getString("EDIT ROOMS")); // NOI18N
        editRoomBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editRoomBtnMouseReleased(evt);
            }
        });
        mainPanel.add(editRoomBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 230, 40));

        addServiceBtn.setBackground(new java.awt.Color(114, 14, 126));
        addServiceBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addServiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        addServiceBtn.setText(bundle.getString("ADD NEW SERVICES")); // NOI18N
        addServiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addServiceBtnMouseReleased(evt);
            }
        });
        mainPanel.add(addServiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 230, 40));

        createClientBtn.setBackground(new java.awt.Color(114, 14, 126));
        createClientBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createClientBtn.setForeground(new java.awt.Color(255, 255, 255));
        createClientBtn.setText(bundle.getString("CREATE CLIENTS")); // NOI18N
        createClientBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createClientBtnMouseReleased(evt);
            }
        });
        mainPanel.add(createClientBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 230, 40));

        createReservationBtn.setBackground(new java.awt.Color(114, 14, 126));
        createReservationBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createReservationBtn.setForeground(new java.awt.Color(255, 255, 255));
        createReservationBtn.setText(bundle.getString("CREATE RESERVATIONS")); // NOI18N
        createReservationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createReservationBtnMouseReleased(evt);
            }
        });
        mainPanel.add(createReservationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 230, 40));

        cancelReservationBtn.setBackground(new java.awt.Color(114, 14, 126));
        cancelReservationBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelReservationBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelReservationBtn.setText(bundle.getString("CANCEL RESERVATIONS")); // NOI18N
        cancelReservationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelReservationBtnMouseReleased(evt);
            }
        });
        mainPanel.add(cancelReservationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 230, 40));

        accommodateClientBtn.setBackground(new java.awt.Color(114, 14, 126));
        accommodateClientBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        accommodateClientBtn.setForeground(new java.awt.Color(255, 255, 255));
        accommodateClientBtn.setText(bundle.getString("ACCOMMODATE CLIENTS")); // NOI18N
        accommodateClientBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accommodateClientBtnMouseReleased(evt);
            }
        });
        mainPanel.add(accommodateClientBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 230, 40));

        registerServiceBtn.setBackground(new java.awt.Color(114, 14, 126));
        registerServiceBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerServiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerServiceBtn.setText(bundle.getString("REGISTER USED SERVICES")); // NOI18N
        registerServiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registerServiceBtnMouseReleased(evt);
            }
        });
        mainPanel.add(registerServiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 230, 40));

        unpaidAccomodationsBtn.setBackground(new java.awt.Color(114, 14, 126));
        unpaidAccomodationsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        unpaidAccomodationsBtn.setForeground(new java.awt.Color(255, 255, 255));
        unpaidAccomodationsBtn.setText(bundle.getString("FINISHED ACCOMMODATIONS")); // NOI18N
        unpaidAccomodationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                unpaidAccomodationsBtnMouseReleased(evt);
            }
        });
        mainPanel.add(unpaidAccomodationsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 230, 40));

        bookingHistoryBtn.setBackground(new java.awt.Color(114, 14, 126));
        bookingHistoryBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bookingHistoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        bookingHistoryBtn.setText(bundle.getString("HISTORY OF ACCOMMODATIONS")); // NOI18N
        bookingHistoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bookingHistoryBtnMouseReleased(evt);
            }
        });
        mainPanel.add(bookingHistoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 230, 40));

        settingsBtn.setBackground(new java.awt.Color(114, 14, 126));
        settingsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        settingsBtn.setForeground(new java.awt.Color(255, 255, 255));
        settingsBtn.setText(bundle.getString("SETTINGS")); // NOI18N
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settingsBtnMouseReleased(evt);
            }
        });
        mainPanel.add(settingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 230, 40));

        timeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(114, 14, 126));
        timeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLbl.setText(bundle.getString("MainFrame.timeLbl.text")); // NOI18N
        mainPanel.add(timeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 150, 40));

        dateLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(114, 14, 126));
        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setText(bundle.getString("MainFrame.dateLbl.text")); // NOI18N
        mainPanel.add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 150, 40));

        logoLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.jpeg"))); // NOI18N
        mainPanel.add(logoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 500, 330));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addRoomCategoryBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoomCategoryBtnMouseReleased
        new AddRoomCategoryFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomCategoryBtnMouseReleased

    private void addRoomBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoomBtnMouseReleased
        new AddRoomFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addRoomBtnMouseReleased

    private void editRoomBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editRoomBtnMouseReleased
        new EditRoomFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_editRoomBtnMouseReleased

    private void addServiceBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addServiceBtnMouseReleased
        new AddServiceFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addServiceBtnMouseReleased

    private void createClientBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createClientBtnMouseReleased
        new CreateClientFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createClientBtnMouseReleased

    private void settingsBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseReleased
        new SettingsFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_settingsBtnMouseReleased

    private void createReservationBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createReservationBtnMouseReleased
        new CreateReservationFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createReservationBtnMouseReleased

    private void cancelReservationBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelReservationBtnMouseReleased
        new CancelReservationFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelReservationBtnMouseReleased

    private void bookingHistoryBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingHistoryBtnMouseReleased
        new ShowAccommodationHistoryFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bookingHistoryBtnMouseReleased

    private void unpaidAccomodationsBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unpaidAccomodationsBtnMouseReleased
        new ShowUnpaidAccommodationsFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_unpaidAccomodationsBtnMouseReleased

    private void accommodateClientBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accommodateClientBtnMouseReleased
        new AccommodateClientFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_accommodateClientBtnMouseReleased

    private void registerServiceBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerServiceBtnMouseReleased
        new RegisterUsedServiceFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerServiceBtnMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LOG.log(Level.INFO, "Spustenie aplikácie.\n");

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOG.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create directory for serialized models */
        initMainDirectory();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accommodateClientBtn;
    private javax.swing.JButton addRoomBtn;
    private javax.swing.JButton addRoomCategoryBtn;
    private javax.swing.JButton addServiceBtn;
    private javax.swing.JButton bookingHistoryBtn;
    private javax.swing.JButton cancelReservationBtn;
    private javax.swing.JButton createClientBtn;
    private javax.swing.JButton createReservationBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton editRoomBtn;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton registerServiceBtn;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JButton unpaidAccomodationsBtn;
    // End of variables declaration//GEN-END:variables

}
