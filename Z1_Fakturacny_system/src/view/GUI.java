/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 * Tento projekt vznikol v ramci premetu VAVA na fakulte FIIT STU. Zdrojovy kod
 * som vypracoval samostatne a pri niektorych funkciach pre GUI som sa riadil
 * podla navodu z videa:
 * https://www.youtube.com/watch?v=GZ9MT2myBf8&ab_channel=JohanJurrius
 *
 * @author akos kappel
 */
public class GUI extends javax.swing.JFrame {

    // Zoznamy mojich objektov
    private final ArrayList<Customer> customers;
    private final ArrayList<Product> products;
    private final ArrayList<Invoice> invoices;

    // Objekty na formatovanie
    private final SimpleDateFormat dateFormatter;
    private final DecimalFormat priceFormatter;

    // Pomocne premenne
    private ArrayList<Integer> countsList;
    private ArrayList<Product> productsList;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        priceFormatter = new DecimalFormat("########0.00");

        customers = new ArrayList<>();
        products = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    /**
     * Zobrazi zvoleny panel v hlavnom okne aplikacie.
     *
     * @param panelID cislo panelu, ktore sa ma zobrazit
     */
    private void setToPanel(int panelID) {
        clearAllFields();
        homePanel.setVisible(false);
        addCustomerPanel.setVisible(false);
        addProductPanel.setVisible(false);
        addInvoicePanel.setVisible(false);
        editCustomerPanel.setVisible(false);
        editProductPanel.setVisible(false);
        showInvoicesPanel.setVisible(false);

        switch (panelID) {
            case 0:
                homePanel.setVisible(true);
                break;
            case 1:
                addCustomerPanel.setVisible(true);
                break;
            case 2:
                addProductPanel.setVisible(true);
                break;
            case 3:
                addInvoicePanel.setVisible(true);
                break;
            case 4:
                editCustomerPanel.setVisible(true);
                break;
            case 5:
                editProductPanel.setVisible(true);
                break;
            case 6:
                showInvoicesPanel.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Zvolená možnosť neexistuje!!", "Chyba", JOptionPane.ERROR_MESSAGE);
                homePanel.setVisible(true);
        }
    }

    /**
     * Vyprazdni vsetky textove polia v paneloch.
     */
    private void clearAllFields() {
        nameField1.setText("");
        addressField1.setText("");
        cityField1.setText("");
        postcodeField1.setText("");

        nameField2.setText("");
        descriptionField2.setText("");
        priceField2.setText("");

        dateField3.setText(dateFormatter.format(new Date()));
        countField3.setText("1");
        totalPriceField3.setText("0.00");
        ((DefaultTableModel) jTable3.getModel()).setRowCount(0);
        countsList = new ArrayList<>();
        productsList = new ArrayList<>();

        nameField4.setText("");
        addressField4.setText("");
        cityField4.setText("");
        postcodeField4.setText("");

        nameField5.setText("");
        descriptionField5.setText("");
        priceField5.setText("");
    }

