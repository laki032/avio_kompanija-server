package gui;

import java.util.Map;
import javax.swing.JOptionPane;
import pl.Kontroler;

/**
 *
 * @author Lazar Vujadinovic
 */
public class IzmenaBaze extends javax.swing.JDialog {

    /**
     * Creates new form IzmenaBaze
     */
    public IzmenaBaze(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popuniCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBaza = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtURL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDriver = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtSacuvaj = new javax.swing.JButton();
        jtxtUser = new javax.swing.JTextField();
        jComboBaza = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Username: ");

        jLabel5.setText("Driver: ");

        jLabel2.setText("URL: ");

        jLabel1.setText("Izaberi bazu: ");

        jbtSacuvaj.setText("Promeni bazu");
        jbtSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSacuvajActionPerformed(evt);
            }
        });

        jComboBaza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBazaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Password: ");

        javax.swing.GroupLayout jPanelBazaLayout = new javax.swing.GroupLayout(jPanelBaza);
        jPanelBaza.setLayout(jPanelBazaLayout);
        jPanelBazaLayout.setHorizontalGroup(
            jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBazaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBaza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtURL)
                    .addComponent(jtxtUser)
                    .addComponent(jtxtPass)
                    .addComponent(jtxtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBazaLayout.setVerticalGroup(
            jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBazaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtSacuvaj)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSacuvajActionPerformed
        String b = (String) jComboBaza.getSelectedItem();
        if (b.equals("Access")) {
            try {
                postaviNovuBazu("access");
                JOptionPane.showMessageDialog(this, "Postavljena je nova baza!", "Access", JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (b.equals("MySQL")) {
            try {
                postaviNovuBazu("mysql");
                JOptionPane.showMessageDialog(this, "Postavljena je nova baza!", "MySQL", JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        }
        String url = jtxtURL.getText().trim();
        String user = jtxtUser.getText().trim();
        String pass = jtxtPass.getText().trim();
        String driver = jtxtDriver.getText().trim();
        try {
            postaviNovuBazu(url, user, pass, driver);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
        String poruka = "Postavljena je nova baza!\nurl: " + url + "\nuser: " + user + "\npass: " + pass + "driver: " + driver;
        JOptionPane.showMessageDialog(this, poruka, "Nova baza", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbtSacuvajActionPerformed

    private void jComboBazaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBazaItemStateChanged
        String b = jComboBaza.getSelectedItem().toString();
        Map<String, Object> m;
        switch (b) {
            case "Access":
                postaviPodatke("access");
                break;
            case "MySQL":
                postaviPodatke("mysql");
                break;
            case "Nova baza":
                jtxtDriver.setText("");
                jtxtPass.setText("");
                jtxtURL.setText("");
                jtxtUser.setText("");
                jtxtDriver.setEditable(true);
                jtxtPass.setEditable(true);
                jtxtURL.setEditable(true);
                jtxtUser.setEditable(true);
                break;
        }
    }//GEN-LAST:event_jComboBazaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBaza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelBaza;
    private javax.swing.JButton jbtSacuvaj;
    private javax.swing.JTextField jtxtDriver;
    private javax.swing.JTextField jtxtPass;
    private javax.swing.JTextField jtxtURL;
    private javax.swing.JTextField jtxtUser;
    // End of variables declaration//GEN-END:variables

    private void popuniCombo() {
        jComboBaza.addItem("Access");
        jComboBaza.addItem("MySQL");
        jComboBaza.addItem("Nova baza");
    }

    private void postaviNovuBazu(String imeBaze) throws Exception {
        Kontroler.getINSTANCE().promeniBazu(imeBaze);
    }

    private void postaviNovuBazu(String url, String user, String pass, String driver) throws Exception {
        Kontroler.getINSTANCE().novaBaza(url, user, pass, driver);
    }

    private void postaviPodatke(String baza) {
        Map<String, Object> m = Kontroler.getINSTANCE().vratiPodatkeOBazi(baza);
        jtxtDriver.setText(m.get("driver").toString());
        jtxtPass.setText(m.get("pass").toString());
        jtxtURL.setText(m.get("url").toString());
        jtxtUser.setText(m.get("user").toString());
        jtxtDriver.setEditable(false);
        jtxtPass.setEditable(false);
        jtxtURL.setEditable(false);
        jtxtUser.setEditable(false);
    }
}
