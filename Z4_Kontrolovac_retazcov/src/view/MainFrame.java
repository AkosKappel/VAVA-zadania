package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Akos Kappel
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        switchPanel(1);
    }

    private void switchPanel(int panelId) {
        homePanel.setVisible(false);
        regexPanel.setVisible(false);

        switch (panelId) {
            case 1:
                homePanel.setVisible(true);
                break;
            case 2:
                regexPanel.setVisible(true);
                break;
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
        homePanel = new javax.swing.JPanel();
        homeTitleLbl = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        authorLbl = new javax.swing.JLabel();
        regexPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sampleTextArea = new javax.swing.JTextArea();
        patternFld = new javax.swing.JTextField();
        titleLbl = new javax.swing.JLabel();
        sampleTextLbl = new javax.swing.JLabel();
        regexLbl = new javax.swing.JLabel();
        matchBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        caseSensitiveCheckBox = new javax.swing.JCheckBox();
        cheatSheetLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Checker");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(204, 204, 255));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeTitleLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        homeTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTitleLbl.setText("Kontrolovač reťazcov");
        homePanel.add(homeTitleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 640, 60));

        startBtn.setBackground(new java.awt.Color(102, 102, 255));
        startBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startBtn.setText("Štart");
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startBtnMouseReleased(evt);
            }
        });
        homePanel.add(startBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 140, 40));

        authorLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        authorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLbl.setText("created by Ákos Kappel");
        homePanel.add(authorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 640, 30));

        mainPanel.add(homePanel, "card3");

        regexPanel.setBackground(new java.awt.Color(204, 204, 255));
        regexPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sampleTextArea.setColumns(20);
        sampleTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sampleTextArea.setRows(5);
        jScrollPane1.setViewportView(sampleTextArea);

        regexPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 320, 140));

        patternFld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regexPanel.add(patternFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 320, 30));

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Kontrolovač reťazcov");
        regexPanel.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 640, 60));

        sampleTextLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sampleTextLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sampleTextLbl.setText("Text na prehľadávanie");
        regexPanel.add(sampleTextLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 160, 30));

        regexLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regexLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        regexLbl.setText("Regulárny výraz");
        regexPanel.add(regexLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 160, 30));

        matchBtn.setBackground(new java.awt.Color(102, 102, 255));
        matchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        matchBtn.setText("Skontrolovať");
        matchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                matchBtnMouseReleased(evt);
            }
        });
        regexPanel.add(matchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 120, 40));

        clearBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearBtn.setText("Vyčistiť polia");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clearBtnMouseReleased(evt);
            }
        });
        regexPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 120, 40));

        caseSensitiveCheckBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        caseSensitiveCheckBox.setText("rozlišovať veľké a malé písmená");
        regexPanel.add(caseSensitiveCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 320, 30));

        cheatSheetLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cheatSheetLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cheatSheetLbl.setText("<html><p><u>Cheat sheet</u></p></html>");
        cheatSheetLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cheatSheetLblMouseReleased(evt);
            }
        });
        regexPanel.add(cheatSheetLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 80, 20));

        backBtn.setBackground(new java.awt.Color(102, 102, 255));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setText("Späť");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnMouseReleased(evt);
            }
        });
        regexPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 120, 40));

        mainPanel.add(regexPanel, "card2");

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void matchBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matchBtnMouseReleased
        String regex = patternFld.getText();
        String sample = sampleTextArea.getText();

        int flags = 0;

        if (!caseSensitiveCheckBox.isSelected()) {
            flags |= Pattern.CASE_INSENSITIVE;
        }

        try {
            Pattern pattern = Pattern.compile(regex, flags);
            Matcher matcher = pattern.matcher(sample);

            if (matcher.find()) {
                JOptionPane.showMessageDialog(null, "OK", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "NG", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PatternSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Nesprávny regulárny výraz.", "Chyba", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_matchBtnMouseReleased

    private void clearBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseReleased
        patternFld.setText("");
        sampleTextArea.setText("");
    }//GEN-LAST:event_clearBtnMouseReleased

    private void cheatSheetLblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cheatSheetLblMouseReleased
        new CheatSheetFrame().setVisible(true);
    }//GEN-LAST:event_cheatSheetLblMouseReleased

    private void startBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseReleased
        sampleTextArea.setText("");
        patternFld.setText("");
        caseSensitiveCheckBox.setSelected(false);

        switchPanel(2);
    }//GEN-LAST:event_startBtnMouseReleased

    private void backBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseReleased
        switchPanel(1);
    }//GEN-LAST:event_backBtnMouseReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JCheckBox caseSensitiveCheckBox;
    private javax.swing.JLabel cheatSheetLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homeTitleLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton matchBtn;
    private javax.swing.JTextField patternFld;
    private javax.swing.JLabel regexLbl;
    private javax.swing.JPanel regexPanel;
    private javax.swing.JTextArea sampleTextArea;
    private javax.swing.JLabel sampleTextLbl;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
