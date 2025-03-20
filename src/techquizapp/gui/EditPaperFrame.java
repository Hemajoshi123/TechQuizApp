/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import techquizapp.dao.ExamDAO;
import techquizapp.pojo.Exam;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Roshan Pro Acharya
 */
public class EditPaperFrame extends javax.swing.JFrame {

    String subjectName;
    public EditPaperFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUserName.setText("Hello "+UserProfile.getUsername());
    }
    private boolean validateInput()
    {
        int selectedIndex = jcSubject.getSelectedIndex();
        if(selectedIndex==0)
        {
            return false;
        }
        subjectName = jcSubject.getSelectedItem().toString();
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblLogout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcSubject = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcExamId = new javax.swing.JComboBox<>();
        btnEditQuestions = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TechQuizApp");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUserName.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 153, 0));
        lblUserName.setText("hello");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("PAPER EDITING PANEL");

        jlblLogout.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jlblLogout.setForeground(new java.awt.Color(255, 153, 0));
        jlblLogout.setText("Logout");
        jlblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblLogoutMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Set Paper Details");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Choose The Subject");

        jcSubject.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jcSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   ", "Java", "C", "C++", "Python", "C#", "JavaScript" }));
        jcSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSubjectActionPerformed(evt);
            }
        });
        jcSubject.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcSubjectPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Choose The Exam Id");

        jcExamId.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N

        btnEditQuestions.setBackground(new java.awt.Color(255, 0, 0));
        btnEditQuestions.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnEditQuestions.setText("Edit The Questions");
        btnEditQuestions.setContentAreaFilled(false);
        btnEditQuestions.setOpaque(true);
        btnEditQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuestionsActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnBack.setText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.setOpaque(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditQuestions)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcExamId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcSubject, 0, 1, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblLogout)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(265, 265, 265))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblLogout)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcExamId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditQuestions)
                    .addComponent(btnBack))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSubjectActionPerformed
        boolean result = validateInput();
        if(result==false)
        {
            jcExamId.removeAllItems();
            JOptionPane.showMessageDialog(null,"Please select a subject!","Error!",JOptionPane.ERROR_MESSAGE);;
            return;
        }
        try
        {
            ArrayList<String> examList = ExamDAO.getExamIdBySubject(subjectName);
            if(examList.isEmpty())
            {
                jcExamId.removeAllItems();
                JOptionPane.showMessageDialog(null,"No exam set for "+subjectName,"Error!",JOptionPane.ERROR_MESSAGE);;
                jcSubject.setSelectedIndex(0);
                return;
            }
            jcExamId.removeAllItems();
            for(String examId : examList)
            {
                jcExamId.addItem(examId);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB ERROR!","Edit Paper ERROR!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jcSubjectActionPerformed

    private void btnEditQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuestionsActionPerformed
        boolean result = validateInput();
        if(result==false)
        {
            JOptionPane.showMessageDialog(null,"Please select a subject!","Error!",JOptionPane.ERROR_MESSAGE);;
            return;
        }
        String subject = jcSubject.getSelectedItem().toString();
        String examId = jcExamId.getSelectedItem().toString();
        int ans;
        ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to edit exam "+examId+" of subject "+subject+" ?","SURE ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);;
        if(ans==JOptionPane.YES_OPTION)
        {
            try
            {
                int totalQuest = ExamDAO.getQuestionCountByExam(examId);
                Exam editExam = new Exam(examId,subject,totalQuest);
                EditQuestionsFrame questionsFrame = new EditQuestionsFrame(editExam);
                questionsFrame.setVisible(true);
                this.dispose();
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"DB ERROR!","Edit Paper ERROR!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditQuestionsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminOptionsFrame adminFrame = new AdminOptionsFrame();
        adminFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jcSubjectPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcSubjectPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jcSubjectPropertyChange

    private void jlblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLogoutMouseClicked
        LoginFrame lf = new LoginFrame();
        this.dispose();
        lf.setVisible(true);
    }//GEN-LAST:event_jlblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPaperFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditQuestions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcExamId;
    private javax.swing.JComboBox<String> jcSubject;
    private javax.swing.JLabel jlblLogout;
    private javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}
