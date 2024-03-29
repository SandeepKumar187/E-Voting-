/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luqmaan
 */
public class Results extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Results() {
        initComponents();
        
        DefaultTableModel model1 = (DefaultTableModel) headBoy.getModel();
        DefaultTableModel model2 = (DefaultTableModel) headGirl.getModel();
        DefaultTableModel model3 = (DefaultTableModel) cultural.getModel();
        DefaultTableModel model4 = (DefaultTableModel) sports.getModel();

        try {
            
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furqaan", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs;

            String query;

            query = "select *from headboy order by (count) desc;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString(1);
                int count = rs.getInt(2);

                model1.addRow(new Object[]{name, count});
            }

            query = "select *from headgirl order by (count) desc;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString(1);
                int count = rs.getInt(2);

                model2.addRow(new Object[]{name, count});
            }

            query = "select *from cultural order by (count) desc;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString(1);
                int count = rs.getInt(2);

                model3.addRow(new Object[]{name, count});
            }

            query = "select *from sports order by (count) desc;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString(1);
                int count = rs.getInt(2);

                model4.addRow(new Object[]{name, count});
            }
            
            con.close();
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        headBoy = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        headGirl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        cultural = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sports = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logo.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(280, 10, 130, 150);

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ARMY PUBLIC SCHOOL");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(420, 40, 460, 50);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ASC C&C ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(420, 90, 200, 50);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RESULTS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(370, 170, 460, 50);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HEAD BOY");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 240, 170, 50);

        headBoy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        headBoy.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        headBoy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "COUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(headBoy);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 310, 280, 230);

        headGirl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        headGirl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        headGirl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "COUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(headGirl);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(310, 310, 280, 230);

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("HEAD GIRL");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(360, 240, 170, 50);

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CULTURAL CAPTAIN");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(630, 240, 220, 50);

        cultural.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        cultural.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cultural.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "COUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(cultural);

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(600, 310, 280, 230);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SPORTS CAPTAIN");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(920, 240, 200, 50);

        sports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        sports.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "COUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(sports);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(890, 310, 280, 230);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RETURN TO MENU");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 610, 160, 40);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SAVE RESULTS");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1010, 610, 160, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1216, 714));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Main main = new Main();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            /*Object boy = headBoy.getModel().getValueAt(0, 0);
            Object girl = headGirl.getModel().getValueAt(0, 0);
            Object cul = cultural.getModel().getValueAt(0, 0);
            Object sport = sports.getModel().getValueAt(0, 0);
            
            String HeadBoy = "" + boy;
            String HeadGirl = "" + girl;
            String Cultural = "" + cul;
            String Sports = "" + sport;
            
            ImageIcon i = new ImageIcon("src/Voting/res/PicsArt_12-25-11.14.35.png");
            
            JOptionPane.showMessageDialog(this, "\nTHE NEW CAPTAINS ARE\nHead Boy -  " + HeadBoy + "\nHead Girl -  " + HeadGirl +
            "\nCultural Captain -  " + Cultural + "\nSprts Captain -  " + Sports, "CONGRATULATIONS", JOptionPane.WIDTH, i);*/
            
            BufferedImage res = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            
            //ImageIcon fin = new ImageIcon(res);
            
            JFileChooser aa = new JFileChooser();
            
            int a = aa.showSaveDialog(this);
            
            if(a == JFileChooser.APPROVE_OPTION)
            {  
                File path = aa.getSelectedFile();
                String path1 = (path + ".jpg");
                System.out.print(path);
                ImageIO.write(res, "jpeg", new File(path1));
            }
            
        } catch (AWTException | IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cultural;
    private javax.swing.JTable headBoy;
    private javax.swing.JTable headGirl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable sports;
    // End of variables declaration//GEN-END:variables
}
