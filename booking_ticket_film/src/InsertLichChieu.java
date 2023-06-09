
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author khoa
 */
public class InsertLichChieu extends javax.swing.JFrame {
    
    
    private static final String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
    private static final String username = "root";
    private static final String password = "khoa";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    int q, i,id, deletiItem;
    
    private String MaPhim = "";
    private String MaRap = "";
    private int idLichChieu;
    
//    ==============================================START_FUNCTION==========================================
    
    public void upDateDB(){
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("SELECT * FROM LichChieu, Phim where lichChieu.MaPhim = Phim.MaPhim");
            rs = statement.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel records = (DefaultTableModel) LichChieu_Table.getModel();
            records.setRowCount(0);
            int count = 0;
            while(rs.next()){
                count ++;
                Vector columnData = new Vector();
                for ( i = 1; i <= q; i++){
//                    columnData.add(rs.getString("idLichChieu"));
                    columnData.add(count);
                    columnData.add(rs.getString("TenPhim"));
                    columnData.add(rs.getString("MaRap"));
                    columnData.add(rs.getString("NgayChieu"));
                    columnData.add(rs.getString("BatDau"));
                }
                records.addRow(columnData);
            }
            
            
            statement = connection.prepareStatement("SELECT * FROM PHIM");
            rs = statement.executeQuery();
            
            stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            records = (DefaultTableModel) Phim_Table.getModel();
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
            
            statement = connection.prepareStatement("SELECT * FROM RAPCHIEU");
            rs = statement.executeQuery();
            
            stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            records = (DefaultTableModel) Rap_Table.getModel();
            records.setRowCount(0);
            
            while(rs.next()){
                Vector columnData = new Vector();
                for ( i = 1; i <= q; i++){
                    columnData.add(rs.getString("MaRap"));
                    columnData.add(rs.getString("SoLuongGhe"));           
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
     * Creates new form InsertLichChieu
     */
    public InsertLichChieu() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cập nhật lịch chiếu");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LichChieu_Table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Phim = new javax.swing.JTextField();
        Rap = new javax.swing.JTextField();
        BatDau = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Phim_Table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Rap_Table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Ngay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CẬP NHẬT LỊCH CHIẾU");

        LichChieu_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Lịch Chiếu", "Phim", "Rạp", "Ngày chiếu", "Bắt đầu"
            }
        ));
        LichChieu_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LichChieu_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(LichChieu_Table);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Phim");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Rạp");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Bắt đầu");

        Rap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RapActionPerformed(evt);
            }
        });

        Phim_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Phim", "Tên Phim", "Thể Loại", "Thời lượng"
            }
        ));
        Phim_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phim_TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Phim_Table);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("DANH SÁCH PHIM ĐANG CHIẾU");

        Rap_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã rạp", "Số Ghế"
            }
        ));
        Rap_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rap_TableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Rap_Table);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("RẠP");

        Insert.setText("Thêm");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        Update.setText("Sửa");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Xóa");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Print.setText("In");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        Cancel.setText("Hủy");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Ngày");

        Ngay.setText("YYYY-MM-DD");
        Ngay.setToolTipText("mm/dd/yyyy");
        Ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NgayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BatDau)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Phim)
                            .addComponent(Rap)
                            .addComponent(Ngay))))
                .addGap(74, 74, 74))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cancel, Delete, Insert, Print, Update});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Phim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Rap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Insert)
                        .addComponent(Update))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Print)
                        .addComponent(Delete)
                        .addComponent(Cancel)))
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cancel, Delete, Insert, Print, Update});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RapActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_formWindowActivated

    private void Phim_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phim_TableMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
        int SelectedRows = Phim_Table.getSelectedRow();
        
        Phim.setText(records.getValueAt(SelectedRows, 1).toString());
