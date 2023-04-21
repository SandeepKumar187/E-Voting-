/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Luqmaan
 */
public class Voting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Splash splash = new Splash();
        splash.setVisible(true);
        Login login = new Login();

        for (int i = 0; i <= 100; i++) {
            Thread.sleep(20);
            splash.bar.setValue(i);

            if (i >= 1 && i < 10) {
                splash.error.setText("Starting Application");
            }

            if (i >= 20 && i < 40) {

                splash.error.setText("Checking the Database");

                Thread.sleep(10);

                if (i == 30) {
                    try {

                        Class.forName("java.sql.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
                        Statement stmt = con.createStatement();

                        String query = "Use furqaan";

                        stmt.executeQuery(query);

                        con.close();
                        stmt.close();

                    } catch (Exception e) {

                        if (e.getMessage().equals("Unknown database 'furqaan'")) {

                            try {

                                Class.forName("java.sql.Driver");
                                Connection con;
                                con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
                                Statement stmt = con.createStatement();

                                String query = "create database furqaan;";

                                stmt.execute(query);

                                con.close();
                                stmt.close();
                                
                                JOptionPane.showMessageDialog(null, "Database has been Created");
                                
                                Instructions in = new Instructions();
                                splash.dispose();
                                in.setVisible(true);
                                break;
                                

                            } catch (Exception w) {

                                JOptionPane.showMessageDialog(null, w.getMessage());
                                break;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                            splash.dispose();
                            
                        }
                    }

                }
            }

            if (i >= 40 && i < 60) {
                splash.error.setText("Checking for Tables");
                Thread.sleep(20);

            }

            if (i >= 60 && i < 80) {

                splash.error.setText("Checking the Directory");

                if (i == 65) {
                    try {
                        Class.forName("java.sql.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/furqaan", "root", "admin");
                        Statement stmt = con.createStatement();

                        String query = "select *from Location";

                        ResultSet rs = stmt.executeQuery(query);

                        if (rs.next() != true) {
                            JOptionPane.showMessageDialog(null, "Default Path does not exist \nPlease add the Path now");

                            JFileChooser browse = new JFileChooser();
                            browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                            browse.showDialog(null, "Save Directory");

                            File file = browse.getSelectedFile();

                            String path = file.getAbsoluteFile().toString().replace("\\", "/");

                            System.out.print(path);

                            query = "insert into Location values('" + path + "');";

                            stmt.executeUpdate(query);

                            JOptionPane.showMessageDialog(null, "Path Added Successfully");

                        }

                        con.close();
                        rs.close();
                        stmt.close();

                    } catch (Exception e) {

                    }
                }

            }

            if (i >= 80 && i < 100) {
                splash.error.setText("Starting Application");
            }

            if (i == 100) {

                Thread.sleep(100);
                login.setVisible(true);
                splash.setVisible(false);
            }

        }

    }
}
