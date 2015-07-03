package gui;

import pl.Kontroler;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import thread.NitSat;
import thread.NitServer;

/**
 *
 * @author Lazar Vujadinovic
 */
public class ServerskaForma extends javax.swing.JFrame {

    public ServerskaForma() {
        initComponents();
        srediFormu();
        sdf = new SimpleDateFormat("H:mm:ss");
    }

    private final SimpleDateFormat sdf;

    public void pristigaoZahtev(String zahtev) {
        jtxtAreaZahtevi.append("<" + sdf.format(new Date()) + "> " + zahtev + "\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtPokreniServer = new javax.swing.JButton();
        jlblBrPorta = new javax.swing.JLabel();
        jtxtPort = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAreaZahtevi = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlblVreme = new javax.swing.JLabel();
        jlblDatum = new javax.swing.JLabel();
        jbtPromenaBaze = new javax.swing.JButton();
        jbtPregledKorisnika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jbtPokreniServer.setText("Pokreni server");
        jbtPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPokreniServerActionPerformed(evt);
            }
        });

        jlblBrPorta.setText("Broj porta:");

        jtxtPort.setText(" ");

        jtxtAreaZahtevi.setColumns(20);
        jtxtAreaZahtevi.setRows(5);
        jtxtAreaZahtevi.setBorder(javax.swing.BorderFactory.createTitledBorder("Zahtevi:"));
        jScrollPane1.setViewportView(jtxtAreaZahtevi);

        jLabel3.setText("Vreme:");

        jLabel4.setText("Datum:");

        jlblVreme.setText(" ");

        jlblDatum.setText(" ");

        jbtPromenaBaze.setText("Promena baze");
        jbtPromenaBaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPromenaBazeActionPerformed(evt);
            }
        });

        jbtPregledKorisnika.setText("Pregled korisnika");
        jbtPregledKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPregledKorisnikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblBrPorta)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtPort))
                            .addComponent(jbtPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(jlblVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtPromenaBaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jlblDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jbtPregledKorisnika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblBrPorta)
                    .addComponent(jtxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtPromenaBaze)
                    .addComponent(jbtPregledKorisnika))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDatum)
                    .addComponent(jLabel3)
                    .addComponent(jlblVreme)
                    .addComponent(jLabel4)
                    .addComponent(jbtPokreniServer))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPokreniServerActionPerformed
        String brojPorta = jtxtPort.getText().trim();
        if (brojPorta.isEmpty()) {
            brojPorta = "9000";
            jtxtPort.setText("9000");
        }
        if (!brojPorta.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Broj porta pogresno unet", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            nitServer = new NitServer(brojPorta);
            nitServer.start();
            jbtPokreniServer.setEnabled(false);
            jbtPregledKorisnika.setEnabled(true);
            jbtPromenaBaze.setEnabled(false);
            jlblBrPorta.setEnabled(false);
            jtxtPort.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtPokreniServerActionPerformed

    private NitServer nitServer;

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (nitServer != null) {
            nitServer.interrupt();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jbtPregledKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPregledKorisnikaActionPerformed
        PregledKorisnika pk = new PregledKorisnika(this, true);
        pk.setVisible(true);
    }//GEN-LAST:event_jbtPregledKorisnikaActionPerformed

    private void jbtPromenaBazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPromenaBazeActionPerformed
        IzmenaBaze ib = new IzmenaBaze(this, true);
        ib.setVisible(true);
    }//GEN-LAST:event_jbtPromenaBazeActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtPokreniServer;
    private javax.swing.JButton jbtPregledKorisnika;
    private javax.swing.JButton jbtPromenaBaze;
    private javax.swing.JLabel jlblBrPorta;
    private javax.swing.JLabel jlblDatum;
    private javax.swing.JLabel jlblVreme;
    private javax.swing.JTextArea jtxtAreaZahtevi;
    private javax.swing.JTextField jtxtPort;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        setTitle("Server avio kompanije");
        jlblDatum.setText(new SimpleDateFormat("d.M.yyyy.").format(new Date()));
        jbtPregledKorisnika.setEnabled(false);
        Thread nit = new Thread(new NitSat(jlblVreme));
        nit.start();
        Kontroler.getINSTANCE().staviUMapu("forma", this);
    }

}
