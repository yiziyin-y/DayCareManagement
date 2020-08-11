/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.view;

import neu.edu.csye6200.model.Student;
import neu.edu.csye6200.model.Alert;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import neu.edu.csye6200.Interface.OverdueAPI;
import neu.edu.csye6200.controller.OverdueImpl;
import neu.edu.csye6200.controller.csvUtil;


/**
 *
 * @author faun
 */
public class OverdueJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OverdueJPanel
     */private JPanel cardL;
    private Student student;
    public OverdueJPanel(JPanel cardL, Student student) {
        initComponents();
        this.cardL = cardL;
        this.student = student;
    }

  String[] head=new String[] {
            "NAME", "ID", "Age", "Doze", "Type"};
    @SuppressWarnings("unchecked")
    
    
     public Object[][] queryData(){
        
        OverdueAPI OI = new OverdueImpl();
        List<Alert> list= OI.Overdue();
        Object [][] data=new Object[list.size()][5];

        for(int i=0;i<list.size();i++){
            for(int j=0;j<5;j++){
                data[i][0]=list.get(i).getName();
                data[i][1]=list.get(i).getId();
                data[i][2]=list.get(i).getAge();
                data[i][3]=list.get(i).getDoze();
                data[i][4]=list.get(i).getType();
        
            }
        }
        return data;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(queryData(),head));
        jTable1.setMaximumSize(new java.awt.Dimension(0, 300));
        jTable1.setMinimumSize(new java.awt.Dimension(0, 300));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Overdue Alert");

        jButton6.setBackground(new java.awt.Color(181, 219, 240));
        jButton6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton6.setText("Export");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
              csvUtil cu = new csvUtil();
        try {
            cu.exportCsv(head, queryData(), jLabel2.getText());
        } catch (IOException ex) {
            Logger.getLogger(UpcomingJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UpcomingJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UpcomingJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
