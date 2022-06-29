package AppPackage;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class HomePage extends javax.swing.JFrame 
{
    public static String id;
      
    DataBaseUtils dbUtils;
    int xMouse, yMouse;
    DefaultTableModel model;
  
    
    public HomePage() 
    {
        
        initComponents();
        
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ImagePackage/icon.png")));
        
        dbUtils = new DataBaseUtils();
        
        NavigationBar navigationBar = new NavigationBar(new Color(17, 125, 104),new Color(26,188,156) ,new Color(85, 207, 183));
        navigationBar.addComponent(addLabel, updateLabel,  deleteLabel, searchLabel);
        
        labelPadding(addLabel, updateLabel,  deleteLabel, searchLabel);
        textFieldPadding(addName, addMobile,searchField, addDepartment, addCourse, addEmail, addFather, addID, addAdress, updateName, updateID, updateFather,updateEmail, updateAdress, updateMobile
                
        );
            
        HoverEffect he1 = new HoverEffect(addSubmit);
        HoverEffect he2 = new HoverEffect(addClear);
        HoverEffect he3 = new HoverEffect(jLabel1);         
        
        he1.setMouseEnteredColor(19, 145, 119);
        he1.setMouseExitedColor(23, 169, 140);
        he1.hoverBackground();
         
        he2.setMouseEnteredColor(19, 145, 119);
        he2.setMouseExitedColor(23, 169, 140);
        he2.hoverBackground(); 
        he3.setMouseEnteredColor(Color.RED);
        
        he3.setMouseExitedColor(Color.WHITE);
        he3.hoverForeground();
        
        JTableHeader h = jTable1.getTableHeader();
     // h.setBackground(Color.red);
        h.setVisible(false);
        h.setEnabled(false);
        
        JTableHeader h2 = jTable2.getTableHeader(); 
        h2.setVisible(false);
        h2.setEnabled(false);
        
        
        
        searchRecordPanel.setVisible(false);
        deletePanel.setVisible(false);
        updateRecordPane.setVisible(false);
        
        
        tableLabelPadding(jLabel10, jLabel6, jLabel21, jLabel20, jLabel23, jLabel22);
        
        updateMessage();
   }

    
    public void exportTable(JTable table, File file) throws IOException 
    {
            TableModel model = table.getModel();
            FileWriter out = new FileWriter(file);
            for(int i=0; i < model.getColumnCount(); i++) 
            {
                out.write(model.getColumnName(i) + "\t");
            }
            out.write("\n");

            for(int i=0; i< model.getRowCount(); i++) 
            {
                for(int j=0; j < model.getColumnCount(); j++)
                {
                    out.write(model.getValueAt(i,j).toString()+"\t");
                }
                out.write("\n");
        }

        out.close();
        System.out.println("write out to: " + file);
}
    
    private void printTable(JTable table, String headingString, String footerString)
    {
        MessageFormat header = new MessageFormat(headingString);
        MessageFormat footer = new MessageFormat(footerString);
        
        try
        {
            boolean check = table.print(JTable.PrintMode.FIT_WIDTH, header ,footer);
            
            if(check != true)
            {
               JOptionPane.showMessageDialog(rootPane, "Printing is cancelled by the user", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } 
        catch (PrinterException ex) 
        {
           JOptionPane.showMessageDialog(rootPane, "Unable to print", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void fillTabelData(JTable jTabel)
    {
        
            String sql ="select * from student;";                                                                                       
      
            try
            {
                
                model = (DefaultTableModel) jTabel.getModel();
                while(jTabel.getRowCount()>0)
                {
                    model.removeRow(0);
                }
                      
                dbUtils.connectToDataBase();
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next())
                {
                    model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("course"), rs.getString("dept"), rs.getString("email")});
                }
                              
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
            }
       
    }
    
    
    private void updateMessage()
    {
        
        new Thread()
        {
            int totalMessage = 1;
            public void run()
            {
                while (true) 
                {                    
                    switch(totalMessage)
                    {
                        case 1 : searchMessageLabel.setText("To find or search student record write student id in search box");
                                 thread(3000);
                                 totalMessage++;
                        break;
                        
                        case 2 : searchMessageLabel.setText("Double click to get complete detail of the student" );
                                thread(3000);
                                totalMessage++;
                                break;
                        case 3 : totalMessage = 1;
                        break;
                    }
                }
            }
        }.start();
    }
    
    private void thread(long time)
    {
        try
        {
            Thread.sleep(time);
        } 
        catch (InterruptedException e) 
        {
            System.out.println(e.getMessage());
        }
    }
            
    
    private void labelPadding(JLabel ... field)
    {
        for(int i = 0; i<field.length; i++)
        {
            field[i].setBorder(BorderFactory.createCompoundBorder(
            field[i].getBorder(), 
            BorderFactory.createEmptyBorder(5, 20, 5, 5)));
        }    
       
    }
    
    private void tableLabelPadding(JLabel ... field)
    {
        for(int i = 0; i<field.length; i++)
        {
            field[i].setBorder(BorderFactory.createCompoundBorder(
            field[i].getBorder(), 
            BorderFactory.createEmptyBorder(0,5, 0, 0)));
        }      
       
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        updateLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        aboutLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        searchRecordPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new SubJTable();
        searchMessageLabel = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        updateRecordPane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        updateID = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        updateName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        updateMobile = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        updateFather = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        updateEmail = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        updateAdress = new javax.swing.JTextField();
        updateClear = new javax.swing.JLabel();
        updateSubmit = new javax.swing.JLabel();
        updateMessageLabel = new javax.swing.JLabel();
        addRecordPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        addName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addMobile = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        addCourse = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addDepartment = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addFather = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        addEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        addAdress = new javax.swing.JTextField();
        addClear = new javax.swing.JLabel();
        addSubmit = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        deletePanel = new javax.swing.JPanel();
        messageLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new SubJTable();
        jLabel29 = new javax.swing.JLabel();
        deleteField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Mgmt Sys");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(26, 188, 156));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/user.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 120, 130));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Mgmt Sys");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, 30));

        deleteLabel.setBackground(new java.awt.Color(26, 188, 156));
        deleteLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deleteLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/delete.PNG"))); // NOI18N
        deleteLabel.setText("Delete Record");
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.setIconTextGap(27);
        deleteLabel.setOpaque(true);
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteLabelMouseReleased(evt);
            }
        });
        jPanel3.add(deleteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 240, 50));

        addLabel.setBackground(new java.awt.Color(17, 125, 104));
        addLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/add.png"))); // NOI18N
        addLabel.setText("Add Student");
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.setIconTextGap(16);
        addLabel.setOpaque(true);
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addLabelMouseReleased(evt);
            }
        });
        jPanel3.add(addLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 240, 50));

        updateLabel.setBackground(new java.awt.Color(26, 188, 156));
        updateLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        updateLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/update.PNG"))); // NOI18N
        updateLabel.setText("Update Record");
        updateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateLabel.setIconTextGap(16);
        updateLabel.setOpaque(true);
        updateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateLabelMouseReleased(evt);
            }
        });
        jPanel3.add(updateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 240, 50));

        jLabel8.setBackground(new java.awt.Color(26, 188, 156));
        jLabel8.setOpaque(true);
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 240, 46));

        searchLabel.setBackground(new java.awt.Color(26, 188, 156));
        searchLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/search.png"))); // NOI18N
        searchLabel.setText("Search Record");
        searchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchLabel.setIconTextGap(25);
        searchLabel.setName("searchLabel"); // NOI18N
        searchLabel.setOpaque(true);
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchLabelMouseReleased(evt);
            }
        });
        jPanel3.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 240, 50));

        logoutLabel.setBackground(new java.awt.Color(26, 188, 156));
        logoutLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/exit.png"))); // NOI18N
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.setOpaque(true);
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutLabelMouseReleased(evt);
            }
        });
        jPanel3.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 436, 40, 40));

        aboutLabel.setBackground(new java.awt.Color(26, 188, 156));
        aboutLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        aboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        aboutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/about.png"))); // NOI18N
        aboutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutLabel.setOpaque(true);
        aboutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aboutLabelMouseReleased(evt);
            }
        });
        jPanel3.add(aboutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 436, 40, 40));

        infoLabel.setBackground(new java.awt.Color(26, 188, 156));
        infoLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagePackage/info.png"))); // NOI18N
        infoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoLabel.setOpaque(true);
        infoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                infoLabelMouseReleased(evt);
            }
        });
        jPanel3.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 436, 40, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 504));

        searchRecordPanel.setBackground(new java.awt.Color(44, 62, 80));
        searchRecordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(26, 188, 156));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setOpaque(true);
        searchRecordPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 126, 120, 30));

        jLabel10.setBackground(new java.awt.Color(26, 188, 156));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID");
        jLabel10.setAlignmentX(0.5F);
        jLabel10.setOpaque(true);
        searchRecordPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 126, 120, 30));

        jLabel20.setBackground(new java.awt.Color(26, 188, 156));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Dept");
        jLabel20.setAlignmentX(0.5F);
        jLabel20.setOpaque(true);
        searchRecordPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 126, 120, 30));

        jLabel21.setBackground(new java.awt.Color(26, 188, 156));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Course");
        jLabel21.setAlignmentX(0.5F);
        jLabel21.setOpaque(true);
        searchRecordPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 126, 120, 30));

        jLabel23.setBackground(new java.awt.Color(26, 188, 156));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Email");
        jLabel23.setAlignmentX(0.5F);
        jLabel23.setOpaque(true);
        searchRecordPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 126, 120, 30));

        jScrollPane1.setBackground(new java.awt.Color(26, 188, 156));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTable1.setBackground(new java.awt.Color(44, 62, 80));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Course", "Department", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(44, 62, 80));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(17, 125, 104));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        searchRecordPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 600, 340));

        searchMessageLabel.setBackground(new java.awt.Color(17, 125, 104));
        searchMessageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchMessageLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchMessageLabel.setText("To find or search student record write student id in search box");
        searchMessageLabel.setOpaque(true);
        searchRecordPanel.add(searchMessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Search");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchRecordPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 30));

        searchField.setBackground(new java.awt.Color(44, 62, 80));
        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(255, 255, 255));
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });
        searchRecordPanel.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 180, 30));

        jLabel24.setBackground(new java.awt.Color(26, 188, 156));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Refresh");
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel24MouseReleased(evt);
            }
        });
        searchRecordPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 110, 32));

        jLabel35.setBackground(new java.awt.Color(26, 188, 156));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Print");
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel35MouseReleased(evt);
            }
        });
        searchRecordPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 110, 32));

        jLabel9.setBackground(new java.awt.Color(26, 188, 156));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Export");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });
        searchRecordPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 110, 30));

        jPanel2.add(searchRecordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 660, 504));

        updateRecordPane.setBackground(new java.awt.Color(44, 62, 80));
        updateRecordPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Update Student Record");
        updateRecordPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Student ID");
        updateRecordPane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        updateID.setBackground(new java.awt.Color(44, 62, 80));
        updateID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateID.setForeground(new java.awt.Color(255, 255, 255));
        updateID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIDActionPerformed(evt);
            }
        });
        updateID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateIDKeyReleased(evt);
            }
        });
        updateRecordPane.add(updateID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 250, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Full Name");
        updateRecordPane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        updateName.setBackground(new java.awt.Color(44, 62, 80));
        updateName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateName.setForeground(new java.awt.Color(255, 255, 255));
        updateName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNameActionPerformed(evt);
            }
        });
        updateRecordPane.add(updateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 250, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Mobile No");
        updateRecordPane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        updateMobile.setBackground(new java.awt.Color(44, 62, 80));
        updateMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateMobile.setForeground(new java.awt.Color(255, 255, 255));
        updateMobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMobileActionPerformed(evt);
            }
        });
        updateMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateMobileKeyTyped(evt);
            }
        });
        updateRecordPane.add(updateMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 250, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Father's Name");
        updateRecordPane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        updateFather.setBackground(new java.awt.Color(44, 62, 80));
        updateFather.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateFather.setForeground(new java.awt.Color(255, 255, 255));
        updateFather.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateFather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFatherActionPerformed(evt);
            }
        });
        updateRecordPane.add(updateFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 250, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("E-mail");
        updateRecordPane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        updateEmail.setBackground(new java.awt.Color(44, 62, 80));
        updateEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateEmail.setForeground(new java.awt.Color(255, 255, 255));
        updateEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmailActionPerformed(evt);
            }
        });
        updateRecordPane.add(updateEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 250, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Address");
        updateRecordPane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        updateAdress.setBackground(new java.awt.Color(44, 62, 80));
        updateAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateAdress.setForeground(new java.awt.Color(255, 255, 255));
        updateAdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        updateAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAdressActionPerformed(evt);
            }
        });
        updateRecordPane.add(updateAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 250, 30));

        updateClear.setBackground(new java.awt.Color(26, 188, 156));
        updateClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateClear.setForeground(new java.awt.Color(255, 255, 255));
        updateClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateClear.setText("Clear");
        updateClear.setOpaque(true);
        updateClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateClearMouseReleased(evt);
            }
        });
        updateRecordPane.add(updateClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 250, 32));

        updateSubmit.setBackground(new java.awt.Color(26, 188, 156));
        updateSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateSubmit.setForeground(new java.awt.Color(255, 255, 255));
        updateSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateSubmit.setText("Update");
        updateSubmit.setOpaque(true);
        updateSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateSubmitMouseReleased(evt);
            }
        });
        updateRecordPane.add(updateSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 250, 32));

        updateMessageLabel.setBackground(new java.awt.Color(17, 125, 104));
        updateMessageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateMessageLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateMessageLabel.setText("Enter Student ID and hit Enter Button to get the details of the student");
        updateMessageLabel.setOpaque(true);
        updateRecordPane.add(updateMessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 25));

        jPanel2.add(updateRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 660, 504));

        addRecordPanel.setBackground(new java.awt.Color(44, 62, 80));
        addRecordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Student Record");
        addRecordPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student ID");
        addRecordPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        addID.setBackground(new java.awt.Color(44, 62, 80));
        addID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addID.setForeground(new java.awt.Color(255, 255, 255));
        addID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIDActionPerformed(evt);
            }
        });
        addRecordPanel.add(addID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 250, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Full Name");
        addRecordPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        addName.setBackground(new java.awt.Color(44, 62, 80));
        addName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addName.setForeground(new java.awt.Color(255, 255, 255));
        addName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameActionPerformed(evt);
            }
        });
        addRecordPanel.add(addName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 250, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mobile No");
        addRecordPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        addMobile.setBackground(new java.awt.Color(44, 62, 80));
        addMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addMobile.setForeground(new java.awt.Color(255, 255, 255));
        addMobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMobileActionPerformed(evt);
            }
        });
        addMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addMobileKeyTyped(evt);
            }
        });
        addRecordPanel.add(addMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 250, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Course");
        addRecordPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        addCourse.setBackground(new java.awt.Color(44, 62, 80));
        addCourse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addCourse.setForeground(new java.awt.Color(255, 255, 255));
        addCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });
        addRecordPanel.add(addCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 250, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Department");
        addRecordPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        addDepartment.setBackground(new java.awt.Color(44, 62, 80));
        addDepartment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addDepartment.setForeground(new java.awt.Color(255, 255, 255));
        addDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepartmentActionPerformed(evt);
            }
        });
        addRecordPanel.add(addDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 250, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Father's Name");
        addRecordPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        addFather.setBackground(new java.awt.Color(44, 62, 80));
        addFather.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addFather.setForeground(new java.awt.Color(255, 255, 255));
        addFather.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addFather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFatherActionPerformed(evt);
            }
        });
        addRecordPanel.add(addFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 250, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("E-mail");
        addRecordPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        addEmail.setBackground(new java.awt.Color(44, 62, 80));
        addEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmail.setForeground(new java.awt.Color(255, 255, 255));
        addEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmailActionPerformed(evt);
            }
        });
        addRecordPanel.add(addEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 250, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Address");
        addRecordPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        addAdress.setBackground(new java.awt.Color(44, 62, 80));
        addAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addAdress.setForeground(new java.awt.Color(255, 255, 255));
        addAdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        addAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdressActionPerformed(evt);
            }
        });
        addRecordPanel.add(addAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 250, 30));

        addClear.setBackground(new java.awt.Color(26, 188, 156));
        addClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addClear.setForeground(new java.awt.Color(255, 255, 255));
        addClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addClear.setText("Clear");
        addClear.setOpaque(true);
        addClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addClearMouseReleased(evt);
            }
        });
        addRecordPanel.add(addClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 250, 32));

        addSubmit.setBackground(new java.awt.Color(26, 188, 156));
        addSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addSubmit.setForeground(new java.awt.Color(255, 255, 255));
        addSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addSubmit.setText("Submit");
        addSubmit.setOpaque(true);
        addSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addSubmitMouseReleased(evt);
            }
        });
        addRecordPanel.add(addSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 250, 32));

        messageLabel.setBackground(new java.awt.Color(17, 125, 104));
        messageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 255, 255));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("Fill the details of student to add the record to the database");
        messageLabel.setOpaque(true);
        addRecordPanel.add(messageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 25));

        jPanel2.add(addRecordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 660, 504));

        deletePanel.setBackground(new java.awt.Color(44, 62, 80));
        deletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        messageLabel1.setBackground(new java.awt.Color(17, 125, 104));
        messageLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        messageLabel1.setForeground(new java.awt.Color(255, 255, 255));
        messageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel1.setText("Fill the details of student to add the record to the database");
        messageLabel1.setOpaque(true);
        deletePanel.add(messageLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 25));

        jLabel25.setBackground(new java.awt.Color(26, 188, 156));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Email");
        jLabel25.setAlignmentX(0.5F);
        jLabel25.setOpaque(true);
        deletePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 126, 120, 30));

        jLabel26.setBackground(new java.awt.Color(26, 188, 156));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Course");
        jLabel26.setAlignmentX(0.5F);
        jLabel26.setOpaque(true);
        deletePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 126, 120, 30));

        jLabel27.setBackground(new java.awt.Color(26, 188, 156));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Dept");
        jLabel27.setAlignmentX(0.5F);
        jLabel27.setOpaque(true);
        deletePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 126, 120, 30));

        jLabel28.setBackground(new java.awt.Color(26, 188, 156));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("ID");
        jLabel28.setAlignmentX(0.5F);
        jLabel28.setOpaque(true);
        deletePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 126, 120, 30));

        jLabel7.setBackground(new java.awt.Color(26, 188, 156));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");
        jLabel7.setAlignmentX(0.5F);
        jLabel7.setOpaque(true);
        deletePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 126, 120, 30));

        jScrollPane2.setBackground(new java.awt.Color(26, 188, 156));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        jTable2.setBackground(new java.awt.Color(44, 62, 80));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Course", "Department", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(44, 62, 80));
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(17, 125, 104));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.setSurrendersFocusOnKeystroke(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        deletePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 600, 340));

        jLabel29.setBackground(new java.awt.Color(26, 188, 156));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Delete");
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel29MouseReleased(evt);
            }
        });
        deletePanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 110, 32));

        deleteField.setBackground(new java.awt.Color(44, 62, 80));
        deleteField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteField.setForeground(new java.awt.Color(255, 255, 255));
        deleteField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        deleteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFieldActionPerformed(evt);
            }
        });
        deleteField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deleteFieldKeyReleased(evt);
            }
        });
        deletePanel.add(deleteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 300, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Search");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        deletePanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 30));

        jLabel31.setBackground(new java.awt.Color(26, 188, 156));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Refresh");
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel31MouseReleased(evt);
            }
        });
        deletePanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 110, 32));

        jPanel2.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 660, 504));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 900, 504));

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 36));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("–");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel18MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 30, 34));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 36));

        setSize(new java.awt.Dimension(900, 536));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        System.exit(0);
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

    private void jLabel18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseReleased
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseReleased

    private void logoutLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseReleased
       this.dispose();       
       new LoginUI().setVisible(true);
       
    }//GEN-LAST:event_logoutLabelMouseReleased

    private void addIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addIDActionPerformed

    private void addNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNameActionPerformed

    private void addMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMobileActionPerformed

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCourseActionPerformed

    private void addDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDepartmentActionPerformed

    private void addFatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFatherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFatherActionPerformed

    private void addEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmailActionPerformed

    private void addAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAdressActionPerformed

    private void addSubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSubmitMouseReleased
        String name, id, dept, course, mobile, address, father, email;
        String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        name = addName.getText().trim();
        id = addID.getText().trim();
        dept = addDepartment.getText().trim();
        course = addCourse.getText().trim();
        mobile = addMobile.getText().trim();
        address = addAdress.getText().trim();
        father = addFather.getText().trim();
        email = addEmail.getText().trim();
        
        if(name.isEmpty() || id.isEmpty() || dept.isEmpty() || course.isEmpty() || mobile.isEmpty() || address.isEmpty() ||father.isEmpty() || email.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "All fields are mandatory to fill", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if (!email.matches(EMAIL_PATTERN)) 
        {
            JOptionPane.showMessageDialog(rootPane, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
       
        }
        else           
        {
            String sql = "INSERT INTO STUDENT VALUES ( '" + id + "', '" + name + "', '" + mobile + "', '" + course + "', '"
                    + dept + "', '" + father + "', '" + email + "', '" + address + "');";                                                                                       
                    
            try
            {
                dbUtils.connectToDataBase();
                Statement stmt = DataBaseUtils.con.createStatement();
                int executeUpdate = stmt.executeUpdate(sql);
                
              if(executeUpdate == 1)
              {
                  messageLabel.setText("Record is successfully inserted to the database");
                  messageLabel.setBackground(new Color(39, 174, 96));
//                  model.fireTableDataChanged();
                  
              }
              else
              {
                  messageLabel.setText("Failed to insert the record to the database");
              }
              
            } 
            catch (SQLException e) 
            {
                messageLabel.setText("Error : " + e.getMessage());
                messageLabel.setBackground(new Color(231, 76, 60));
               // e.printStackTrace();
            }                        
        }
        
    }//GEN-LAST:event_addSubmitMouseReleased

    private void addClearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClearMouseReleased
        
        addName.setText("");
        addID.setText("");
        addDepartment.setText("");
        addCourse.setText("");
        addMobile.setText("");
        addAdress.setText("");
        addFather.setText("");
        addEmail.setText("");
        
        messageLabel.setText("Fill the details of student to add the record to the database");
        messageLabel.setBackground(new Color(17,125,104));

    }//GEN-LAST:event_addClearMouseReleased

    private void searchLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLabelMouseReleased
        searchRecordPanel.setVisible(true);
        addRecordPanel.setVisible(false);
        deletePanel.setVisible(false);
        updateRecordPane.setVisible(false);
        fillTabelData(jTable1);

    }//GEN-LAST:event_searchLabelMouseReleased

    private void addLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseReleased
     addRecordPanel.setVisible(true);
     searchRecordPanel.setVisible(false);
     deletePanel.setVisible(false);
     updateRecordPane.setVisible(false);
    }//GEN-LAST:event_addLabelMouseReleased

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    
    
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       
    if(evt.getClickCount() >= 2)
    {
          int selectedRow = jTable1.getSelectedRow();
      id = (String) model.getValueAt(selectedRow, 0);
      
      StudentInfo studentInfo = new StudentInfo();      
      studentInfo.setStudentID(id); 
      
      StudentInfoDialog studentInfoDialog = new StudentInfoDialog(this, true);
      studentInfoDialog.setVisible(true);
    }
      
           
    }//GEN-LAST:event_jTable1MouseReleased

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
                if(evt.getKeyCode() == 10)
        {
             searchRecord(searchField, jTable1);
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void jLabel24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseReleased
      
        fillTabelData(jTable1);
    }//GEN-LAST:event_jLabel24MouseReleased

    private void addMobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addMobileKeyTyped
        
      if(addMobile.getText().length() >=10)
      {
        getToolkit().beep();
        evt.consume();
      }
       else
      {
          char c = evt.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||  (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) 
      {
        getToolkit().beep();
        evt.consume();
      }

      }
              
    }//GEN-LAST:event_addMobileKeyTyped

    private void aboutLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutLabelMouseReleased
        new AboutDialog(this, true).setVisible(true);
    }//GEN-LAST:event_aboutLabelMouseReleased

    private void deleteLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseReleased
      fillTabelData(jTable2);
      deletePanel.setVisible(true);
      searchRecordPanel.setVisible(false);
      addRecordPanel.setVisible(false);
       updateRecordPane.setVisible(false);
    }//GEN-LAST:event_deleteLabelMouseReleased

    private void deleteFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteFieldKeyReleased
        if(evt.getKeyCode() == 10)
        {
             searchRecord(deleteField, jTable2);
        
        }
        
        //System.out.println(JOptionPane.WHEN_IN_FOCUSED_WINDOW);
        
    }//GEN-LAST:event_deleteFieldKeyReleased

    private void deleteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFieldActionPerformed

    }//GEN-LAST:event_deleteFieldActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseReleased

    private void jLabel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseReleased
       int row = jTable2.getSelectedRow();
       String id = (String) jTable2.getValueAt(row, 0);
       deleteRecord(id, row);       
    }//GEN-LAST:event_jLabel29MouseReleased

    private void deleteRecord(String studentID, int selectedRow)
    {
         
        String name = (String) jTable2.getValueAt(selectedRow, 1);
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(rootPane, "Are sure you want to delete "  + "'"  + name + "'" + " Record ?");
        
        if(showConfirmDialog == JOptionPane.YES_OPTION)
        {
           
        String sql = "delete from student where id ='" + studentID + "';";
        
        try 
        {
            dbUtils.connectToDataBase();
        
                model = (DefaultTableModel) jTable2.getModel();
                
                model.removeRow(selectedRow);                
                                     
                Statement stmt = DataBaseUtils.con.createStatement();
                
                int executeUpdate = stmt.executeUpdate(sql);
                
               if(executeUpdate == 1)
                {
                    JOptionPane.showMessageDialog(rootPane, "Record Deletion Successful");
                }
                else
                {
                     JOptionPane.showMessageDialog(rootPane, "Record not found", "Warning" ,JOptionPane.ERROR_MESSAGE);
                }
 

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
        }
    }
    
    
    private void deleteFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteFieldKeyPressed
      
        customSearchRecord(deleteField, jTable2);     
    }//GEN-LAST:event_deleteFieldKeyPressed

    private void jLabel31MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseReleased
             fillTabelData(jTable2);
    }//GEN-LAST:event_jLabel31MouseReleased

    private void updateFatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFatherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFatherActionPerformed

    private void updateEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateEmailActionPerformed

    private void updateAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateAdressActionPerformed

    private void updateClearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateClearMouseReleased
       updateClearButton();
    }//GEN-LAST:event_updateClearMouseReleased

    private void updateClearButton()
    {
         updateName.setText("");
        updateMobile.setText("");
        updateID.setText("");
        updateFather.setText("");
        updateEmail.setText("");
        updateAdress.setText("");
        updateMessageLabel.setText("Enter Student ID and hit Enter Button to get the details of the student");
        updateMessageLabel.setBackground(new Color(17, 125, 104));
    }
    
    private void updateSubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateSubmitMouseReleased
         updateRecord(updateID.getText().trim());
    }//GEN-LAST:event_updateSubmitMouseReleased

    private void updateRecord(String updateSearch)
    {
        
        String name = updateName.getText();
        String mobile = updateMobile.getText();
        String father = updateFather.getText();
        String email = updateEmail.getText();
        String address = updateAdress.getText();
        
        String sql = "update student set name = '" + name + "', mobile ='" + mobile + "', father = '" + father + "', email = '" + email + "', address = '" + address  + "' where id ='" + updateSearch + "';";
        
        try 
        {
            dbUtils.connectToDataBase();
                               
            Statement stmt = DataBaseUtils.con.createStatement();
            int executeUpdate = stmt.executeUpdate(sql);
            
            if(executeUpdate == 1)
              {
                  updateMessageLabel.setText("Record is successfully updated to the database");
                  updateMessageLabel.setBackground(new Color(39, 174, 96));
                  model.fireTableDataChanged();
                  updateClearButton();
              }
              else
              {
                  updateMessageLabel.setText("Failed to update the record.");
              }
                                         
            //JOptionPane.showMessageDialog(rootPane, "Record not found\nTry with different Student ID", "Record unavailable", JOptionPane.INFORMATION_MESSAGE);
       
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
    }
    
    
    
    private void updateMobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateMobileKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMobileKeyTyped

    private void updateMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMobileActionPerformed

    private void updateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNameActionPerformed

    private void updateIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateIDActionPerformed

    private void updateLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateLabelMouseReleased
        updateRecordPane.setVisible(true);
        deletePanel.setVisible(false);
      searchRecordPanel.setVisible(false);
      addRecordPanel.setVisible(false);
    }//GEN-LAST:event_updateLabelMouseReleased

    private void updateIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateIDKeyReleased
        if(evt.getKeyCode() == 10)
        {
            getUpdateRecord(updateID.getText().trim());
        }
    }//GEN-LAST:event_updateIDKeyReleased

    private void jLabel35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseReleased
       printTable(jTable1, "Student Record List", "Page - {0}");
    }//GEN-LAST:event_jLabel35MouseReleased

    private void infoLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLabelMouseReleased
        new AboutAppDialog(this, true).setVisible(true);
    }//GEN-LAST:event_infoLabelMouseReleased

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        try 
        {
            exportTable(jTable1, new File("D:\\tabledata.xls"));
        } 
        catch (IOException ex) 
        {
           JOptionPane.showMessageDialog(rootPane, "Unable to export table\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabel9MouseReleased

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
       
    }//GEN-LAST:event_searchFieldKeyTyped

    private void getUpdateRecord(String searchText)
    {
                
        String sql = "select * from student where id='" + searchText + "';";
        
        try 
        {
            dbUtils.connectToDataBase();
        
              
                                     
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                if(rs.next())
                {
                    updateAdress.setText(rs.getString("address"));
                    updateName.setText( rs.getString("name"));
                    updateEmail.setText(rs.getString("email"));
                    updateFather.setText(rs.getString("father"));
                    updateMobile.setText(rs.getString("mobile"));
                    
                }
                else
                {
                    //JOptionPane.showMessageDialog(rootPane, "Record not found\nTry with different Student ID", "Record unavailable", JOptionPane.WARNING_MESSAGE);
                    updateMessageLabel.setText("Record not found");
                    updateMessageLabel.setBackground(new Color(222, 83, 71));
                    
                    
                }
        

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
    }
    
    private void searchRecord(JTextField search, JTable jtable)
    {
        String searchText = search.getText();
        
        String sql = "select * from student where id like '" + searchText + "%';";
        
        try 
        {
            dbUtils.connectToDataBase();
        
                model = (DefaultTableModel) jtable.getModel();
                while(jtable.getRowCount()>0)
                {
                    model.removeRow(0);
                }
                                     
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                if(rs.next())
                {
                    model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("course"), rs.getString("dept"), rs.getString("email")});
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Record not found\nTry with different Student ID", "Record unavailable", JOptionPane.WARNING_MESSAGE);
                    
                    
                }
        

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
      
    }
    
     private void customSearchRecord(JTextField search, JTable jtable)
    {
        String searchText = search.getText();
        
        String sql = "select * from student where id like '" + searchText + "%';";
        
        try 
        {
            dbUtils.connectToDataBase();
        
                model = (DefaultTableModel) jtable.getModel();
                while(jtable.getRowCount()>0)
                {
                    model.removeRow(0);
                }
                                     
                Statement stmt = DataBaseUtils.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                if(rs.next())
                {
                    model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("course"), rs.getString("dept"), rs.getString("email")});
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Record not found\nTry with different Student ID", "Record unavailable", JOptionPane.INFORMATION_MESSAGE);
                    
                }
        

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
      
    }
    
    public static void main(String args[]) {
       
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JTextField addAdress;
    private javax.swing.JLabel addClear;
    private javax.swing.JTextField addCourse;
    private javax.swing.JTextField addDepartment;
    private javax.swing.JTextField addEmail;
    private javax.swing.JTextField addFather;
    private javax.swing.JTextField addID;
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField addMobile;
    private javax.swing.JTextField addName;
    private javax.swing.JPanel addRecordPanel;
    private javax.swing.JLabel addSubmit;
    private javax.swing.JTextField deleteField;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JLabel infoLabel;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel messageLabel1;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel searchMessageLabel;
    private javax.swing.JPanel searchRecordPanel;
    private javax.swing.JTextField updateAdress;
    private javax.swing.JLabel updateClear;
    private javax.swing.JTextField updateEmail;
    private javax.swing.JTextField updateFather;
    private javax.swing.JTextField updateID;
    private javax.swing.JLabel updateLabel;
    private javax.swing.JLabel updateMessageLabel;
    private javax.swing.JTextField updateMobile;
    private javax.swing.JTextField updateName;
    private javax.swing.JPanel updateRecordPane;
    private javax.swing.JLabel updateSubmit;
    // End of variables declaration//GEN-END:variables
}
