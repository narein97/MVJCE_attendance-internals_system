/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvjce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author gautamdhariharan
 */
public class changePassword extends javax.swing.JFrame {

    /**
     * Creates new form changePassword
     */
    public changePassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        p1 = new javax.swing.JPasswordField();
        p2 = new javax.swing.JPasswordField();
        p3 = new javax.swing.JPasswordField();
        tf1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(154, 79, 6));
        jLabel2.setText("Old Password");
        jLabel2.setInheritsPopupMenu(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel3.setForeground(new java.awt.Color(154, 79, 6));
        jLabel3.setText("New Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        jLabel4.setForeground(new java.awt.Color(154, 79, 6));
        jLabel4.setText("Retype New Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        jLabel5.setForeground(new java.awt.Color(154, 79, 6));
        jLabel5.setText("Name of person changing password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        p1.setSelectionColor(new java.awt.Color(255, 153, 0));
        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 266, -1));

        p2.setSelectionColor(new java.awt.Color(255, 153, 0));
        getContentPane().add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 266, -1));

        p3.setSelectionColor(new java.awt.Color(255, 153, 0));
        getContentPane().add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 266, -1));

        tf1.setSelectionColor(new java.awt.Color(255, 153, 0));
        getContentPane().add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 266, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setForeground(new java.awt.Color(153, 51, 0));
        jButton1.setText("Done!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setForeground(new java.awt.Color(153, 51, 0));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mvjce/rsz_mvjce_logo.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 340, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mvjce/1.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        p1.setText("");
        p2.setText("");
        p3.setText("");
        tf1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/Info","root","root");
            Statement stmt=(Statement)con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query, newp, newp1, oldp;
            newp1=p3.getText();
            newp=p2.getText();
            oldp=p1.getText();
            query="select * from keyring where password='"+oldp+"'";
            ResultSet rs = stmt.executeQuery(query);
            if((boolean)rs.next()){
            if(newp.equals(newp1))
            {
                query="update keyring set password='"+newp+"' where password='"+oldp+"'";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Password has been changed successfully.");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "New passwords do not match");
            }
            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect password. Please try again or contact the application administrators.");
            }
        }catch(Exception e){System.out.println(e);}
        loginScreen ls=new loginScreen();
        ls.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword().setVisible(true);
                System.out.println("From screen pass");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPasswordField p1;
    public static javax.swing.JPasswordField p2;
    public static javax.swing.JPasswordField p3;
    public static javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
