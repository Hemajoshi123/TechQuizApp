/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.User;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Roshan Pro Acharya
 */
public class TakeTestFrame extends javax.swing.JFrame {

    private int qno, pos = 0;
    private QuestionStore qstore;
    private AnswerStore astore;
    private Exam exam;
    User user;
    public TakeTestFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUserName.setText("Hello " + UserProfile.getUsername());
        qstore = new QuestionStore();
        astore = new AnswerStore();
        qno = 1;
        lblQno.setText(lblQno.getText() + qno);
    }

    public TakeTestFrame(Exam exam, User user) {
        this();
        this.exam = exam;
        lblTitle.setText(exam.getLanguage().toUpperCase() + " PAPER");
        loadQuestions();
        showQuestions();
        this.user = user;
    }

    private void loadQuestions() {
        try {
            ArrayList<Question> questionList = QuestionDAO.getQuestionsByExamId(exam.getExamId());
            for (Question q : questionList) {
                qstore.addQuestion(q);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB ERROR!", "Edit Questions Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void showQuestions() {
        Question q = qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(q.getQuestion());
        jrbOption1.setText(q.getAnswer1());
        jrbOption2.setText(q.getAnswer2());
        jrbOption3.setText(q.getAnswer3());
        jrbOption4.setText(q.getAnswer4());
        Answer ans = astore.getAnswerByQno(qno);
        if (ans == null) {
            return;
        }
        String str = ans.getChosenAnswer();
        switch (str) {
            case "Answer1":
                jrbOption1.setSelected(true);
                break;
            case "Answer2":
                jrbOption2.setSelected(true);
                break;
            case "Answer3":
                jrbOption3.setSelected(true);
                break;
            case "Answer4":
                jrbOption4.setSelected(true);
                break;
        }
    }

    private String getUserAnswer() {
        if (jrbOption1.isSelected()) {
            return "Answer1";
        } else if (jrbOption2.isSelected()) {
            return "Answer2";
        } else if (jrbOption3.isSelected()) {
            return "Answer3";
        } else if (jrbOption4.isSelected()) {
            return "Answer4";
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TechQuizApp");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUserName.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 153, 0));
        lblUserName.setText("H");
        lblUserName.setPreferredSize(new java.awt.Dimension(100, 20));

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
        lblTitle.setText("A");
        lblTitle.setPreferredSize(new java.awt.Dimension(120, 30));

        lblQno.setBackground(new java.awt.Color(0, 0, 0));
        lblQno.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 153, 0));
        lblQno.setText("Question no :  ");

        txtQuestion.setEditable(false);
        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        btnNext.setBackground(new java.awt.Color(255, 0, 0));
        btnNext.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnNext.setForeground(new java.awt.Color(51, 51, 51));
        btnNext.setText("Next");
        btnNext.setContentAreaFilled(false);
        btnNext.setOpaque(true);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(255, 0, 0));
        btnPrevious.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(51, 51, 51));
        btnPrevious.setText("Previous");
        btnPrevious.setContentAreaFilled(false);
        btnPrevious.setOpaque(true);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
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
        btnDone.setForeground(new java.awt.Color(51, 51, 51));
        btnDone.setText("Done");
        btnDone.setContentAreaFilled(false);
        btnDone.setOpaque(true);
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        jrbOption1.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(51, 51, 51));
        jrbOption1.setText("jRadioButton1");
        jrbOption1.setContentAreaFilled(false);
        jrbOption1.setOpaque(true);

        jrbOption2.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(51, 51, 51));
        jrbOption2.setText("jRadioButton2");
        jrbOption2.setContentAreaFilled(false);
        jrbOption2.setOpaque(true);

        jrbOption3.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(51, 51, 51));
        jrbOption3.setText("jRadioButton3");
        jrbOption3.setContentAreaFilled(false);
        jrbOption3.setOpaque(true);

        jrbOption4.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(51, 51, 51));
        jrbOption4.setText("jRadioButton4");
        jrbOption4.setContentAreaFilled(false);
        jrbOption4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnPrevious)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNext)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDone))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jrbOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbOption3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jrbOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jrbOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogout)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblQno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption1)
                    .addComponent(jrbOption2))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption4)
                    .addComponent(jrbOption3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnDone)
                    .addComponent(btnCancel))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAnswer = getUserAnswer();
        if (chosenAnswer != null) {
            Question quest = qstore.getQuestionByQno(qno);
            String correctAnswer = quest.getCorrectAnswer();
            Answer ans = new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAnswer);
            Answer attempted = astore.getAnswerByQno(qno);
            if (attempted == null) {
                astore.addAnswer(ans);
            } else {
                String prevAnswer = attempted.getChosenAnswer();
                if (prevAnswer.equals(chosenAnswer) == false) {
                    int apos = astore.removeAnswer(attempted);
                    astore.setAnswerAt(pos, ans);
                }
            }
        }
        pos++;
        if (pos >= qstore.getCount()) {
            pos = 0;
        }

        qno++;
        if (qno > qstore.getCount()) {
            qno = 1;
        }
        lblQno.setText("Question no : " + qno);
        showQuestions();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        String chosenAnswer = getUserAnswer();
        if (chosenAnswer != null) {
            Question quest = qstore.getQuestionByQno(qno);
            String correctAnswer = quest.getCorrectAnswer();
            Answer ans = new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAnswer);
            Answer attempted = astore.getAnswerByQno(qno);
            if (attempted == null) {
                astore.addAnswer(ans);
            } else {
                String prevAnswer = attempted.getChosenAnswer();
                if (prevAnswer.equals(chosenAnswer) == false) {
                    int apos = astore.removeAnswer(attempted);
                    astore.setAnswerAt(pos, ans);
                }
            }
        }
        pos--;
        if (pos < 0) {
            pos = qstore.getCount() - 1;
        }

        qno--;
        if (qno <= 0) {
            qno = qstore.getCount();
        }
        lblQno.setText("Question no : " + qno);
        showQuestions();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ChoosePaperFrame choosePaper = new ChoosePaperFrame(user);
        choosePaper.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        String chosenAnswer = getUserAnswer();
        if (chosenAnswer != null) {
            Question quest = qstore.getQuestionByQno(qno);
            String correctAnswer = quest.getCorrectAnswer();
            Answer ans = new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAnswer);
            Answer attempted = astore.getAnswerByQno(qno);
            if (attempted == null) {
                astore.addAnswer(ans);
            } else {
                String prevAnswer = attempted.getChosenAnswer();
                if (prevAnswer.equals(chosenAnswer) == false) {
                    int apos = astore.removeAnswer(attempted);
                    astore.setAnswerAt(pos, ans);
                }
            }
        }
        int right = 0, wrong = 0;
        for (Question quest : qstore.getAllQuestions()) {
            int qno = quest.getQno();
            Answer ans = astore.getAnswerByQno(qno);
            if (ans == null) {
                continue;
            }
            String attemptedAnswer = ans.getChosenAnswer();
            String correctAnswer = ans.getCorrectAnswer();
            if (attemptedAnswer.equals(correctAnswer)) {
                ++right;
            } else {
                ++wrong;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Right answers:" + right);
        sb.append("\nWrong answers:" + wrong);
        sb.append("\nUnattempted:" + (qstore.getCount() - (right + wrong)));
        JOptionPane.showMessageDialog(null, sb.toString(), "RESULT!", JOptionPane.INFORMATION_MESSAGE);
        try {
            Performance perf = new Performance(exam.getExamId(), exam.getLanguage(), UserProfile.getUsername(), right, wrong, qstore.getCount() - (right + wrong), (double) right / qstore.getCount() * 100);
            PerformanceDAO.addPerformance(perf);
            JOptionPane.showMessageDialog(null, "Result Saved!\nThank You for the test", "DONE!", JOptionPane.INFORMATION_MESSAGE);
            ChoosePaperFrame choosePaper = new ChoosePaperFrame();
            choosePaper.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB ERROR!", "Take Test Error!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
