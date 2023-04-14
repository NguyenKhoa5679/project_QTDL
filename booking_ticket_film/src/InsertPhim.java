
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class InsertPhim extends javax.swing.JFrame {
    
    private static final String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
    private static final String username = "root";
    private static final String password = "khoa";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    int q, i,id, deletiItem;
    
    

    /**
     * Creates new form InsertPhim
     */
    public InsertPhim() {
        initComponents();
    }
    
//    ==============================================START_FUNCTION==========================================
    
    public void upDateDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.prepareStatement("SELECT * FROM PHIM");
            rs = statement.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
            records.setRowCount(0);
            
            while(rs.next()){
                Vector columnData = new Vector();
                for ( i = 1; i <= q; i++){
                    columnData.add(rs.getString("MaPhim"));
                    columnData.add(rs.getString("TenPhim"));
                    columnData.add(rs.getString("TheLoai"));
                    columnData.add(rs.getString("thoiLuong"));
                }
                records.addRow(columnData);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
//            System.out.print("Noi ket khong thanh cong");
//            ex.printStackTrace();
        }
    }
//    ==============================================END_FUNCTION==========================================
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Phim_Table = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        MaPhim = new javax.swing.JTextField();
        TenPhim = new javax.swing.JTextField();
        TheLoai = new javax.swing.JTextField();
        ThoiLuong = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(MaPhim);
        jLabel1.setText("Mã Phim");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(TenPhim);
        jLabel2.setText("Tên phim");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setLabelFor(TheLoai);
        jLabel3.setText("Thể loại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setLabelFor(ThoiLuong);
        jLabel4.setText("Thời lượng");

        Phim_Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Phim_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Phim", "Tên Phim", "Thể loại", "Thời lượng"
            }
        ));
        Phim_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phim_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Phim_Table);

        Add.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Add.setText("Thêm");
        Add.setAlignmentX(1.0F);
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Update.setText("Sửa");
        Update.setAlignmentX(1.0F);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Delete.setText("Xóa");
        Delete.setAlignmentX(1.0F);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Cancel.setText("Hủy");
        Cancel.setAlignmentX(1.0F);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        MaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaPhimActionPerformed(evt);
            }
        });

        TenPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenPhimActionPerformed(evt);
            }
        });

        ThoiLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThoiLuongActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        print.setText("In");
        print.setAlignmentX(1.0F);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("CẬP NHẬT PHIM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThoiLuong)
                            .addComponent(TheLoai)
                            .addComponent(TenPhim)
                            .addComponent(MaPhim)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MaPhim))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        try{
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           connection = DriverManager.getConnection(url, username, password);
//           statement = connection.prepareStatement("INSERT INTO PHIM (MaPhim, TenPhim, TheLoai, ThoiLuong) VALUE (?,?,?,?);");
            statement = connection.prepareStatement("CALL ThemPhim(?,?,?,?);");
            statement.setString(1, MaPhim.getText());
            statement.setString(2, TenPhim.getText());
            statement.setString(3, TheLoai.getText());
            statement.setString(4, ThoiLuong.getText());
            statement.executeUpdate();
           JOptionPane.showMessageDialog(this, "Record Added");
           upDateDB();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Record Added Fail");   
        }
//        catch(ClassNotFoundException ex){
//            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        catch(SQLException ex){
//            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_AddActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        MaPhim.setText("");
        TenPhim.setText("");
        TheLoai.setText("");
        ThoiLuong.setText("");
    }//GEN-LAST:event_CancelActionPerformed

    private void MaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaPhimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaPhimActionPerformed

    private void ThoiLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThoiLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThoiLuongActionPerformed

    private void TenPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenPhimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenPhimActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
            DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
            int SelectedRows = Phim_Table.getSelectedRow();
            String old_maphim = records.getValueAt(SelectedRows, 0).toString();
            statement = connection.prepareStatement("CALL sua_phim (?,?,?,?,?);");
            statement.setString(1,old_maphim);
            statement.setString(2, MaPhim.getText());
            statement.setString(3, TenPhim.getText());
            statement.setString(4, TheLoai.getText());
            statement.setString(5, ThoiLuong.getText());
            statement.executeUpdate();
           JOptionPane.showMessageDialog(this, "Record Updated");
           upDateDB();
        }
        catch(Exception ex){
//            JOptionPane.showMessageDialog(this, "Record Updated Fail");
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void Phim_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phim_TableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
        int SelectedRows = Phim_Table.getSelectedRow();
        
        MaPhim.setText(records.getValueAt(SelectedRows, 0).toString());
        TenPhim.setText(records.getValueAt(SelectedRows, 1).toString());
        TheLoai.setText(records.getValueAt(SelectedRows, 2).toString());
        ThoiLuong.setText(records.getValueAt(SelectedRows, 3).toString());
        
        
    }//GEN-LAST:event_Phim_TableMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_formWindowActivated

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
            int SelectedRows = Phim_Table.getSelectedRow();
            String old_maphim = records.getValueAt(SelectedRows, 0).toString();
            statement = connection.prepareStatement("Call Xoa_phim(?);");
            statement.setString(1,old_maphim);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Delete");
            upDateDB();
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("page (0, number, interger)");
        
        try{
            Phim_Table.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(java.awt.print.PrinterException ex){
            System.err.format("No Printer found", ex.getMessage());
        }
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertPhim().setVisible(true);
            }
        });
    }
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField MaPhim;
    private javax.swing.JTable Phim_Table;
    private javax.swing.JTextField TenPhim;
    private javax.swing.JTextField TheLoai;
    private javax.swing.JTextField ThoiLuong;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
