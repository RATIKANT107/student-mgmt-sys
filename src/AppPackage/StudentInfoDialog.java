package AppPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class StudentInfoDialog extends javax.swing.JDialog {

    int xMouse, yMouse;
    DataBaseUtils dbUtils;
     
    public StudentInfoDialog(java.awt.Frame parent, boolean modal) 
    {
        
        super(parent, modal);
        initComponents();
        
        dbUtils = new DataBaseUtils();
        
        fillStudentDetails();
        
        textFieldPadding(studentInfoAddress, studentInfoCourse, studentInfoDept, studentInfoName, studentInfoEmail, studentInfoFather, studentInfoID, studentInfoMobile);
        
    }
    
    private void textFieldPadding(JTextField ... field)
    {
        for(int i = 0; i<field.length; i++)
        {
            field[i].setBorder(BorderFactory.createCompoundBorder(
            field[i].getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }        
       
    }

   private void fillStudentDetails()
   {
          
            String sql ="select * from student where id='" +  HomePage.id+ "';";     
            try
            {
                
               dbUtils.connectToDataBase();              
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                if(rs.next())
                {
                    studentInfoID.setText( rs.getString("id"));
                    studentInfoName.setText(rs.getString("name"));
                    studentInfoCourse.setText(rs.getString("course"));
                    studentInfoDept.setText(rs.getString("dept"));
                    studentInfoEmail.setText(rs.getString("email"));
                    studentInfoFather.setText(rs.getString("father"));
                    studentInfoAddress.setText(rs.getString("address"));
                    studentInfoMobile.setText(rs.getString("mobile")); 
                }              
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
            }      
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        studentInfoID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        studentInfoName = new javax.swing.JTextField();
        studentInfoMobile = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        studentInfoCourse = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        studentInfoDept = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        studentInfoFather = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        studentInfoEmail = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        studentInfoAddress = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Info");
        setMaximumSize(new java.awt.Dimension(400, 626));
        setMinimumSize(new java.awt.Dimension(400, 626));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 188, 156));
        jPanel1.setForeground(new java.awt.Color(26, 188, 156));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("×");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 40, 36));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Info");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 36));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 590));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 590));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student ID");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        studentInfoID.setEditable(false);
        studentInfoID.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoID.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoIDActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        studentInfoName.setEditable(false);
        studentInfoName.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoName.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoNameActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 30));

        studentInfoMobile.setEditable(false);
        studentInfoMobile.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoMobile.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoMobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoMobileActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Mobile No.");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        studentInfoCourse.setEditable(false);
        studentInfoCourse.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoCourse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoCourse.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoCourseActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 340, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Course");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 30));

        studentInfoDept.setEditable(false);
        studentInfoDept.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoDept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoDept.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoDept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoDeptActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoDept, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 340, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Department");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 30));

        studentInfoFather.setEditable(false);
        studentInfoFather.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoFather.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoFather.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoFather.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoFather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoFatherActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 340, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Fathers's Name");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, 30));

        studentInfoEmail.setEditable(false);
        studentInfoEmail.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoEmail.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoEmailActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 340, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("E-mail");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 30));

        studentInfoAddress.setEditable(false);
        studentInfoAddress.setBackground(new java.awt.Color(52, 73, 94));
        studentInfoAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfoAddress.setForeground(new java.awt.Color(255, 255, 255));
        studentInfoAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        studentInfoAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInfoAddressActionPerformed(evt);
            }
        });
        jPanel2.add(studentInfoAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 340, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Address");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 400, 590));

        setSize(new java.awt.Dimension(400, 626));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);

    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void studentInfoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoIDActionPerformed

    private void studentInfoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoNameActionPerformed

    private void studentInfoMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoMobileActionPerformed

    private void studentInfoCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoCourseActionPerformed

    private void studentInfoDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoDeptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoDeptActionPerformed

    private void studentInfoFatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoFatherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoFatherActionPerformed

    private void studentInfoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoEmailActionPerformed

    private void studentInfoAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInfoAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentInfoAddressActionPerformed

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
            java.util.logging.Logger.getLogger(StudentInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInfoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentInfoDialog dialog = new StudentInfoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField studentInfoAddress;
    private javax.swing.JTextField studentInfoCourse;
    private javax.swing.JTextField studentInfoDept;
    private javax.swing.JTextField studentInfoEmail;
    private javax.swing.JTextField studentInfoFather;
    private javax.swing.JTextField studentInfoID;
    private javax.swing.JTextField studentInfoMobile;
    private javax.swing.JTextField studentInfoName;
    // End of variables declaration//GEN-END:variables
}