    /**
     * Naplni zvoleny comboBox s menami a adresami zakaznikov.
     *
     * @param comboBox ten comboBox, ktory sa ma naplnit
     */
    private void populateCustomerArray(JComboBox comboBox) {
        String[] customersArray = new String[customers.size()];
        for (int i = 0; i < customers.size(); i++) {
            customersArray[i] = customers.get(i).toString();
        }
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(customersArray));
        comboBox.setSelectedIndex(0);
    }

    /**
     * Naplni zvoleny comboBox s nazvami a cenami tovarov.
     *
     * @param comboBox ten comboBox, ktory sa ma naplnit
     */
    private void populateProductArray(JComboBox comboBox) {
        String[] productsArray = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productsArray[i] = products.get(i).toString(priceFormatter);
        }
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(productsArray));
        comboBox.setSelectedIndex(0);
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
        leftPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        customerBtn = new javax.swing.JButton();
        productBtn = new javax.swing.JButton();
        invoiceBtn = new javax.swing.JButton();
        showInvBtn = new javax.swing.JButton();
        editCustBtn = new javax.swing.JButton();
        editProdBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        addCustomerPanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        cityLabel1 = new javax.swing.JLabel();
        postcodeLabel1 = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        addressField1 = new javax.swing.JTextField();
        cityField1 = new javax.swing.JTextField();
        postcodeField1 = new javax.swing.JTextField();
        cancelButton1 = new javax.swing.JButton();
        saveButton1 = new javax.swing.JButton();
        addProductPanel = new javax.swing.JPanel();
        titleLabel2 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        descriptionLabel2 = new javax.swing.JLabel();
        priceLabel2 = new javax.swing.JLabel();
        euroLabel2 = new javax.swing.JLabel();
        nameField2 = new javax.swing.JTextField();
        priceField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField2 = new javax.swing.JTextArea();
        saveButton2 = new javax.swing.JButton();
        cancelButton2 = new javax.swing.JButton();
        addInvoicePanel = new javax.swing.JPanel();
        titleLabel3 = new javax.swing.JLabel();
        dateLabel3 = new javax.swing.JLabel();
        customerLabel3 = new javax.swing.JLabel();
        signLabel3 = new javax.swing.JLabel();
        productLabel3 = new javax.swing.JLabel();
        countLabel3 = new javax.swing.JLabel();
        euroLabel3 = new javax.swing.JLabel();
        priceLabel3 = new javax.swing.JLabel();
        productComboBox3 = new javax.swing.JComboBox<>();
        customerComboBox3 = new javax.swing.JComboBox<>();
        dateField3 = new javax.swing.JTextField();
        countField3 = new javax.swing.JTextField();
        totalPriceField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        saveButton3 = new javax.swing.JButton();
        addButton3 = new javax.swing.JButton();
        cancelButton3 = new javax.swing.JButton();
        showInvoicesPanel = new javax.swing.JPanel();
        titleLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        showBtn = new javax.swing.JButton();
        editCustomerPanel = new javax.swing.JPanel();
        titleLabel4 = new javax.swing.JLabel();
        postcodeLabel4 = new javax.swing.JLabel();
        cityLabel4 = new javax.swing.JLabel();
        addressLabel4 = new javax.swing.JLabel();
        nameLabel4 = new javax.swing.JLabel();
        customerLabel4 = new javax.swing.JLabel();
        nameComboBox4 = new javax.swing.JComboBox<>();
        cityField4 = new javax.swing.JTextField();
        postcodeField4 = new javax.swing.JTextField();
        addressField4 = new javax.swing.JTextField();
        nameField4 = new javax.swing.JTextField();
        saveButton4 = new javax.swing.JButton();
        deleteButton4 = new javax.swing.JButton();
        cancelButton4 = new javax.swing.JButton();
        editProductPanel = new javax.swing.JPanel();
        nameLabel5 = new javax.swing.JLabel();
        descriptionLabel5 = new javax.swing.JLabel();
        priceLabel5 = new javax.swing.JLabel();
        titleLabel5 = new javax.swing.JLabel();
        productLabel5 = new javax.swing.JLabel();
        euroLabel5 = new javax.swing.JLabel();
        nameComboBox5 = new javax.swing.JComboBox<>();
        priceField5 = new javax.swing.JTextField();
        nameField5 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        descriptionField5 = new javax.swing.JTextArea();
        cancelButton5 = new javax.swing.JButton();
        saveButton5 = new javax.swing.JButton();
        deleteButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperFaktúra v2");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setBackground(new java.awt.Color(0, 51, 102));
        leftPanel.setPreferredSize(new java.awt.Dimension(300, 580));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(204, 204, 204));
        welcomeLabel.setText("Vitajte!");
        leftPanel.add(welcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        homeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeBtn.setText("Domov");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        leftPanel.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 230, 50));

        customerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerBtn.setText("Pridať zákazníka");
        customerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBtnActionPerformed(evt);
            }
        });
        leftPanel.add(customerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 50));

        productBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productBtn.setText("Pridať tovar");
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });
        leftPanel.add(productBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 230, 50));

        invoiceBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoiceBtn.setText("Pridať faktúru");
        invoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBtnActionPerformed(evt);
            }
        });
        leftPanel.add(invoiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 230, 50));

        showInvBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showInvBtn.setText("Zobraziť faktúry");
        showInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInvBtnActionPerformed(evt);
            }
        });
        leftPanel.add(showInvBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 230, 50));

        editCustBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editCustBtn.setText("Upraviť údaje zákazníkov");
        editCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustBtnActionPerformed(evt);
            }
        });
        leftPanel.add(editCustBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 230, 50));

        editProdBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editProdBtn.setText("Upraviť údaje o tovaroch");
        editProdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProdBtnActionPerformed(evt);
            }
        });
        leftPanel.add(editProdBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 230, 50));

        quitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quitBtn.setText("Ukončiť");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });
        leftPanel.add(quitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 230, 50));

        mainPanel.add(leftPanel, java.awt.BorderLayout.WEST);

        centerPanel.setBackground(new java.awt.Color(0, 51, 102));
        centerPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(0, 51, 102));
        homePanel.setPreferredSize(new java.awt.Dimension(620, 670));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.png"))); // NOI18N
        homePanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 650));

        centerPanel.add(homePanel, "card2");

        addCustomerPanel.setBackground(new java.awt.Color(0, 102, 153));
        addCustomerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel1.setText("Vyplňte informácie o zákazníkovi");
        addCustomerPanel.add(titleLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel1.setForeground(new java.awt.Color(204, 204, 204));
        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel1.setText("Meno a priezvisko:");
        addCustomerPanel.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 160, 40));

        addressLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel1.setForeground(new java.awt.Color(204, 204, 204));
        addressLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressLabel1.setText("Adresa:");
        addCustomerPanel.add(addressLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 40));

        cityLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cityLabel1.setForeground(new java.awt.Color(204, 204, 204));
        cityLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityLabel1.setText("Mesto:");
        addCustomerPanel.add(cityLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 40));

        postcodeLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        postcodeLabel1.setForeground(new java.awt.Color(204, 204, 204));
        postcodeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        postcodeLabel1.setText("PSČ:");
        addCustomerPanel.add(postcodeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 160, 40));

        nameField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addCustomerPanel.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 310, 40));

        addressField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addCustomerPanel.add(addressField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 310, 40));

        cityField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addCustomerPanel.add(cityField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 310, 40));

        postcodeField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addCustomerPanel.add(postcodeField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 310, 40));

        cancelButton1.setText("Zrušiť");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });
        addCustomerPanel.add(cancelButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 90, 40));

        saveButton1.setText("Uložiť");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });
        addCustomerPanel.add(saveButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, 40));

        centerPanel.add(addCustomerPanel, "card3");

        addProductPanel.setBackground(new java.awt.Color(0, 102, 153));
        addProductPanel.setPreferredSize(new java.awt.Dimension(610, 600));
        addProductPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel2.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel2.setText("Vyplňte údaje o tovare");
        addProductPanel.add(titleLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        nameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel2.setForeground(new java.awt.Color(204, 204, 204));
        nameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel2.setText("Názov:");
        addProductPanel.add(nameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 140, 40));

        descriptionLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionLabel2.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descriptionLabel2.setText("Popis tovaru:");
        addProductPanel.add(descriptionLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, 40));

        priceLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceLabel2.setForeground(new java.awt.Color(204, 204, 204));
        priceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel2.setText("Cena:");
        addProductPanel.add(priceLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 140, 40));

        euroLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        euroLabel2.setForeground(new java.awt.Color(204, 204, 204));
        euroLabel2.setText("€");
        addProductPanel.add(euroLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 30, 40));

        nameField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addProductPanel.add(nameField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 260, 40));

        priceField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addProductPanel.add(priceField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 230, 40));

        descriptionField2.setColumns(20);
        descriptionField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionField2.setRows(5);
        jScrollPane2.setViewportView(descriptionField2);

        addProductPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 260, 140));

        saveButton2.setText("Uložiť");
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });
        addProductPanel.add(saveButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, 40));

        cancelButton2.setText("Zrušiť");
        cancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton2ActionPerformed(evt);
            }
        });
        addProductPanel.add(cancelButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 90, 40));

        centerPanel.add(addProductPanel, "card5");

        addInvoicePanel.setBackground(new java.awt.Color(0, 102, 153));
        addInvoicePanel.setPreferredSize(new java.awt.Dimension(610, 600));
        addInvoicePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel3.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel3.setText("Vyplňte informácie o faktúre");
        addInvoicePanel.add(titleLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        dateLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateLabel3.setForeground(new java.awt.Color(204, 204, 204));
        dateLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateLabel3.setText("Dátum:");
        dateLabel3.setToolTipText("");
        addInvoicePanel.add(dateLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 60, 40));

        customerLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerLabel3.setForeground(new java.awt.Color(204, 204, 204));
        customerLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        customerLabel3.setText("Zákazník:");
        customerLabel3.setToolTipText("");
        addInvoicePanel.add(customerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, 40));

        signLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signLabel3.setForeground(new java.awt.Color(204, 204, 204));
        signLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        signLabel3.setText("ks");
        addInvoicePanel.add(signLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 30, 40));

        productLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productLabel3.setForeground(new java.awt.Color(204, 204, 204));
        productLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productLabel3.setText("Tovar:");
        addInvoicePanel.add(productLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 40));

        countLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        countLabel3.setForeground(new java.awt.Color(204, 204, 204));
        countLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countLabel3.setText("Počet:");
        addInvoicePanel.add(countLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 60, 40));

        euroLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        euroLabel3.setForeground(new java.awt.Color(204, 204, 204));
        euroLabel3.setText("€");
        addInvoicePanel.add(euroLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 30, 40));

        priceLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceLabel3.setForeground(new java.awt.Color(204, 204, 204));
        priceLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel3.setText("Celková suma:");
        addInvoicePanel.add(priceLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 120, 40));

        productComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addInvoicePanel.add(productComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 260, 40));

        customerComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addInvoicePanel.add(customerComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 260, 40));

        dateField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateField3.setToolTipText("DD-MM-RRRR");
        addInvoicePanel.add(dateField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 120, 40));

        countField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        countField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addInvoicePanel.add(countField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 60, 40));

        totalPriceField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPriceField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalPriceField3.setEnabled(false);
        addInvoicePanel.add(totalPriceField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 100, 40));

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Názov produktu", "Popis", "Počet kusov", "Cena (€)"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable3.setRowHeight(30);
        jScrollPane3.setViewportView(jTable3);

        addInvoicePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 540, 210));

        saveButton3.setText("Vystaviť");
        saveButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton3ActionPerformed(evt);
            }
        });
        addInvoicePanel.add(saveButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, 90, 40));

        addButton3.setText("Pridať");
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3ActionPerformed(evt);
            }
        });
        addInvoicePanel.add(addButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 90, 40));

        cancelButton3.setText("Zrušiť");
        cancelButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton3ActionPerformed(evt);
            }
        });
        addInvoicePanel.add(cancelButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 90, 40));

        centerPanel.add(addInvoicePanel, "card7");

        showInvoicesPanel.setBackground(new java.awt.Color(0, 102, 153));
        showInvoicesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel6.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel6.setText("Uložené faktúry");
        showInvoicesPanel.add(titleLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jTable6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meno zákazníka", "Dátum", "Celková cena (€)"
            }
        ));
        jTable6.setRowHeight(30);
        jScrollPane6.setViewportView(jTable6);

        showInvoicesPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 510, -1));

        showBtn.setText("Zobraziť");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });
        showInvoicesPanel.add(showBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 100, 40));

        centerPanel.add(showInvoicesPanel, "card8");

        editCustomerPanel.setBackground(new java.awt.Color(0, 102, 153));
        editCustomerPanel.setPreferredSize(new java.awt.Dimension(610, 600));
        editCustomerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel4.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel4.setText("Upravte informácie o zákazníkoch");
        editCustomerPanel.add(titleLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        postcodeLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        postcodeLabel4.setForeground(new java.awt.Color(204, 204, 204));
        postcodeLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        postcodeLabel4.setText("PSČ:");
        editCustomerPanel.add(postcodeLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 160, 40));

        cityLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cityLabel4.setForeground(new java.awt.Color(204, 204, 204));
        cityLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityLabel4.setText("Mesto:");
        editCustomerPanel.add(cityLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 40));

        addressLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel4.setForeground(new java.awt.Color(204, 204, 204));
        addressLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressLabel4.setText("Adresa:");
        editCustomerPanel.add(addressLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 160, 40));

        nameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel4.setForeground(new java.awt.Color(204, 204, 204));
        nameLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel4.setText("Meno a priezvisko:");
        editCustomerPanel.add(nameLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 160, 40));

        customerLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerLabel4.setForeground(new java.awt.Color(204, 204, 204));
        customerLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        customerLabel4.setText("Zákazník:");
        editCustomerPanel.add(customerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 100, 40));

        nameComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nameComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameComboBox4ActionPerformed(evt);
            }
        });
        editCustomerPanel.add(nameComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 310, 40));

        cityField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editCustomerPanel.add(cityField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 310, 40));

        postcodeField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editCustomerPanel.add(postcodeField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 310, 40));

        addressField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editCustomerPanel.add(addressField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 310, 40));

        nameField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editCustomerPanel.add(nameField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 310, 40));

        saveButton4.setText("Uložiť");
        saveButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton4ActionPerformed(evt);
            }
        });
        editCustomerPanel.add(saveButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, 40));

        deleteButton4.setText("Vymazať");
        deleteButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton4ActionPerformed(evt);
            }
        });
        editCustomerPanel.add(deleteButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 90, 40));

        cancelButton4.setText("Zrušiť");
        cancelButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton4ActionPerformed(evt);
            }
        });
        editCustomerPanel.add(cancelButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 90, 40));

        centerPanel.add(editCustomerPanel, "card4");

        editProductPanel.setBackground(new java.awt.Color(0, 102, 153));
        editProductPanel.setPreferredSize(new java.awt.Dimension(610, 600));
        editProductPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel5.setForeground(new java.awt.Color(204, 204, 204));
        nameLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel5.setText("Názov:");
        editProductPanel.add(nameLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 140, 40));

        descriptionLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionLabel5.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descriptionLabel5.setText("Popis tovaru:");
        editProductPanel.add(descriptionLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 140, 40));

        priceLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceLabel5.setForeground(new java.awt.Color(204, 204, 204));
        priceLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel5.setText("Cena:");
        editProductPanel.add(priceLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 140, 40));

        titleLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel5.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel5.setText("Upravte informácie o tovaroch");
        editProductPanel.add(titleLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        productLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productLabel5.setForeground(new java.awt.Color(204, 204, 204));
        productLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productLabel5.setText("Tovar:");
        editProductPanel.add(productLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 140, 40));

        euroLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        euroLabel5.setForeground(new java.awt.Color(204, 204, 204));
        euroLabel5.setText("€");
        editProductPanel.add(euroLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 30, 40));

        nameComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nameComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameComboBox5ActionPerformed(evt);
            }
        });
        editProductPanel.add(nameComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 260, 40));

        priceField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        priceField5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        editProductPanel.add(priceField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 230, 40));

        nameField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editProductPanel.add(nameField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 260, 40));

        descriptionField5.setColumns(20);
        descriptionField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionField5.setRows(5);
        jScrollPane5.setViewportView(descriptionField5);

        editProductPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 260, 130));

        cancelButton5.setText("Zrušiť");
        cancelButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton5ActionPerformed(evt);
            }
        });
        editProductPanel.add(cancelButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 90, 40));

        saveButton5.setText("Uložiť");
        saveButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton5ActionPerformed(evt);
            }
        });
        editProductPanel.add(saveButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 90, 40));

        deleteButton5.setText("Vymazať");
        deleteButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton5ActionPerformed(evt);
            }
        });
        editProductPanel.add(deleteButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 90, 40));

        centerPanel.add(editProductPanel, "card6");

        mainPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // go to home panel
    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        setToPanel(0);
    }//GEN-LAST:event_homeBtnActionPerformed

    // go to addCustomer panel
    private void customerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBtnActionPerformed
        setToPanel(1);
    }//GEN-LAST:event_customerBtnActionPerformed

    // go to addProduct panel
    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        setToPanel(2);
    }//GEN-LAST:event_productBtnActionPerformed

    // go to addInvoice panel
    private void invoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceBtnActionPerformed
        if (customers.size() < 1) {
            JOptionPane.showMessageDialog(null, "Nie sú uložené žiadne informácie o zákazníkoch!", "Chyba", JOptionPane.INFORMATION_MESSAGE);
        } else if (products.size() < 1) {
            JOptionPane.showMessageDialog(null, "Nie sú uložené žiadne informácie o tovaroch!", "Chyba", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setToPanel(3);
            populateCustomerArray(customerComboBox3);
            populateProductArray(productComboBox3);
        }
    }//GEN-LAST:event_invoiceBtnActionPerformed

    // go to editCustomer panel
    private void editCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustBtnActionPerformed
        if (customers.size() > 0) {
            setToPanel(4);
            populateCustomerArray(nameComboBox4);
        } else {
            JOptionPane.showMessageDialog(null, "Nie sú uložené žiadne informácie o zákazníkoch!", "Chyba", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editCustBtnActionPerformed

    // go to editProduct panel
    private void editProdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProdBtnActionPerformed
        if (products.size() > 0) {
            setToPanel(5);
            populateProductArray(nameComboBox5);
        } else {
            JOptionPane.showMessageDialog(null, "Nie sú uložené žiadne informácie o tovaroch!", "Chyba", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editProdBtnActionPerformed

    // exit application with confirmBox
    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        new ConfirmBox().setVisible(true);
    }//GEN-LAST:event_quitBtnActionPerformed

    // addCustomer - cancelButton
    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        clearAllFields();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    // addCustomer - saveButton
    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        if (nameField1.getText().isEmpty() || addressField1.getText().isEmpty()
                || cityField1.getText().isEmpty() || postcodeField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = nameField1.getText().trim();
            String address = addressField1.getText().trim();
            String city = cityField1.getText().trim();
            String postcode = postcodeField1.getText().trim();

            Customer customer = new Customer(name, address, city, postcode);
            customers.add(customer);

            JOptionPane.showMessageDialog(null, "Údaje boli úspešne uložené!");
            clearAllFields();
        }
    }//GEN-LAST:event_saveButton1ActionPerformed

    // addProduct - saveButton
    private void saveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton2ActionPerformed
        if (nameField2.getText().isEmpty() || priceField2.getText().isEmpty()
                || descriptionField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = nameField2.getText().trim();
            String description = descriptionField2.getText().trim();
            String priceStr = priceField2.getText().trim().replace(',', '.');

            try {
                double price = Double.parseDouble(priceStr);
                if (price < 0) {
                    throw new NumberFormatException();
                }
                Product product = new Product(name, description, price);
                products.add(product);

                JOptionPane.showMessageDialog(null, "Údaje boli úspešne uložené!");
                clearAllFields();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cena musí byť kladná číselná hodnota!", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveButton2ActionPerformed

    // addProduct - cancelButton
    private void cancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton2ActionPerformed
        clearAllFields();
    }//GEN-LAST:event_cancelButton2ActionPerformed

    // addInvoice - saveButton
    private void saveButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton3ActionPerformed
        if (dateField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte dátum!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else if (jTable3.getModel().getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Prosím vyberte aspoň jeden tovar!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            String dateStr = dateField3.getText().trim().replace('.', '-').replace('/', '-');
            try {
                Date date = dateFormatter.parse(dateStr);
                Customer customer = customers.get(customerComboBox3.getSelectedIndex());
                double total = Double.parseDouble(totalPriceField3.getText().replace(',', '.'));

                Invoice invoice = new Invoice(date, customer, productsList, countsList, total);
                invoices.add(invoice);

                JOptionPane.showMessageDialog(null, "Vaša faktúra bola úspešne uložená.");
                clearAllFields();

                String[] row = {customer.getFullName(), dateStr, priceFormatter.format(total)};
                DefaultTableModel tblModel = (DefaultTableModel) jTable6.getModel();
                tblModel.addRow(row);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Nesprávny formát dátumu!\nSprávny formát je: DD-MM-RRRR.", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveButton3ActionPerformed

    // addInvoice - addButton
    private void addButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3ActionPerformed
        if (countField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int count = Integer.parseInt(countField3.getText().trim());
                if (count < 0) {
                    throw new NumberFormatException();
                }
                Product product = products.get(productComboBox3.getSelectedIndex());
                double price = product.getPrice() * count;

                String[] row = {product.getName(), product.getDescription(), String.valueOf(count), priceFormatter.format(price)};
                DefaultTableModel tblModel = (DefaultTableModel) jTable3.getModel();
                tblModel.addRow(row);

                countsList.add(count);
                productsList.add(product);

                double total = Double.parseDouble(totalPriceField3.getText().replace(',', '.'));
                total += price;

                totalPriceField3.setText(priceFormatter.format(total));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Počet kusov musí byť kladné a celé číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        }
        countField3.setText("1");
    }//GEN-LAST:event_addButton3ActionPerformed

    // AddInvoice - cancelButton
    private void cancelButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton3ActionPerformed
        clearAllFields();
    }//GEN-LAST:event_cancelButton3ActionPerformed

    // editCustomer - customer ComboBox
    private void nameComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameComboBox4ActionPerformed
        int selectedIndex = nameComboBox4.getSelectedIndex();
        Customer customer = customers.get(selectedIndex);

        nameField4.setText(customer.getFullName());
        addressField4.setText(customer.getAddress());
        cityField4.setText(customer.getCity());
        postcodeField4.setText(customer.getPostcode());
    }//GEN-LAST:event_nameComboBox4ActionPerformed

    // editCustomer - saveButton
    private void saveButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton4ActionPerformed
        if (nameField4.getText().isEmpty() || addressField4.getText().isEmpty()
                || cityField4.getText().isEmpty() || postcodeField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie o zákazníkovi!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            int selectedIndex = nameComboBox4.getSelectedIndex();

            customers.get(selectedIndex).setFullName(nameField4.getText().trim());
            customers.get(selectedIndex).setAddress(addressField4.getText().trim());
            customers.get(selectedIndex).setCity(cityField4.getText().trim());
            customers.get(selectedIndex).setPostcode(postcodeField4.getText().trim());

            JOptionPane.showMessageDialog(null, "Zmeny boli úspešne uložené!");
            populateCustomerArray(nameComboBox4);
        }
    }//GEN-LAST:event_saveButton4ActionPerformed

    // editCustomer - deleteButton
    private void deleteButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton4ActionPerformed
        int selectedIndex = nameComboBox4.getSelectedIndex();
        customers.remove(selectedIndex);
        JOptionPane.showMessageDialog(null, "Údaje boli úspešne zmazané!");
        populateCustomerArray(nameComboBox4);
    }//GEN-LAST:event_deleteButton4ActionPerformed

    // editCustomer - cancelButton
    private void cancelButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton4ActionPerformed
        setToPanel(0);
    }//GEN-LAST:event_cancelButton4ActionPerformed

    // editProduct - product ComboBox
    private void nameComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameComboBox5ActionPerformed
        int selectedIndex = nameComboBox5.getSelectedIndex();
        Product product = products.get(selectedIndex);

        nameField5.setText(product.getName());
        descriptionField5.setText(product.getDescription());
        priceField5.setText(priceFormatter.format(product.getPrice()));
    }//GEN-LAST:event_nameComboBox5ActionPerformed

    // editProduct - cancelButton
    private void cancelButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton5ActionPerformed
        setToPanel(0);
    }//GEN-LAST:event_cancelButton5ActionPerformed

    // editProduct - saveButton
    private void saveButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton5ActionPerformed
        if (nameField5.getText().isEmpty() || priceField5.getText().isEmpty()
                || descriptionField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prosím vyplňte všetky informácie o tovare!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            String priceStr = priceField5.getText().trim().replace(',', '.');
            try {
                double price = Double.parseDouble(priceStr);
                if (price < 0) {
                    throw new NumberFormatException();
                }
                int selectedIndex = nameComboBox5.getSelectedIndex();

                products.get(selectedIndex).setName(nameField5.getText().trim());
                products.get(selectedIndex).setDescription(descriptionField5.getText().trim());
                products.get(selectedIndex).setPrice(price);

                JOptionPane.showMessageDialog(null, "Zmeny boli úspešne uložené!");
                populateProductArray(nameComboBox5);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cena musí byť kladná číselná hodnota!", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveButton5ActionPerformed

    // editProduct - deleteButton
    private void deleteButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton5ActionPerformed
        int selectedIndex = nameComboBox5.getSelectedIndex();
        products.remove(selectedIndex);
        JOptionPane.showMessageDialog(null, "Údaje boli úspešne zmazané!");
        populateProductArray(nameComboBox5);
    }//GEN-LAST:event_deleteButton5ActionPerformed

    // go to show saved invoices panel
    private void showInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInvBtnActionPerformed
        setToPanel(6);
    }//GEN-LAST:event_showInvBtnActionPerformed

    // show saved invoices - show button
    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        int selectedIndex = jTable6.getSelectedRow();
        if (selectedIndex > -1) {
            new FinalPaper(invoices.get(selectedIndex).toString(priceFormatter, dateFormatter)).setVisible(true);
        }
    }//GEN-LAST:event_showBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton3;
    private javax.swing.JPanel addCustomerPanel;
    private javax.swing.JPanel addInvoicePanel;
    private javax.swing.JPanel addProductPanel;
    private javax.swing.JTextField addressField1;
    private javax.swing.JTextField addressField4;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JLabel addressLabel4;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelButton2;
    private javax.swing.JButton cancelButton3;
    private javax.swing.JButton cancelButton4;
    private javax.swing.JButton cancelButton5;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JTextField cityField1;
    private javax.swing.JTextField cityField4;
    private javax.swing.JLabel cityLabel1;
    private javax.swing.JLabel cityLabel4;
    private javax.swing.JTextField countField3;
    private javax.swing.JLabel countLabel3;
    private javax.swing.JButton customerBtn;
    private javax.swing.JComboBox<String> customerComboBox3;
    private javax.swing.JLabel customerLabel3;
    private javax.swing.JLabel customerLabel4;
    private javax.swing.JTextField dateField3;
    private javax.swing.JLabel dateLabel3;
    private javax.swing.JButton deleteButton4;
    private javax.swing.JButton deleteButton5;
    private javax.swing.JTextArea descriptionField2;
    private javax.swing.JTextArea descriptionField5;
    private javax.swing.JLabel descriptionLabel2;
    private javax.swing.JLabel descriptionLabel5;
    private javax.swing.JButton editCustBtn;
    private javax.swing.JPanel editCustomerPanel;
    private javax.swing.JButton editProdBtn;
    private javax.swing.JPanel editProductPanel;
    private javax.swing.JLabel euroLabel2;
    private javax.swing.JLabel euroLabel3;
    private javax.swing.JLabel euroLabel5;
    private javax.swing.JButton homeBtn;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton invoiceBtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable6;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JComboBox<String> nameComboBox4;
    private javax.swing.JComboBox<String> nameComboBox5;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField nameField2;
    private javax.swing.JTextField nameField4;
    private javax.swing.JTextField nameField5;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel5;
    private javax.swing.JTextField postcodeField1;
    private javax.swing.JTextField postcodeField4;
    private javax.swing.JLabel postcodeLabel1;
    private javax.swing.JLabel postcodeLabel4;
    private javax.swing.JTextField priceField2;
    private javax.swing.JTextField priceField5;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel priceLabel3;
    private javax.swing.JLabel priceLabel5;
    private javax.swing.JButton productBtn;
    private javax.swing.JComboBox<String> productComboBox3;
    private javax.swing.JLabel productLabel3;
    private javax.swing.JLabel productLabel5;
    private javax.swing.JButton quitBtn;
    private javax.swing.JButton saveButton1;
    private javax.swing.JButton saveButton2;
    private javax.swing.JButton saveButton3;
    private javax.swing.JButton saveButton4;
    private javax.swing.JButton saveButton5;
    private javax.swing.JButton showBtn;
    private javax.swing.JButton showInvBtn;
    private javax.swing.JPanel showInvoicesPanel;
    private javax.swing.JLabel signLabel3;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel titleLabel2;
    private javax.swing.JLabel titleLabel3;
    private javax.swing.JLabel titleLabel4;
    private javax.swing.JLabel titleLabel5;
    private javax.swing.JLabel titleLabel6;
    private javax.swing.JTextField totalPriceField3;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
