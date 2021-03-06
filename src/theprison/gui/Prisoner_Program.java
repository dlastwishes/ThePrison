/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theprison.gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jamemez
 */
public class Prisoner_Program extends javax.swing.JFrame {
        Prison_login login = new Prison_login();
    private long staffId = login.staffId;
    Process process = new Process();
    public static Detail_Prisoner de_pri = new Detail_Prisoner();
    /**
     * Creates new form Prisoner_Program
     */
    public Prisoner_Program() {
        initComponents();
          this.prison.setText(String.valueOf(process.getPrisonID(staffId)));
        this.setSize(800, 600);
        ArrayList<Status> statuss = Process.getStatusList();
        Vector vec = new Vector();
        vec.add("Status ID");
        vec.add("Name");
        vec.add("Detail");
        TableModel model = new DefaultTableModel(vec,statuss.size());
        this.statusTB.setModel(model);
        
        for(int i =0;i<statuss.size();i++){
            this.statusTB.setValueAt(statuss.get(i).getId_status(), i, 0);
            this.statusTB.setValueAt(statuss.get(i).getStatus_name(), i, 1);
            this.statusTB.setValueAt(statuss.get(i).getStatus_descrip(), i, 2);
        }
        
         ArrayList<Penalty> penaltys = Process.getPenaltyList();
          Vector vec1 = new Vector();
        vec1.add("Penalty ID");
        vec1.add("Name");
        vec1.add("Detail");
        vec1.add("Crime ID");
        TableModel model1 = new DefaultTableModel(vec1,penaltys.size());
        this.penaltyTB.setModel(model1);
        
         for(int i =0;i<penaltys.size();i++){
            this.penaltyTB.setValueAt(penaltys.get(i).getId_penalty(), i, 0);
            this.penaltyTB.setValueAt(penaltys.get(i).getPunish_name(), i, 1);
            this.penaltyTB.setValueAt(penaltys.get(i).getPunish_detail(), i, 2);
            this.penaltyTB.setValueAt(penaltys.get(i).getId_crime(),i,3);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_pri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pri_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        s_id_pri = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        s_name_pri = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pri_ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        in_date = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        out_date = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        penalty_id = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        penaltyTB = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        status_id = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        statusTB = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        prison = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Prisoner Management");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 0, 257, 50);

        jLabel2.setText("ID :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(16, 57, 50, 32);

        id_pri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_priActionPerformed(evt);
            }
        });
        getContentPane().add(id_pri);
        id_pri.setBounds(70, 60, 186, 32);

        jLabel3.setText("Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 60, 54, 32);
        getContentPane().add(pri_name);
        pri_name.setBounds(340, 60, 201, 32);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Prisoner", "Name", "Age", "Ministry Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 138, 764, 108);