//        TenPhim = records.getValueAt(SelectedRows, 0).toString();
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("Select * from phim where tenphim = ?");
            statement.setString(1, Phim.getText());
            rs = statement.executeQuery();
            while(rs.next()){
                MaPhim = rs.getString("MaPhim");
//                JOptionPane.showMessageDialog(null, MaPhim);
            }
            connection.close();
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_Phim_TableMouseClicked

    private void Rap_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rap_TableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel records = (DefaultTableModel) Rap_Table.getModel();
        int SelectedRows = Rap_Table.getSelectedRow();
        
        Rap.setText(records.getValueAt(SelectedRows, 0).toString());
        MaRap = records.getValueAt(SelectedRows, 0).toString();
    }//GEN-LAST:event_Rap_TableMouseClicked

    private void LichChieu_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LichChieu_TableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel records = (DefaultTableModel) LichChieu_Table.getModel();
        int SelectedRows = LichChieu_Table.getSelectedRow();
        
        Phim.setText(records.getValueAt(SelectedRows, 1).toString());
        Rap.setText(records.getValueAt(SelectedRows, 2).toString());
        BatDau.setText(records.getValueAt(SelectedRows, 4).toString());
        Ngay.setText(records.getValueAt(SelectedRows, 3).toString());
        MaRap = records.getValueAt(SelectedRows, 2).toString();
//        idLichChieu = Integer.parseInt(records.getValueAt(SelectedRows, 0).toString());
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("Select * from phim where tenphim = ?");
            statement.setString(1, Phim.getText());
            rs = statement.executeQuery();
            while(rs.next()){
                MaPhim = rs.getString("MaPhim");
//                JOptionPane.showMessageDialog(null, MaPhim);
            }
            
            statement = connection.prepareStatement("SELECT * FROM LichChieu where MaRap = ? and MaPhim = ? and NgayChieu = ? and BatDau = ?");
            statement.setString(1, Rap.getText());
            statement.setString(2, MaPhim);
            statement.setString(3,Ngay.getText());
            statement.setString(4, BatDau.getText());
            rs = statement.executeQuery();
            
            while(rs.next()){
                idLichChieu = rs.getInt("idLichChieu");
            }
            connection.close();
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_LichChieu_TableMouseClicked

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        Phim.setText("");
        Rap.setText("");
        BatDau.setText("");
    }//GEN-LAST:event_CancelActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("page (0, number, interger)");
        
        try{
            Phim_Table.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(java.awt.print.PrinterException ex){
            System.err.format("No Printer found", ex.getMessage());
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("CALL XoaLichChieu(?,?,?,?)");
//            statement.setInt(1, idLichChieu);
            statement.setString(1, Rap.getText());
            statement.setString(2, Phim.getText());
            statement.setDate(3, Date.valueOf(Ngay.getText()));
            statement.setString(4, BatDau.getText());
            statement.executeUpdate();
            statement.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(this, "Xóa thành công");

            upDateDB();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("CALL SuaLichChieu(?,?,?,?,?)");
            statement.setInt(1, idLichChieu);
            statement.setString(2, MaPhim);
            statement.setString(3, Rap.getText());
            statement.setDate(4, Date.valueOf(Ngay.getText()));
            statement.setString(5, BatDau.getText());
            statement.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            
            upDateDB();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("Call ThemLichChieu(?,?,?,?)");            
            statement.setString(1, Rap.getText());
            statement.setString(2, Phim.getText());
            statement.setDate(3, Date.valueOf(Ngay.getText()));
            statement.setString(4, BatDau.getText());
            statement.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(this, "Thêm Thành công");
            upDateDB();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_InsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new Admin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NgayActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InsertLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InsertLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InsertLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InsertLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InsertLichChieu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BatDau;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Insert;
    private javax.swing.JTable LichChieu_Table;
    private javax.swing.JTextField Ngay;
    private javax.swing.JTextField Phim;
    private javax.swing.JTable Phim_Table;
    private javax.swing.JButton Print;
    private javax.swing.JTextField Rap;
    private javax.swing.JTable Rap_Table;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
