/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Roshan Pro Acharya
 */
public class EditQuestionsFrame extends javax.swing.JFrame {
    private Exam editExam;
    private QuestionStore qstore;
    private int pos=0;
    private HashMap<String,String> options;
    int qno;
    private String question,option1,option2,option3,option4,correctOption;
    
    public EditQuestionsFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUserName.setText("Hello "+UserProfile.getUsername());
        qstore = new QuestionStore();
        options= new HashMap<>();
        options.put("Option 1","Answer1");
        options.put("Option 2","Answer2");
        options.put("Option 3","Answer3");
        options.put("Option 4","Answer4");
        qno=1;
        lblQno.setText(lblQno.getText()+qno);
    }
    public EditQuestionsFrame(Exam editExam)
    {
        this();
        this.editExam=editExam;
        lblTitle.setText("EDITING "+editExam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
    }
    private boolean validateInput()
    {
        question=txtQuestion.getText().trim();
        option1= txtOption1.getText().trim();
        option2= txtOption2.getText().trim();
        option3= txtOption3.getText().trim();
        option4= txtOption4.getText().trim();
        correctOption= jcCorrectOption.getSelectedItem().toString();
        if(question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || correctOption.isEmpty())
        {
            return false;
        }
        return true;
    }

    private void loadQuestions()
    {
        try
        {
            ArrayList<Question> questionList=QuestionDAO.getQuestionsByExamId(editExam.getExamId());  
            for(Question q : questionList)
            {
                qstore.addQuestion(q);
            }
//            System.out.println(qstore);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB ERROR!","Edit Questions Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    private void showQuestion()
    {
        Question q = qstore.getQuestion(pos);
        txtQuestion.setText(q.getQuestion());
        txtOption1.setText(q.getAnswer1());
        txtOption2.setText(q.getAnswer2());
        txtOption3.setText(q.getAnswer3());
        txtOption4.setText(q.getAnswer4());
        String correctAnswer = q.getCorrectAnswer();
        String correctOpt=getKeyFromValue(correctAnswer);
        jcCorrectOption.setSelectedItem(correctOpt);
    }
    
    private String getKeyFromValue(String value)
    {
        Set <String> keys = options.keySet();
        for(String k : keys)
        {
            String v = options.get(k);
            if(v.equals(value))
            {
                return k;
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOption2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOption3 = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcCorrectOption = new javax.swing.JComboBox<>();
        btnNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TechQuizApp");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUserName.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 153, 0));
        lblUserName.setText("hello");

        lblLogout.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 153, 0));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 153, 0));
        lblTitle.setText("K");
        lblTitle.setPreferredSize(new java.awt.Dimension(250, 30));

        lblQno.setBackground(new java.awt.Color(0, 0, 0));
        lblQno.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 153, 0));
        lblQno.setText("Question no :  ");

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Option 1");

        txtOption1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Option 2");

        txtOption2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Option 3");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Option 4");

        txtOption3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N

        txtOption4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        txtOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOption4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Correct Answer");

        jcCorrectOption.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jcCorrectOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));

        btnNext.setBackground(new java.awt.Color(255, 0, 0));
        btnNext.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnNext.setText("Next");
        btnNext.setContentAreaFilled(false);
        btnNext.setOpaque(true);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setContentAreaFilled(false);
        btnCancel.setOpaque(true);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(255, 0, 0));
        btnDone.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnDone.setText("Done");
        btnDone.setContentAreaFilled(false);
        btnDone.setOpaque(true);
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(255, 0, 0));
        btnPrevious.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.setContentAreaFilled(false);
        btnPrevious.setOpaque(true);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblLogout))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCancel)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDone)
                                        .addGap(152, 152, 152))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnPrevious)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnNext))
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                        .addComponent(jcCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(218, 218, 218))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtOption1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtOption3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addComponent(lblLogout))
                        .addGap(103, 103, 103)
                        .addComponent(lblQno)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrevious)
                            .addComponent(btnNext)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDone)
                            .addComponent(btnCancel))))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(validateInput()==false)
        {
            JOptionPane.showMessageDialog(null,"Please fill all the fields!","ERROR!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String optionName=options.get(correctOption);
        Question obj= new Question(editExam.getExamId(),editExam.getLanguage(),qno,question,option1,option2,option3,option4,optionName);
        qstore.removeQuestion(pos);
        qstore.setQuestionAt(pos, obj);
        pos++;
        if(pos>=qstore.getCount())
        {
            JOptionPane.showMessageDialog(null,"Your all questions have been edited successfully.\nPress the DONE button to save them to the Database.","Exam Edited!",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println(qstore);
            pos=0;
        }
        showQuestion();
        qno++;
        if(qno>qstore.getCount())
        {
            qno=1;
        }
        lblQno.setText("Question no : "+qno);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        EditPaperFrame editPaper= new EditPaperFrame();
        editPaper.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        try {
            QuestionDAO.updateQuestions(qstore);
            JOptionPane.showMessageDialog(null, "Your all questions have been successfully updated in the Database...");
            EditPaperFrame paperFrame = new EditPaperFrame();
            this.dispose();
            paperFrame.setVisible(true);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if(validateInput()==false)
        {
            JOptionPane.showMessageDialog(null,"Please fill all the fields!","ERROR!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String optionName=options.get(correctOption);
        Question obj= new Question(editExam.getExamId(),editExam.getLanguage(),qno,question,option1,option2,option3,option4,optionName);
        qstore.removeQuestion(pos);
        qstore.setQuestionAt(pos, obj);
        pos--;
        if(pos<0)
        {
            JOptionPane.showMessageDialog(null,"Your all questions have been edited successfully.\nPress the DONE button to save them to the Database.","Exam Edited!",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println(qstore);
            pos=qstore.getCount()-1;
        }
        showQuestion();
        qno--;
        if(qno<=0)
        {
            qno=qstore.getCount();
        }
        lblQno.setText("Question no : "+qno);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        LoginFrame lf = new LoginFrame();
        this.dispose();
        lf.setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCorrectOption;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