        buttonGroup1.add(s_id_pri);
        s_id_pri.setMnemonic('1');
        s_id_pri.setSelected(true);
        s_id_pri.setText("ID Prisoner");
        s_id_pri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s_id_priMouseClicked(evt);
            }
        });
        s_id_pri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_id_priActionPerformed(evt);
            }
        });
        getContentPane().add(s_id_pri);
        s_id_pri.setBounds(120, 100, 120, 30);

        jLabel6.setText("Search By :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 100, 80, 25);

        buttonGroup1.add(s_name_pri);
        s_name_pri.setMnemonic('2');
        s_name_pri.setText("Name Prisoner");
        s_name_pri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s_name_priMouseClicked(evt);
            }
        });
        s_name_pri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_name_priActionPerformed(evt);
            }
        });
        getContentPane().add(s_name_pri);
        s_name_pri.setBounds(260, 100, 110, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 100, 110, 30);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(690, 100, 87, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Add prisoner in crime");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(159, 250, 296, 36);

        jLabel5.setText("Prisoner ID :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 295, 78, 29);
        getContentPane().add(pri_ID);
        pri_ID.setBounds(102, 295, 160, 29);

        jLabel7.setText("In Date :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(282, 295, 57, 29);
        getContentPane().add(in_date);
        in_date.setBounds(357, 295, 123, 29);

        jLabel8.setText("Out Date :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(484, 294, 73, 31);
        getContentPane().add(out_date);
        out_date.setBounds(561, 292, 105, 34);

        jLabel9.setText("Penalty ID :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 334, 78, 35);
        getContentPane().add(penalty_id);
        penalty_id.setBounds(102, 339, 107, 30);

        penaltyTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Penalty", "Name", "Detail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(penaltyTB);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 421, 380, 121);

        jLabel10.setText("Penalty List :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 394, 136, 14);

        jLabel11.setText("Status ID :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(250, 340, 66, 33);
        getContentPane().add(status_id);
        status_id.setBounds(320, 340, 130, 35);

        statusTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Status ID", "Name", "Detail"
            }
        ));
        jScrollPane3.setViewportView(statusTB);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(418, 421, 339, 121);

        jLabel12.setText("Status List");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(473, 388, 136, 27);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(600, 340, 87, 37);

        jButton4.setText("Reset");
        getContentPane().add(jButton4);
        jButton4.setBounds(700, 340, 87, 37);

        jLabel13.setText("Ex: 23/07/2559");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(680, 290, 112, 35);

        prison.setEditable(false);
        prison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisonActionPerformed(evt);
            }
        });
        getContentPane().add(prison);
        prison.setBounds(470, 340, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false);
        Main_Program main = new Main_Program();
        main.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void s_id_priMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_id_priMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_s_id_priMouseClicked

    private void s_name_priMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_name_priMouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_s_name_priMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Vector vec = new Vector();
        vec.add("ID Prisoner");
        vec.add("Name");
        vec.add("Age");
        vec.add("Ministry Status");
        
        if(this.buttonGroup1.getSelection().getMnemonic()==49){
            if(this.id_pri.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Enter ID Card Prisoner");
            }
            else{
                Prisoner pri = process.searchPrisonerByIdCard(Long.decode(this.id_pri.getText()));
                TableModel model = new DefaultTableModel(vec,1);
                this.jTable1.setModel(model);
                this.jTable1.setValueAt(pri.getId_prisoner(), 0, 0);
                this.jTable1.setValueAt(pri.getName_prisoner(), 0, 1);
                this.jTable1.setValueAt(pri.getAge(), 0, 2);
                this.jTable1.setValueAt(pri.isMinistry_status(), 0, 3);
            }
        }
        else if(this.buttonGroup1.getSelection().getMnemonic()==50){
            if(this.pri_name.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Enter Name Prisoner");
            }
            else{
                ArrayList<Prisoner> prisoners = process.searchPrisonerByName(this.pri_name.getText());
                TableModel model = new DefaultTableModel(vec,prisoners.size());
                this.jTable1.setModel(model);
                for(int i =0; i<prisoners.size();i++){
                     this.jTable1.setValueAt(prisoners.get(i).getId_prisoner(), i, 0);
                this.jTable1.setValueAt(prisoners.get(i).getName_prisoner(), i, 1);
                this.jTable1.setValueAt(prisoners.get(i).getAge(), i, 2);
                this.jTable1.setValueAt(prisoners.get(i).isMinistry_status(), i, 3);
                }
               
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void s_id_priActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_id_priActionPerformed
        // TODO add your handling code here:
        
        this.pri_name.setEnabled(true);
        this.id_pri.setEnabled(true);
        this.pri_name.setEnabled(false);
        
    }//GEN-LAST:event_s_id_priActionPerformed

    private void s_name_priActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_name_priActionPerformed
        // TODO add your handling code here:
        
        this.pri_name.setEnabled(true);
        this.id_pri.setEnabled(true);
        this.id_pri.setEnabled(false);
       
    }//GEN-LAST:event_s_name_priActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)).equalsIgnoreCase("0")){
            
        }
        else{
            Info_Prisoner in_pri = new Info_Prisoner();
        in_pri.setVisible(true);
        Process pc = new Process();
        de_pri.getObDetailById(Long.decode(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0))));
        }
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void id_priActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_priActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_priActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String setDate = String.valueOf(this.in_date.getText());
        Date date = dateFormat.parse(setDate);
        String dateOut = String.valueOf(this.out_date.getText());
        Date date2 = dateFormat.parse(dateOut);
        Process.AddPrisonerInCrime(date, date2, Long.decode(this.pri_ID.getText()),Long.decode(this.penalty_id.getText()) , Long.decode(this.status_id.getText()),Long.decode(this.prison.getText()));
        JOptionPane.showMessageDialog(this,"Submit Success");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void prisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prisonActionPerformed

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
            java.util.logging.Logger.getLogger(Prisoner_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prisoner_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prisoner_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prisoner_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prisoner_Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField id_pri;
    private javax.swing.JTextField in_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField out_date;
    private javax.swing.JTable penaltyTB;
    private javax.swing.JTextField penalty_id;
    private javax.swing.JTextField pri_ID;
    private javax.swing.JTextField pri_name;
    private javax.swing.JTextField prison;
    private javax.swing.JRadioButton s_id_pri;
    private javax.swing.JRadioButton s_name_pri;
    private javax.swing.JTable statusTB;
    private javax.swing.JTextField status_id;
    // End of variables declaration//GEN-END:variables
}
