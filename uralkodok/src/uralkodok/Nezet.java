package uralkodok;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bor Balint
 */
public class Nezet extends javax.swing.JFrame {

    static ArrayList<Uralkodo> uralkodok = beolvas("uralkodok.csv");
    static DefaultListModel<String> uralkodokNev = feltolt(uralkodok);

    public Nezet() {
        initComponents();
        lista.setModel(uralkodokNev);
    }
    static DefaultListModel<String> feltolt(ArrayList<Uralkodo> uralkodok){
        DefaultListModel<String> uralkodokNev = new DefaultListModel<>();
        for (Uralkodo uralkodo : uralkodok) {
            uralkodokNev.addElement(uralkodo.getNev());   
        }
        return uralkodokNev;
    }
    static String uralkodasiIdo(String uralkodoNev, ArrayList<Uralkodo> uralkodok) {
        String uralkodasiIdo = "";
        for (Uralkodo uralkodo : uralkodok) {
            int urK = uralkodo.getUralkodasKezdete();
            int urV = uralkodo.getUralkodasVege();
            //System.out.println(urK+" "+urV);

            if (uralkodo.getNev().equals(uralkodoNev)) {
                if ((urK != 0) && (urV != 0)) {
                    uralkodasiIdo = "" + (uralkodo.getUralkodasVege() - uralkodo.getUralkodasKezdete());
                } else {
                    return "Nem állapitható meg";
                }

            }
        }

        return uralkodasiIdo;
    }

    static ArrayList<Uralkodo> beolvas(String nev) {
        ArrayList<Uralkodo> uralkodok = new ArrayList<>();
        try {
            RandomAccessFile be = new RandomAccessFile(nev, "r");
            be.readLine(); //sor eldobás
            for (String sor = be.readLine(); sor != null; sor = be.readLine()) {
                uralkodok.add(new Uralkodo(sor));
                
            }
        } catch (IOException e) {
            System.out.println("Hiba: " + e);
        }

        return uralkodok;
    }

    static int koronazasokSzama(String telepules, ArrayList<Uralkodo> uralkodok) {
        int szamlalo = 0;
        for (Uralkodo uralkodo : uralkodok) {
            if (!uralkodo.getKoronazasHely().isEmpty()) {
                if (uralkodo.getKoronazasHely().equals(telepules)) {
                    szamlalo++;
                }
            }
        }
        return szamlalo;
    }
    
    static void hozzaad(String sor){
        if(!sor.equals("") && !uralkodokNev.contains(sor.split(";")[2])){
            uralkodok.add(new Uralkodo(sor));
            uralkodokNev.addElement(sor.split(";")[2]);
        }
        else{
            JOptionPane.showMessageDialog(null, "Üres mező vagy már tartalmazza a lista a nevet!", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        telepulesMezo = new javax.swing.JTextField();
        elofordulasGomb = new javax.swing.JButton();
        kilepes = new javax.swing.JButton();
        cimke = new javax.swing.JLabel();
        cimke1 = new javax.swing.JLabel();
        koronazasSzam = new javax.swing.JLabel();
        uralkodas = new javax.swing.JLabel();
        ujUralkod = new javax.swing.JTextField();
        hozzaad = new javax.swing.JButton();
        torles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Magyar uralkodók");

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        elofordulasGomb.setText("Előfordulás");
        elofordulasGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elofordulasGombActionPerformed(evt);
            }
        });

        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });

        cimke.setText("Adj meg egy település!");

        cimke1.setText("Koronázások száma: ");

        koronazasSzam.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        koronazasSzam.setForeground(new java.awt.Color(0, 204, 51));

        hozzaad.setText("Hozzáad");
        hozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hozzaadActionPerformed(evt);
            }
        });

        torles.setText("Törlés");
        torles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torlesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kilepes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(uralkodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cimke1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(koronazasSzam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(telepulesMezo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(elofordulasGomb, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                    .addComponent(cimke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hozzaad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ujUralkod)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(torles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cimke)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telepulesMezo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elofordulasGomb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cimke1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(koronazasSzam, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(uralkodas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ujUralkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hozzaad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(torles))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(kilepes)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_kilepesActionPerformed

    private void elofordulasGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elofordulasGombActionPerformed
        if (!telepulesMezo.getText().isEmpty()) {
            koronazasSzam.setText(telepulesMezo.getText()+" " + koronazasokSzama(telepulesMezo.getText(), uralkodok) );
            telepulesMezo.setText("");
        }else{
        JOptionPane.showMessageDialog(null, "Üres mező!", "Hiba", JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_elofordulasGombActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        uralkodas.setText("Uralkodási ideje: " + uralkodasiIdo(lista.getSelectedValue(), uralkodok)+ " év");
    }//GEN-LAST:event_listaValueChanged

    private void hozzaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hozzaadActionPerformed
        hozzaad(ujUralkod.getText());
        ujUralkod.setText("");
    }//GEN-LAST:event_hozzaadActionPerformed

    private void torlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torlesActionPerformed
        int index = lista.getSelectedIndex();
        //System.out.println(index);
        if(index != -1){
        uralkodokNev.remove(index);
        uralkodok.remove(uralkodok.get(index));}
    }//GEN-LAST:event_torlesActionPerformed

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
            java.util.logging.Logger.getLogger(Nezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nezet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cimke;
    private javax.swing.JLabel cimke1;
    private javax.swing.JButton elofordulasGomb;
    private javax.swing.JButton hozzaad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kilepes;
    private javax.swing.JLabel koronazasSzam;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField telepulesMezo;
    private javax.swing.JButton torles;
    private javax.swing.JTextField ujUralkod;
    private javax.swing.JLabel uralkodas;
    // End of variables declaration//GEN-END:variables
}
