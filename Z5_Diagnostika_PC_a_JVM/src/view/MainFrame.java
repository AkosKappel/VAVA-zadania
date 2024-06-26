package view;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 *
 * @author kappe
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    private void switchPanel(int panelId) {
        homePanel.setVisible(false);
        diagnosticsPanel.setVisible(false);

        switch (panelId) {
            case 1:
                homePanel.setVisible(true);
                break;
            case 2:
                diagnosticsPanel.setVisible(true);
                break;
        }
    }

    private void performDiagnostics() {
        String OS_NAME = System.getProperty("os.name");
        String OS_ARCH = System.getProperty("os.arch");
        String OS_VERSION = System.getProperty("os.version");
        String USER_NAME = System.getProperty("user.name");
        String JAVA_VERSION = System.getProperty("java.version");
        Path USER_DIR = Path.of(System.getProperty("user.dir"));

        long USER_DIR_SIZE;
        try {
            USER_DIR_SIZE = Files.size(Path.of(USER_DIR.toString()));
        } catch (IOException e) {
            USER_DIR_SIZE = 0;
        }
        long MAX_MEMORY = Runtime.getRuntime().maxMemory();
        long TOTAL_MEMORY = Runtime.getRuntime().totalMemory();
        long FREE_MEMORY = Runtime.getRuntime().freeMemory();

        osNameValueLbl.setText(OS_NAME);
        osArchValueLbl.setText(OS_ARCH);
        osVersionValueLbl.setText(OS_VERSION);
        userNameValueLbl.setText(USER_NAME);
        javaVersionValueLbl.setText(JAVA_VERSION);
        userDirValueLbl.setText(USER_DIR.getFileName().toString());

        userDirSizeValueLbl.setText(USER_DIR_SIZE + " B");
        maxMemoryValueLbl.setText(MAX_MEMORY + " B");
        totalMemoryValueLbl.setText(TOTAL_MEMORY + " B");
        freeMemoryValueLbl.setText(FREE_MEMORY + " B");
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
        homePanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        authorLbl = new javax.swing.JLabel();
        homeTitleLbl = new javax.swing.JLabel();
        diagnosticsPanel = new javax.swing.JPanel();
        diagnosticsTitleLbl = new javax.swing.JLabel();
        exportBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        osNameLbl = new javax.swing.JLabel();
        osArchLbl = new javax.swing.JLabel();
        osVersionLbl = new javax.swing.JLabel();
        userDirLbl = new javax.swing.JLabel();
        userDirSizeLbl = new javax.swing.JLabel();
        userNameLbl = new javax.swing.JLabel();
        freeMemoryLbl = new javax.swing.JLabel();
        totalMemoryLbl = new javax.swing.JLabel();
        maxMemoryLbl = new javax.swing.JLabel();
        javaVersionLbl = new javax.swing.JLabel();
        osNameValueLbl = new javax.swing.JLabel();
        osArchValueLbl = new javax.swing.JLabel();
        osVersionValueLbl = new javax.swing.JLabel();
        userDirValueLbl = new javax.swing.JLabel();
        userDirSizeValueLbl = new javax.swing.JLabel();
        userNameValueLbl = new javax.swing.JLabel();
        freeMemoryValueLbl = new javax.swing.JLabel();
        totalMemoryValueLbl = new javax.swing.JLabel();
        maxMemoryValueLbl = new javax.swing.JLabel();
        javaVersionValueLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PC & JVM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 204, 204));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startBtn.setBackground(new java.awt.Color(255, 51, 51));
        startBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startBtn.setText("Diagnostikovať");
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startBtnMouseReleased(evt);
            }
        });
        homePanel.add(startBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 140, 40));

        authorLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        authorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLbl.setText("created by Ákos Kappel");
        homePanel.add(authorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 620, 30));

        homeTitleLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        homeTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTitleLbl.setText("Diagnostika PC a JVM");
        homePanel.add(homeTitleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 620, 60));

        mainPanel.add(homePanel, "card2");

        diagnosticsPanel.setBackground(new java.awt.Color(255, 204, 204));
        diagnosticsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diagnosticsTitleLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        diagnosticsTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagnosticsTitleLbl.setText("Diagnostika PC a JVM");
        diagnosticsPanel.add(diagnosticsTitleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 620, 60));

        exportBtn.setBackground(new java.awt.Color(255, 51, 51));
        exportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exportBtn.setText("Exportovať údaje");
        exportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exportBtnMouseReleased(evt);
            }
        });
        diagnosticsPanel.add(exportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 150, 40));

        backBtn.setBackground(new java.awt.Color(255, 51, 51));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setText("Späť");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnMouseReleased(evt);
            }
        });
        diagnosticsPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 150, 40));

        osNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        osNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        osNameLbl.setText("Meno OS:");
        diagnosticsPanel.add(osNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, -1));

        osArchLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        osArchLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        osArchLbl.setText("Architektúra:");
        diagnosticsPanel.add(osArchLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, -1));

        osVersionLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        osVersionLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        osVersionLbl.setText("Verzia OS:");
        diagnosticsPanel.add(osVersionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, -1));

        userDirLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userDirLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userDirLbl.setText("Názov adresára:");
        diagnosticsPanel.add(userDirLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 290, -1));

        userDirSizeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userDirSizeLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userDirSizeLbl.setText("Veľkosť adresára:");
        diagnosticsPanel.add(userDirSizeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 290, -1));

        userNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userNameLbl.setText("Meno používateľa:");
        diagnosticsPanel.add(userNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 290, -1));

        freeMemoryLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        freeMemoryLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        freeMemoryLbl.setText("Voľná pamäť pre JVM:");
        diagnosticsPanel.add(freeMemoryLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 290, -1));

        totalMemoryLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalMemoryLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalMemoryLbl.setText("Dostupná pamäť pre JVM:");
        diagnosticsPanel.add(totalMemoryLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 290, -1));

        maxMemoryLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maxMemoryLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        maxMemoryLbl.setText("Celková pamäť pre JVM:");
        diagnosticsPanel.add(maxMemoryLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 290, -1));

        javaVersionLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        javaVersionLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        javaVersionLbl.setText("Java verzia:");
        diagnosticsPanel.add(javaVersionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, -1));

        osNameValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        osNameValueLbl.setText("Meno OS:");
        diagnosticsPanel.add(osNameValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 280, -1));

        osArchValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        osArchValueLbl.setText("Architektúra:");
        diagnosticsPanel.add(osArchValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 280, -1));

        osVersionValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        osVersionValueLbl.setText("Verzia OS:");
        diagnosticsPanel.add(osVersionValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 280, -1));

        userDirValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userDirValueLbl.setText("Názov adresára:");
        diagnosticsPanel.add(userDirValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 280, -1));

        userDirSizeValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userDirSizeValueLbl.setText("Veľkosť adresára:");
        diagnosticsPanel.add(userDirSizeValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 280, -1));

        userNameValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userNameValueLbl.setText("Meno používateľa:");
        diagnosticsPanel.add(userNameValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 280, -1));

        freeMemoryValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        freeMemoryValueLbl.setText("Voľná pamäť pre JVM:");
        diagnosticsPanel.add(freeMemoryValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 280, -1));

        totalMemoryValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalMemoryValueLbl.setText("Dostupná pamäť pre JVM:");
        diagnosticsPanel.add(totalMemoryValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 280, -1));

        maxMemoryValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maxMemoryValueLbl.setText("Celková pamäť pre JVM:");
        diagnosticsPanel.add(maxMemoryValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 280, -1));

        javaVersionValueLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        javaVersionValueLbl.setText("Java verzia:");
        diagnosticsPanel.add(javaVersionValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 280, -1));

        mainPanel.add(diagnosticsPanel, "card3");

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseReleased
        performDiagnostics();
        switchPanel(2);
    }//GEN-LAST:event_startBtnMouseReleased

    private void backBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseReleased
        switchPanel(1);
    }//GEN-LAST:event_backBtnMouseReleased

    private void exportBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBtnMouseReleased
        LocalDateTime now = java.time.LocalDateTime.now();
        String filename = "diagnostics-" + now.toString().substring(0, 20).replace(":", "-") + "txt";

        try {
            FileWriter writer = new FileWriter(filename);

            writer.write(diagnosticsTitleLbl.getText() + "\n");
            writer.write("Datum: " + now.toString() + "\n\n");
            writer.write(osNameLbl.getText() + " " + osNameValueLbl.getText() + "\n");
            writer.write(osArchLbl.getText() + " " + osArchValueLbl.getText() + "\n");
            writer.write(osVersionLbl.getText() + " " + osVersionValueLbl.getText() + "\n");
            writer.write(userNameLbl.getText() + " " + userNameValueLbl.getText() + "\n");
            writer.write(userDirLbl.getText() + " " + userDirValueLbl.getText() + "\n");
            writer.write(userDirSizeLbl.getText() + " " + userDirSizeValueLbl.getText() + "\n");
            writer.write(javaVersionLbl.getText() + " " + javaVersionValueLbl.getText() + "\n");
            writer.write(maxMemoryLbl.getText() + " " + maxMemoryValueLbl.getText() + "\n");
            writer.write(totalMemoryLbl.getText() + " " + totalMemoryValueLbl.getText() + "\n");
            writer.write(freeMemoryLbl.getText() + " " + freeMemoryValueLbl.getText() + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
        }
    }//GEN-LAST:event_exportBtnMouseReleased

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel diagnosticsPanel;
    private javax.swing.JLabel diagnosticsTitleLbl;
    private javax.swing.JButton exportBtn;
    private javax.swing.JLabel freeMemoryLbl;
    private javax.swing.JLabel freeMemoryValueLbl;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homeTitleLbl;
    private javax.swing.JLabel javaVersionLbl;
    private javax.swing.JLabel javaVersionValueLbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel maxMemoryLbl;
    private javax.swing.JLabel maxMemoryValueLbl;
    private javax.swing.JLabel osArchLbl;
    private javax.swing.JLabel osArchValueLbl;
    private javax.swing.JLabel osNameLbl;
    private javax.swing.JLabel osNameValueLbl;
    private javax.swing.JLabel osVersionLbl;
    private javax.swing.JLabel osVersionValueLbl;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel totalMemoryLbl;
    private javax.swing.JLabel totalMemoryValueLbl;
    private javax.swing.JLabel userDirLbl;
    private javax.swing.JLabel userDirSizeLbl;
    private javax.swing.JLabel userDirSizeValueLbl;
    private javax.swing.JLabel userDirValueLbl;
    private javax.swing.JLabel userNameLbl;
    private javax.swing.JLabel userNameValueLbl;
    // End of variables declaration//GEN-END:variables
}
