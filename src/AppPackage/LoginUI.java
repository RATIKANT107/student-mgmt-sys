package AppPackage;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LoginUI extends javax.swing.JFrame 
{
    
    DataBaseUtils dbUtils;

    public LoginUI() 
    {              
        initComponents(); 
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ImagePackage/icon.png")));
        
        SignUpPanel.setVisible(false);  
        ForgotPasswordPanel.setVisible(false);

        textFieldPadding(jTextField1,jTextField2, signUpAnswer,signUpName, signUpPass, signUpUser, ForgotPasswordAnswer, ForgotPasswordName, ForgotPasswordPassword, ForgotPasswordUserId);
       
        dbUtils = new DataBaseUtils();
        
        HoverEffect he1 = new HoverEffect(jLabel6);
        HoverEffect he2 = new HoverEffect(jLabel7);
        
        he1.setMouseEnteredColor(19, 145, 119);
        he1.setMouseExitedColor(23, 169, 140);
        
        he2.setMouseEnteredColor(19, 145, 119);
        he2.setMouseExitedColor(23, 169, 140);
        
        he1.hoverBackground();
        he2.hoverBackground();  
        
        new TitleBar(jPanel2, this).setJPanelMovable();        
        new TitleBar(jPanel1, this).setJPanelMovable();        
        new TitleBar(jPanel3, this).setJPanelMovable();             
    }
    
    
        
    private void textFieldPadding(JTextField ... field)
    {
        for(int i = 0; i<field.length; i++)
        {
            field[i].setBorder(BorderFactory.createCompoundBorder(field[i].getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ForgotPasswordPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ForgotPasswordUserId = new javax.swing.JTextField();
        ForgotPasswordAnswer = new javax.swing.JTextField();
        ForgotPasswordName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        signUpQuestion1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ForgotPasswordPassword = new javax.swing.JTextField();
        SignUpPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        signUpName = new javax.swing.JTextField();
        signUpPass = new javax.swing.JPasswordField();
        signUpAnswer = new javax.swing.JTextField();
        signUpUser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        signUpQuestion = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SignInPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 560));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ForgotPasswordPanel.setBackground(new java.awt.Color(44, 62, 80));
        ForgotPasswordPanel.setMinimumSize(new java.awt.Dimension(340, 560));
        ForgotPasswordPanel.setPreferredSize(new java.awt.Dimension(340, 520));
        ForgotPasswordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(26, 188, 156));
        jPanel3.setForeground(new java.awt.Color(26, 188, 156));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("×");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel15MouseReleased(evt);
            }
        });
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 36));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/user.png"))); // NOI18N
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 120));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Student Mgmt Sys");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Forgot Password");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 20));

        ForgotPasswordPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        ForgotPasswordUserId.setBackground(new java.awt.Color(44, 62, 80));
        ForgotPasswordUserId.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ForgotPasswordUserId.setForeground(new java.awt.Color(255, 255, 255));
        ForgotPasswordUserId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ForgotPasswordUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordUserIdActionPerformed(evt);
            }
        });
        ForgotPasswordUserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ForgotPasswordUserIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ForgotPasswordUserIdKeyTyped(evt);
            }
        });
        ForgotPasswordPanel.add(ForgotPasswordUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 260, 32));

        ForgotPasswordAnswer.setBackground(new java.awt.Color(44, 62, 80));
        ForgotPasswordAnswer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ForgotPasswordAnswer.setForeground(new java.awt.Color(255, 255, 255));
        ForgotPasswordAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ForgotPasswordAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordAnswerActionPerformed(evt);
            }
        });
        ForgotPasswordAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ForgotPasswordAnswerKeyTyped(evt);
            }
        });
        ForgotPasswordPanel.add(ForgotPasswordAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 300, 32));

        ForgotPasswordName.setEditable(false);
        ForgotPasswordName.setBackground(new java.awt.Color(44, 62, 80));
        ForgotPasswordName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ForgotPasswordName.setForeground(new java.awt.Color(255, 255, 255));
        ForgotPasswordName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ForgotPasswordName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordNameActionPerformed(evt);
            }
        });
        ForgotPasswordName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ForgotPasswordNameKeyTyped(evt);
            }
        });
        ForgotPasswordPanel.add(ForgotPasswordName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 300, 32));

        jLabel23.setBackground(new java.awt.Color(26, 188, 156));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Clear");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel23MouseReleased(evt);
            }
        });
        ForgotPasswordPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 504, 140, 32));

        signUpQuestion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signUpQuestion1.setForeground(new java.awt.Color(255, 255, 255));
        signUpQuestion1.setText("Password");
        ForgotPasswordPanel.add(signUpQuestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("User ID");
        ForgotPasswordPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Name");
        ForgotPasswordPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("What is your favourite color ?");
        ForgotPasswordPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/search.png"))); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel27MouseReleased(evt);
            }
        });
        ForgotPasswordPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 40, 32));

        jLabel28.setBackground(new java.awt.Color(26, 188, 156));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Recover");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel28MouseReleased(evt);
            }
        });
        ForgotPasswordPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 504, 140, 32));

        ForgotPasswordPassword.setEditable(false);
        ForgotPasswordPassword.setBackground(new java.awt.Color(44, 62, 80));
        ForgotPasswordPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ForgotPasswordPassword.setForeground(new java.awt.Color(255, 255, 255));
        ForgotPasswordPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ForgotPasswordPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordPasswordActionPerformed(evt);
            }
        });
        ForgotPasswordPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ForgotPasswordPasswordKeyTyped(evt);
            }
        });
        ForgotPasswordPanel.add(ForgotPasswordPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 300, 32));

        getContentPane().add(ForgotPasswordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 560));

        SignUpPanel.setBackground(new java.awt.Color(44, 62, 80));
        SignUpPanel.setMinimumSize(new java.awt.Dimension(340, 560));
        SignUpPanel.setPreferredSize(new java.awt.Dimension(340, 520));
        SignUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 188, 156));
        jPanel2.setForeground(new java.awt.Color(26, 188, 156));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("×");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 36));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/user.png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 120));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Student Mgmt Sys");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sign Up");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, 20));

        SignUpPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        signUpName.setBackground(new java.awt.Color(44, 62, 80));
        signUpName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        signUpName.setForeground(new java.awt.Color(255, 255, 255));
        signUpName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        signUpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpNameActionPerformed(evt);
            }
        });
        signUpName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                signUpNameKeyTyped(evt);
            }
        });
        SignUpPanel.add(signUpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 300, 32));

        signUpPass.setBackground(new java.awt.Color(44, 62, 80));
        signUpPass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        signUpPass.setForeground(new java.awt.Color(255, 255, 255));
        signUpPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        signUpPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpPassActionPerformed(evt);
            }
        });
        signUpPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                signUpPassKeyTyped(evt);
            }
        });
        SignUpPanel.add(signUpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 300, 32));

        signUpAnswer.setBackground(new java.awt.Color(44, 62, 80));
        signUpAnswer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        signUpAnswer.setForeground(new java.awt.Color(255, 255, 255));
        signUpAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        signUpAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpAnswerActionPerformed(evt);
            }
        });
        signUpAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                signUpAnswerKeyTyped(evt);
            }
        });
        SignUpPanel.add(signUpAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 300, 32));

        signUpUser.setBackground(new java.awt.Color(44, 62, 80));
        signUpUser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        signUpUser.setForeground(new java.awt.Color(255, 255, 255));
        signUpUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        signUpUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpUserActionPerformed(evt);
            }
        });
        signUpUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                signUpUserKeyTyped(evt);
            }
        });
        SignUpPanel.add(signUpUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 300, 32));

        jLabel16.setBackground(new java.awt.Color(26, 188, 156));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sign Up");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel16MouseReleased(evt);
            }
        });
        SignUpPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 504, 300, 32));

        signUpQuestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signUpQuestion.setForeground(new java.awt.Color(255, 255, 255));
        signUpQuestion.setText("What is your favourite color ?");
        SignUpPanel.add(signUpQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Name");
        SignUpPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("User ID");
        SignUpPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Password");
        SignUpPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        getContentPane().add(SignUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 560));

        SignInPanel.setBackground(new java.awt.Color(44, 62, 80));
        SignInPanel.setMinimumSize(new java.awt.Dimension(340, 560));
        SignInPanel.setPreferredSize(new java.awt.Dimension(340, 520));
        SignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 36));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/user.png"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Mgmt Sys");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, 20));

        SignInPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 200));

        jTextField2.setBackground(new java.awt.Color(44, 62, 80));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        SignInPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 300, 32));

        jLabel6.setBackground(new java.awt.Color(26, 188, 156));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sign In");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        SignInPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 300, 32));

        jLabel7.setBackground(new java.awt.Color(26, 188, 156));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sign Up");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel7MouseReleased(evt);
            }
        });
        SignInPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 300, 32));

        jLabel8.setBackground(new java.awt.Color(26, 188, 156));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Login to get started...!");
        SignInPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 300, 32));

        jLabel13.setBackground(new java.awt.Color(26, 188, 156));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Have you forgot your password ?");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel13MouseReleased(evt);
            }
        });
        SignInPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 300, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        SignInPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("User ID");
        SignInPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jTextField1.setBackground(new java.awt.Color(44, 62, 80));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        SignInPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 300, 32));

        getContentPane().add(SignInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 560));
        SignInPanel.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(340, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
       System.exit(0);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
     
        
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    
    private void signIn()
    {
        if(jTextField1.getText().trim().isEmpty() || jTextField2.getText().trim().isEmpty())
        {
           JOptionPane.showMessageDialog(rootPane, "User ID or Password is empty", "Warning",JOptionPane.WARNING_MESSAGE);
           
        }
       else
       {
           String sql = "select * from signup where user_id = '" + jTextField2.getText() + "';";
      
        try 
        {
            dbUtils.connectToDataBase();
            Statement stmt = DataBaseUtils.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);  
                                  

            if(rs.next())
            {
                 if (jTextField1.getText().equals(rs.getString(3))) 
                 {
                    System.out.println("User id : " + rs.getString(2));
                    System.out.println("Pass : " + rs.getString(3));

                    this.dispose();
                    new HomePage().setVisible(true);
                } 
                 else 
                 {
                    JOptionPane.showMessageDialog(rootPane, "Login Failed...!\nEnter correct credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
            }
            else
            {
                    JOptionPane.showMessageDialog(rootPane, "Login Failed...!\nEnter correct credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
           
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
       }
    }
    
    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
       
       signIn();
       
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        SignUpPanel.setVisible(false);
        SignInPanel.setVisible(true);
        ForgotPasswordPanel.setVisible(false);
        signUpClear();
    }//GEN-LAST:event_jLabel9MouseReleased

    private void signUpNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpNameActionPerformed

    private void signUpAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpAnswerActionPerformed

    private void signUpUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpUserActionPerformed

    private void signUpPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpPassActionPerformed

    private void jLabel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseReleased
        SignInPanel.setVisible(false);
        SignUpPanel.setVisible(true);
        ForgotPasswordPanel.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseReleased

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
     
    }//GEN-LAST:event_jPanel1MouseDragged

    private boolean isTextFiledEmpty(JTextField ... textField)
    {
        boolean result = true;
        
        for(int i = 0; i<textField.length; i++)
        {
            if(textField[i].getText().trim().isEmpty())
            {
                return result = true;
            }
            else
            {
             return result = false;   
            }
        }
        
        return result;
    }
    
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
      if(jTextField2.getText().equals("User ID"))
      {
          jTextField2.setText("");
      }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void signUpNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpNameKeyTyped
        if(signUpName.getText().equals("Name"))
        {
          signUpName.setText("");
        }
    }//GEN-LAST:event_signUpNameKeyTyped

    private void signUpUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpUserKeyTyped
      if(signUpUser.getText().equals("User ID"))
      {
          signUpUser.setText("");
      }
    }//GEN-LAST:event_signUpUserKeyTyped

    private void signUpPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpPassKeyTyped
       if(signUpPass.getText().equals("Password"))
      {
          signUpPass.setText("");
      }
    }//GEN-LAST:event_signUpPassKeyTyped

    private void signUpAnswerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpAnswerKeyTyped
       if(signUpAnswer.getText().equals("Answer"))
      {
          signUpAnswer.setText("");
      }
    }//GEN-LAST:event_signUpAnswerKeyTyped

    
    private void signUpClear()
    {
        signUpName.setText("");
        signUpAnswer.setText("");
        signUpPass.setText("");
        signUpUser.setText("");
    }
    
    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased

       if(isTextFiledEmpty(signUpName, signUpUser, signUpPass, signUpAnswer))
       {
           JOptionPane.showMessageDialog(rootPane, "All fields are mandatory to fill", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
       }
       else
       {
           String name = signUpName.getText();
           String user = signUpUser.getText();
           String pass = signUpPass.getText();
           String question = signUpQuestion.getText();
           String answer = signUpAnswer.getText();

           String sql = "insert into signup values ('" + name + "', '" + user + "', '" + pass + "', '" + question + "', '" + answer + "');";

           try 
           {
               dbUtils.connectToDataBase();
               Statement stmt = DataBaseUtils.con.createStatement();
               stmt.execute(sql);
               JOptionPane.showMessageDialog(rootPane, "Registeration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
               signUpClear();
           } 
           catch (SQLException e) 
           {
               JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
        
      
      
    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseReleased
       SignInPanel.setVisible(true);
       SignUpPanel.setVisible(false);
       ForgotPasswordPanel.setVisible(false);
       forgotPasswordClear();
    }//GEN-LAST:event_jLabel15MouseReleased

    private void ForgotPasswordUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordUserIdActionPerformed

    private void ForgotPasswordUserIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ForgotPasswordUserIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordUserIdKeyTyped

    private void ForgotPasswordAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordAnswerActionPerformed

    private void ForgotPasswordAnswerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ForgotPasswordAnswerKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordAnswerKeyTyped

    private void ForgotPasswordNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordNameActionPerformed

    private void ForgotPasswordNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ForgotPasswordNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordNameKeyTyped

    private void forgotPasswordClear()
    {
        ForgotPasswordAnswer.setText("");
        ForgotPasswordName.setText("");
        ForgotPasswordUserId.setText("");
        ForgotPasswordPassword.setText("");
    }
    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
       forgotPasswordClear();
    }//GEN-LAST:event_jLabel23MouseReleased

    private void jLabel27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseReleased
        String sql = "select * from signup;";
        findUser(sql);       
        
    }//GEN-LAST:event_jLabel27MouseReleased

    private void findUser(String sqlQuery)
    {
        if(isTextFiledEmpty(ForgotPasswordUserId))
        {
            JOptionPane.showMessageDialog(rootPane, "Please, enter User ID", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
             try 
             {
                dbUtils.connectToDataBase();
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlQuery);

                if (rs.next())
                {
                    if (rs.getString(2).equalsIgnoreCase(ForgotPasswordUserId.getText())) 
                    {
                        ForgotPasswordName.setText(rs.getString(1));
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(rootPane, "There is no such User ID exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
       
        }
        
        
       
    }
    
    private void findPassword(String sql)
    {
        try 
        {
            dbUtils.connectToDataBase();
            Statement stmt = DataBaseUtils.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); 
            
            if(rs.next())
            
            if(rs.getString(2).equalsIgnoreCase(ForgotPasswordUserId.getText())  && rs.getString(5).equalsIgnoreCase(ForgotPasswordAnswer.getText().trim()))
            {
                ForgotPasswordPassword.setText(rs.getString(3));
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "You have entered wrong answer, Try again...!" , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    private void jLabel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseReleased
        
        findPassword("select * from signup;");
              
    }//GEN-LAST:event_jLabel28MouseReleased

    private void ForgotPasswordPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordPasswordActionPerformed
      
    }//GEN-LAST:event_ForgotPasswordPasswordActionPerformed

    private void ForgotPasswordPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ForgotPasswordPasswordKeyTyped
    
    }//GEN-LAST:event_ForgotPasswordPasswordKeyTyped

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
        SignInPanel.setVisible(false);
        SignUpPanel.setVisible(false);
        ForgotPasswordPanel.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseReleased

    private void ForgotPasswordUserIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ForgotPasswordUserIdKeyReleased
        if(evt.getKeyCode() == 10)
        {
            String sql = "select * from signup;";
            findUser(sql); 
        }
    }//GEN-LAST:event_ForgotPasswordUserIdKeyReleased

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
       jLabel1.setForeground(Color.RED);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
         jLabel1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if(evt.getKeyCode() == 10)
        {
            signIn();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ForgotPasswordAnswer;
    private javax.swing.JTextField ForgotPasswordName;
    private javax.swing.JPanel ForgotPasswordPanel;
    private javax.swing.JTextField ForgotPasswordPassword;
    private javax.swing.JTextField ForgotPasswordUserId;
    private javax.swing.JPanel SignInPanel;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField signUpAnswer;
    private javax.swing.JTextField signUpName;
    private javax.swing.JPasswordField signUpPass;
    private javax.swing.JLabel signUpQuestion;
    private javax.swing.JLabel signUpQuestion1;
    private javax.swing.JTextField signUpUser;
    // End of variables declaration//GEN-END:variables
}
