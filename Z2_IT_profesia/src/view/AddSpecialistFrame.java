/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DataSerializer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import model.Administrator;
import model.Programmer;
import model.SecurityConsultant;

/**
 *
 * @author kappe
 */
public class AddSpecialistFrame extends javax.swing.JFrame {

    JFrame parentFrame;
    private final ArrayList<Programmer> programmers;
    private final ArrayList<SecurityConsultant> consultants;
    private final ArrayList<Administrator> administrators;
    DecimalFormat priceFormat;

    /**
     * Creates new form AddSpecialistFrame
     *
     * @param parent
     * @param programmers
     * @param consultants
     * @param administrators
     */
    public AddSpecialistFrame(JFrame parent, ArrayList<Programmer> programmers,
            ArrayList<SecurityConsultant> consultants, ArrayList<Administrator> administrators) {
        initComponents();

        this.parentFrame = parent;
        this.programmers = programmers;
        this.consultants = consultants;
        this.administrators = administrators;

        priceFormat = new DecimalFormat("########0.00");
        populateSpecialistComboBox();
    }

    // Naplnenie comboBoxu s typmi Specialistov
    private void populateSpecialistComboBox() {
        String[] freelancerTypes = {"Programátor", "Bezpečnostný konzultant", "Administrátor"};
        specialistComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(freelancerTypes));
        specialistComboBox.setSelectedIndex(0);
    }

    // Vytvor a uloz noveho programatora
    private void createProgrammer() {
        String name = nameField1.getText().trim();
        String type = typeField1.getText().trim();
        double price;
        int practice;
        String education = educationField1.getText().trim();
        ArrayList<String> certificates = getCertificatesList(programmerCertificateList);

        try {
            price = Double.parseDouble(priceField1.getText().trim().replace(',', '.'));
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cena musí byť kladná číselná hodnota!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            practice = Integer.parseInt(practiceField1.getText().trim());
            if (practice < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Prax musí byť celé a nezáporné číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Programmer programmer = new Programmer(name, type, price, practice, education, certificates);
        programmers.add(programmer);
        DataSerializer.saveProgrammersToFile(programmers, DataSerializer.PROGRAMMERS_FILE);

        JOptionPane.showMessageDialog(null, "Údaje o novom programátorovi boli úspešne uložené!");
        dispose();
        parentFrame.setVisible(true);
    }

    // Vytvor a uloz noveho bezpecnostneho konzultanta
    private void createConsultant() {
        String name = nameField2.getText().trim();
        boolean isAuditor = checkBox2.isSelected();
        double price;
        int practice;
        String education = educationField2.getText().trim();
        ArrayList<String> certificates = getCertificatesList(consultantCertificateList);

        try {
            price = Double.parseDouble(priceField2.getText().trim().replace(',', '.'));
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cena musí byť kladná číselná hodnota!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            practice = Integer.parseInt(practiceField2.getText().trim());
            if (practice < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Prax musí byť celé a nezáporné číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SecurityConsultant consultant = new SecurityConsultant(name, isAuditor, price, practice, education, certificates);
        consultants.add(consultant);
        DataSerializer.saveConsultantsToFile(consultants, DataSerializer.CONSULTANTS_FILE);

        JOptionPane.showMessageDialog(null, "Údaje o novom bezpečnostnom konzultantovi boli úspešne uložené!");
        dispose();
        parentFrame.setVisible(true);
    }

    // Vytvor a uloz noveho administratora
    private void createAdministrator() {
        String name = nameField3.getText().trim();
        String platform = platformField3.getText().trim();
        String type = typeField3.getText().trim();
        double price;
        int practice;
        String education = educationField3.getText().trim();
        ArrayList<String> certificates = getCertificatesList(adminCertificateList);

        try {
            price = Double.parseDouble(priceField3.getText().trim().replace(',', '.'));
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cena musí byť kladná číselná hodnota!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            practice = Integer.parseInt(practiceField3.getText().trim());
            if (practice < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Prax musí byť celé a nezáporné číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Administrator administrator = new Administrator(name, platform, type, price, practice, education, certificates);
        administrators.add(administrator);
        DataSerializer.saveAdministratorsToFile(administrators, DataSerializer.ADMINISTRATORS_FILE);

        JOptionPane.showMessageDialog(null, "Údaje o novom administrátorovi boli úspešne uložené!");
        dispose();
        parentFrame.setVisible(true);
    }

    // Pridanie certifikatu do zoznamu
    private void appendToList(JTextField messageField, JList<String> lst) {
        String certificate = messageField.getText();

        if (!certificate.isBlank()) {
            DefaultListModel<String> newModel = new DefaultListModel<>();
            ListModel<String> oldModel = lst.getModel();

            for (int i = 0; i < oldModel.getSize(); i++) {
                newModel.add(i, oldModel.getElementAt(i));
            }

            newModel.add(oldModel.getSize(), certificate);
            lst.setModel(newModel);

            messageField.setText("");
        }
    }

    // Odstranenie certifikatu zo zoznamu
    private void removeFromList(JList<String> lst) {
        int selectedIndex = lst.getSelectedIndex();

        if (selectedIndex > -1) {
            DefaultListModel<String> newModel = new DefaultListModel<>();
            ListModel<String> oldModel = lst.getModel();

            for (int i = 0, counter = 0; i < oldModel.getSize(); i++) {
                if (i != selectedIndex) {
                    newModel.add(counter++, oldModel.getElementAt(i));
                }
            }

            lst.setModel(newModel);
        }
    }

    private ArrayList<String> getCertificatesList(JList<String> lst) {
        ArrayList<String> certificates = new ArrayList<>();
        ListModel<String> model = lst.getModel();

        for (int i = 0; i < model.getSize(); i++) {
            certificates.add(model.getElementAt(i));
        }

        return certificates;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        mainLabel = new javax.swing.JLabel();
        specialistComboBox = new javax.swing.JComboBox<>();
        middlePanel = new javax.swing.JPanel();
        programmerPanel = new javax.swing.JPanel();
        nameLabel1 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        practiceLabel1 = new javax.swing.JLabel();
        educationLabel1 = new javax.swing.JLabel();
        typeLabel1 = new javax.swing.JLabel();
        certificateLabel1 = new javax.swing.JLabel();
        euroLabel1 = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        priceField1 = new javax.swing.JTextField();
        practiceField1 = new javax.swing.JTextField();
        educationField1 = new javax.swing.JTextField();
        typeField1 = new javax.swing.JTextField();
        certificateField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        programmerCertificateList = new javax.swing.JList<>();
        addCertificateProgBtn = new javax.swing.JButton();
        delCertificateProgBtn = new javax.swing.JButton();
        securityPanel = new javax.swing.JPanel();
        nameLabel2 = new javax.swing.JLabel();
        priceLabel2 = new javax.swing.JLabel();
        practiceLabel2 = new javax.swing.JLabel();
        educationLabel2 = new javax.swing.JLabel();
        certificateLabel2 = new javax.swing.JLabel();
        euroLabel2 = new javax.swing.JLabel();
        nameField2 = new javax.swing.JTextField();
        priceField2 = new javax.swing.JTextField();
        practiceField2 = new javax.swing.JTextField();
        educationField2 = new javax.swing.JTextField();
        certificateField2 = new javax.swing.JTextField();
        checkBox2 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultantCertificateList = new javax.swing.JList<>();
        delCertificateConsBtn = new javax.swing.JButton();
        addCertificateConsBtn = new javax.swing.JButton();
        adminPanel = new javax.swing.JPanel();
        nameLabel3 = new javax.swing.JLabel();
        priceLabel3 = new javax.swing.JLabel();
        practiceLabel3 = new javax.swing.JLabel();
        educationLabel3 = new javax.swing.JLabel();
        typeLabel3 = new javax.swing.JLabel();
        certificateLabel3 = new javax.swing.JLabel();
        platformLabel3 = new javax.swing.JLabel();
        euroLabel3 = new javax.swing.JLabel();
        nameField3 = new javax.swing.JTextField();
        priceField3 = new javax.swing.JTextField();
        practiceField3 = new javax.swing.JTextField();
        educationField3 = new javax.swing.JTextField();
        typeField3 = new javax.swing.JTextField();
        certificateField3 = new javax.swing.JTextField();
        platformField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminCertificateList = new javax.swing.JList<>();
        delCertificateAdminBtn = new javax.swing.JButton();
        addCertificateAdminBtn = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pridať špecialistu");
        setMinimumSize(new java.awt.Dimension(680, 620));
        setPreferredSize(new java.awt.Dimension(680, 620));

        topPanel.setBackground(new java.awt.Color(253, 247, 236));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainLabel.setText("Typ nového špecialistu:");
        topPanel.add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 270, 40));

        specialistComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        specialistComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2" }));
        specialistComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialistComboBoxActionPerformed(evt);
            }
        });
        topPanel.add(specialistComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 210, 30));

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        middlePanel.setLayout(new java.awt.CardLayout());

        programmerPanel.setBackground(new java.awt.Color(253, 247, 236));
        programmerPanel.setMinimumSize(new java.awt.Dimension(660, 680));
        programmerPanel.setPreferredSize(new java.awt.Dimension(660, 680));
        programmerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel1.setForeground(new java.awt.Color(255, 153, 0));
        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel1.setText("Meno programátora:");
        programmerPanel.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 220, 30));

        priceLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceLabel1.setForeground(new java.awt.Color(255, 153, 0));
        priceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel1.setText("Cena za deň:");
        programmerPanel.add(priceLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 220, 30));

        practiceLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        practiceLabel1.setForeground(new java.awt.Color(255, 153, 0));
        practiceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        practiceLabel1.setText("Dĺžka praxe (v rokoch):");
        programmerPanel.add(practiceLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 220, 30));

        educationLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        educationLabel1.setForeground(new java.awt.Color(255, 153, 0));
        educationLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        educationLabel1.setText("Najvyššie dosiahnuté vzdelanie:");
        programmerPanel.add(educationLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 30));

        typeLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeLabel1.setForeground(new java.awt.Color(255, 153, 0));
        typeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeLabel1.setText("Zaradenie:");
        programmerPanel.add(typeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 30));

        certificateLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        certificateLabel1.setForeground(new java.awt.Color(255, 153, 0));
        certificateLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        certificateLabel1.setText("Certifikáty:");
        programmerPanel.add(certificateLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 220, 30));

        euroLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        euroLabel1.setForeground(new java.awt.Color(255, 153, 0));
        euroLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        euroLabel1.setText("€");
        programmerPanel.add(euroLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 20, 30));

        nameField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmerPanel.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 260, 30));

        priceField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        programmerPanel.add(priceField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 110, 30));

        practiceField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        practiceField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        programmerPanel.add(practiceField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 110, 30));

        educationField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmerPanel.add(educationField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 260, 30));

        typeField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmerPanel.add(typeField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, 30));

        certificateField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmerPanel.add(certificateField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 260, 30));

        programmerCertificateList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programmerCertificateList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        programmerCertificateList.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(programmerCertificateList);

        programmerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 260, 110));

        addCertificateProgBtn.setBackground(new java.awt.Color(255, 204, 102));
        addCertificateProgBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addCertificateProgBtn.setText("Pridať");
        addCertificateProgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addCertificateProgBtnMouseReleased(evt);
            }
        });
        programmerPanel.add(addCertificateProgBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 90, -1));

        delCertificateProgBtn.setBackground(new java.awt.Color(255, 204, 102));
        delCertificateProgBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delCertificateProgBtn.setText("Odstrániť");
        delCertificateProgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delCertificateProgBtnMouseReleased(evt);
            }
        });
        programmerPanel.add(delCertificateProgBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 90, -1));

        middlePanel.add(programmerPanel, "card2");

        securityPanel.setBackground(new java.awt.Color(253, 247, 236));
        securityPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel2.setForeground(new java.awt.Color(255, 153, 51));
        nameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel2.setText("Meno bezpečnostného konzultanta:");
        securityPanel.add(nameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 30));

        priceLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceLabel2.setForeground(new java.awt.Color(255, 153, 51));
        priceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel2.setText("Cena za deň:");
        securityPanel.add(priceLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 220, 30));

        practiceLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        practiceLabel2.setForeground(new java.awt.Color(255, 153, 51));
        practiceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        practiceLabel2.setText("Dĺžka praxe (v rokoch):");
        securityPanel.add(practiceLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 220, 30));

        educationLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        educationLabel2.setForeground(new java.awt.Color(255, 153, 51));
        educationLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        educationLabel2.setText("Najvyššie dosiahnuté vzdelanie:");
        securityPanel.add(educationLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 30));

        certificateLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        certificateLabel2.setForeground(new java.awt.Color(255, 153, 51));
        certificateLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        certificateLabel2.setText("Certifikáty:");
        securityPanel.add(certificateLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 220, 30));

        euroLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        euroLabel2.setForeground(new java.awt.Color(255, 153, 51));
        euroLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        euroLabel2.setText("€");
        securityPanel.add(euroLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 20, 30));

        nameField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        securityPanel.add(nameField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 260, 30));

        priceField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        securityPanel.add(priceField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 110, 30));

        practiceField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        practiceField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        securityPanel.add(practiceField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 110, 30));

        educationField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        securityPanel.add(educationField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 260, 30));

        certificateField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        securityPanel.add(certificateField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 260, 30));

        checkBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkBox2.setForeground(new java.awt.Color(255, 153, 51));
        checkBox2.setText("Je audítor kybernetickej bezpečnosti NBU");
        securityPanel.add(checkBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 320, 30));

        consultantCertificateList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        consultantCertificateList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        consultantCertificateList.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jScrollPane2.setViewportView(consultantCertificateList);

        securityPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 260, 110));

        delCertificateConsBtn.setBackground(new java.awt.Color(255, 204, 102));
        delCertificateConsBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delCertificateConsBtn.setText("Odstrániť");
        delCertificateConsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delCertificateConsBtnMouseReleased(evt);
            }
        });
        securityPanel.add(delCertificateConsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 90, -1));

        addCertificateConsBtn.setBackground(new java.awt.Color(255, 204, 102));
        addCertificateConsBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addCertificateConsBtn.setText("Pridať");
        addCertificateConsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addCertificateConsBtnMouseReleased(evt);
            }
        });
        securityPanel.add(addCertificateConsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 90, -1));

        middlePanel.add(securityPanel, "card3");

        adminPanel.setBackground(new java.awt.Color(253, 247, 236));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel3.setForeground(new java.awt.Color(255, 153, 51));
        nameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel3.setText("Meno administrátora:");
        adminPanel.add(nameLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 30));

        priceLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceLabel3.setForeground(new java.awt.Color(255, 153, 51));
        priceLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel3.setText("Cena za deň:");
        adminPanel.add(priceLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 230, 30));

        practiceLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        practiceLabel3.setForeground(new java.awt.Color(255, 153, 51));
        practiceLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        practiceLabel3.setText("Dĺžka praxe (v rokoch):");
        adminPanel.add(practiceLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, 30));

        educationLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        educationLabel3.setForeground(new java.awt.Color(255, 153, 51));
        educationLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        educationLabel3.setText("Najvyššie dosiahnuté vzdelanie:");
        adminPanel.add(educationLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 230, 30));

        typeLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeLabel3.setForeground(new java.awt.Color(255, 153, 51));
        typeLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeLabel3.setText("Zaradenie:");
        adminPanel.add(typeLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 230, 30));

        certificateLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        certificateLabel3.setForeground(new java.awt.Color(255, 153, 51));
        certificateLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        certificateLabel3.setText("Certifikáty:");
        adminPanel.add(certificateLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 230, 30));

        platformLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        platformLabel3.setForeground(new java.awt.Color(255, 153, 51));
        platformLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        platformLabel3.setText("Preferovaná platforma:");
        adminPanel.add(platformLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 230, 30));

        euroLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        euroLabel3.setForeground(new java.awt.Color(255, 153, 51));
        euroLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        euroLabel3.setText("€");
        adminPanel.add(euroLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 20, 30));

        nameField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPanel.add(nameField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 260, 30));

        priceField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        adminPanel.add(priceField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 110, 30));

        practiceField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        practiceField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        adminPanel.add(practiceField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 110, 30));

        educationField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPanel.add(educationField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 260, 30));

        typeField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPanel.add(typeField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, 30));

        certificateField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPanel.add(certificateField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 260, 30));

        platformField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPanel.add(platformField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 260, 30));

        adminCertificateList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminCertificateList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        adminCertificateList.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jScrollPane3.setViewportView(adminCertificateList);

        adminPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 260, 110));

        delCertificateAdminBtn.setBackground(new java.awt.Color(255, 204, 102));
        delCertificateAdminBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delCertificateAdminBtn.setText("Odstrániť");
        delCertificateAdminBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delCertificateAdminBtnMouseReleased(evt);
            }
        });
        adminPanel.add(delCertificateAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 90, -1));

        addCertificateAdminBtn.setBackground(new java.awt.Color(255, 204, 102));
        addCertificateAdminBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addCertificateAdminBtn.setText("Pridať");
        addCertificateAdminBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addCertificateAdminBtnMouseReleased(evt);
            }
        });
        adminPanel.add(addCertificateAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 90, -1));

        middlePanel.add(adminPanel, "card4");

        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setBackground(new java.awt.Color(253, 247, 236));
        bottomPanel.setMinimumSize(new java.awt.Dimension(500, 80));
        bottomPanel.setPreferredSize(new java.awt.Dimension(500, 80));
        bottomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addBtn.setBackground(new java.awt.Color(255, 204, 102));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setText("Pridať");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addBtnMouseReleased(evt);
            }
        });
        bottomPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 100, 40));

        cancelBtn.setBackground(new java.awt.Color(255, 204, 102));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setText("Späť");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelBtnMouseReleased(evt);
            }
        });
        bottomPanel.add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 100, 40));

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Navrat na domovsku obrazovku
    private void cancelBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseReleased
        dispose();
        parentFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnMouseReleased

    // Prepinanie medzi kartami Programator, Bezpecnostny konzultant a Administrator
    private void specialistComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialistComboBoxActionPerformed
        int selectedIndex = specialistComboBox.getSelectedIndex();

        programmerPanel.setVisible(false);
        securityPanel.setVisible(false);
        adminPanel.setVisible(false);

        switch (selectedIndex) {
            case 0:
                programmerPanel.setVisible(true);
                break;
            case 1:
                securityPanel.setVisible(true);
                break;
            case 2:
                adminPanel.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_specialistComboBoxActionPerformed

    // Pridanie noveho specialistu
    private void addBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseReleased
        int selectedIndex = specialistComboBox.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                if (nameField1.getText().isBlank() || priceField1.getText().isBlank() || practiceField1.getText().isBlank()
                        || educationField1.getText().isBlank() || typeField1.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
                } else {
                    createProgrammer();
                }
                break;
            case 1:
                if (nameField2.getText().isBlank() || priceField2.getText().isBlank() || practiceField2.getText().isBlank()
                        || educationField2.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
                } else {
                    createConsultant();
                }
                break;
            case 2:
                if (nameField3.getText().isBlank() || priceField3.getText().isBlank() || practiceField3.getText().isBlank()
                        || educationField3.getText().isBlank() || typeField3.getText().isBlank() || platformField3.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
                } else {
                    createAdministrator();
                }
                break;
        }
    }//GEN-LAST:event_addBtnMouseReleased

    private void addCertificateProgBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCertificateProgBtnMouseReleased
        appendToList(certificateField1, programmerCertificateList);
    }//GEN-LAST:event_addCertificateProgBtnMouseReleased

    private void delCertificateProgBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delCertificateProgBtnMouseReleased
        removeFromList(programmerCertificateList);
    }//GEN-LAST:event_delCertificateProgBtnMouseReleased

    private void addCertificateConsBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCertificateConsBtnMouseReleased
        appendToList(certificateField2, consultantCertificateList);
    }//GEN-LAST:event_addCertificateConsBtnMouseReleased

    private void delCertificateConsBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delCertificateConsBtnMouseReleased
        removeFromList(consultantCertificateList);
    }//GEN-LAST:event_delCertificateConsBtnMouseReleased

    private void addCertificateAdminBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCertificateAdminBtnMouseReleased
        appendToList(certificateField3, adminCertificateList);
    }//GEN-LAST:event_addCertificateAdminBtnMouseReleased

    private void delCertificateAdminBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delCertificateAdminBtnMouseReleased
        removeFromList(adminCertificateList);
    }//GEN-LAST:event_delCertificateAdminBtnMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addCertificateAdminBtn;
    private javax.swing.JButton addCertificateConsBtn;
    private javax.swing.JButton addCertificateProgBtn;
    private javax.swing.JList<String> adminCertificateList;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField certificateField1;
    private javax.swing.JTextField certificateField2;
    private javax.swing.JTextField certificateField3;
    private javax.swing.JLabel certificateLabel1;
    private javax.swing.JLabel certificateLabel2;
    private javax.swing.JLabel certificateLabel3;
    private javax.swing.JCheckBox checkBox2;
    private javax.swing.JList<String> consultantCertificateList;
    private javax.swing.JButton delCertificateAdminBtn;
    private javax.swing.JButton delCertificateConsBtn;
    private javax.swing.JButton delCertificateProgBtn;
    private javax.swing.JTextField educationField1;
    private javax.swing.JTextField educationField2;
    private javax.swing.JTextField educationField3;
    private javax.swing.JLabel educationLabel1;
    private javax.swing.JLabel educationLabel2;
    private javax.swing.JLabel educationLabel3;
    private javax.swing.JLabel euroLabel1;
    private javax.swing.JLabel euroLabel2;
    private javax.swing.JLabel euroLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField nameField2;
    private javax.swing.JTextField nameField3;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private javax.swing.JTextField platformField3;
    private javax.swing.JLabel platformLabel3;
    private javax.swing.JTextField practiceField1;
    private javax.swing.JTextField practiceField2;
    private javax.swing.JTextField practiceField3;
    private javax.swing.JLabel practiceLabel1;
    private javax.swing.JLabel practiceLabel2;
    private javax.swing.JLabel practiceLabel3;
    private javax.swing.JTextField priceField1;
    private javax.swing.JTextField priceField2;
    private javax.swing.JTextField priceField3;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel priceLabel3;
    private javax.swing.JList<String> programmerCertificateList;
    private javax.swing.JPanel programmerPanel;
    private javax.swing.JPanel securityPanel;
    private javax.swing.JComboBox<String> specialistComboBox;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField typeField1;
    private javax.swing.JTextField typeField3;
    private javax.swing.JLabel typeLabel1;
    private javax.swing.JLabel typeLabel3;
    // End of variables declaration//GEN-END:variables
}
