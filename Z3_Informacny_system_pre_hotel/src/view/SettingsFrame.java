package view;

import controller.MainLogic;
import controller.Tool;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author kappe
 */
public class SettingsFrame extends javax.swing.JFrame {

    private final MainFrame parentFrame;

    /**
     * Creates new form SettingsFrame
     *
     * @param parentFrame
     */
    public SettingsFrame(MainFrame parentFrame) {
        initComponents();

        this.parentFrame = parentFrame;

        initLanguageComboBox();
        dateChooser.setDate(parentFrame.getCurrentSystemTime().getTime());
    }

    private void setDate() {
        Date newDate = dateChooser.getDate();
        Date currentDate = new Date();

        int difference = Tool.getDaysDifferenceCount(newDate, currentDate);
        parentFrame.setTimeOffset(difference);
    }

    private void setLanguage() {
        int index = languageComboBox.getSelectedIndex();
        String language;
        String country;

        switch (index) {
            case 0:
                language = "sk";
                country = "SK";
                break;
            case 1:
                language = "en";
                country = "US";
                break;
            default:
                return;
        }

        Locale l = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("view/Bundle", l);
        parentFrame.setLanguage(rb);
    }

    private void initLanguageComboBox() {
        if (parentFrame.getLanguage().equals("sk") && parentFrame.getCountry().equals("SK")) {
            languageComboBox.setSelectedItem(0);
        } else if (parentFrame.getLanguage().equals("en") && parentFrame.getCountry().equals("US")) {
            languageComboBox.setSelectedIndex(1);
        }
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
        dateChooser = new com.toedter.calendar.JDateChooser();
        okBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        languageComboBox = new javax.swing.JComboBox<>();
        titleLbl = new javax.swing.JLabel();
        languageLbl = new javax.swing.JLabel();
        dateTimeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nastavenia");
        setMinimumSize(new java.awt.Dimension(440, 330));
        setPreferredSize(new java.awt.Dimension(440, 330));
        setResizable(false);
        setSize(new java.awt.Dimension(440, 330));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(204, 171, 244));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainPanel.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, -1));

        okBtn.setBackground(new java.awt.Color(114, 14, 126));
        okBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        okBtn.setForeground(new java.awt.Color(255, 255, 255));
        okBtn.setText("<html>\n<p style=\"text-align: center;\">\nOK\n</p>\n</html>");
        okBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                okBtnMouseReleased(evt);
            }
        });
        mainPanel.add(okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 110, 40));

        backBtn.setBackground(new java.awt.Color(114, 14, 126));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("<html>\n<p style=\"text-align: center;\">\nSpäť\n</p>\n</html>");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnMouseReleased(evt);
            }
        });
        mainPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 110, 40));

        languageComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SK", "EN United States" }));
        mainPanel.add(languageComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, 30));

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(0, 0, 0));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Nastavenia");
        mainPanel.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, 50));

        languageLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        languageLbl.setForeground(new java.awt.Color(114, 14, 126));
        languageLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        languageLbl.setText("Jazyk:");
        mainPanel.add(languageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        dateTimeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateTimeLbl.setForeground(new java.awt.Color(114, 14, 126));
        dateTimeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateTimeLbl.setText("Dátum:");
        mainPanel.add(dateTimeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 30));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseReleased
        this.parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseReleased

    private void okBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okBtnMouseReleased

        int index = languageComboBox.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vyberte jazyk aplikácie.", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date date = dateChooser.getDate();
        if (date == null) {
            JOptionPane.showMessageDialog(null, "Nastavte dátum.", "Chyba!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setDate();
        setLanguage();
        backBtnMouseReleased(null);
    }//GEN-LAST:event_okBtnMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateTimeLbl;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageLbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
