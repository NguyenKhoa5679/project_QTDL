
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class DatVe extends javax.swing.JFrame {
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    int q, i,id, deletiItem;
    int MaKH = 1;
    
    

//    ==============================================START_FUNCTION==========================================
    
    public void upDateDB(){
        try{
            connection = new MySQLConnection().Connect();
            statement = connection.prepareStatement("SELECT * FROM Rapchieu inner join lichchieu using(marap) inner join phim  using(maphim) where tenphim = ? and marap = ? and batdau = ?");
            statement.setString(1, Phim_List.getSelectedItem().toString());
            statement.setString(2, Rap_List.getSelectedItem().toString());
            statement.setString(3, BatDau_List.getSelectedItem().toString());
            String TenPhim = Phim_List.getSelectedItem().toString();
            rs = statement.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel records = (DefaultTableModel) Phim_Table.getModel();
            records.setRowCount(0);
            int count = 0;
            while(rs.next()){
                count ++;
                Vector columnData = new Vector();
                for ( i = 1; i <= q; i++){
                    columnData.add(count);
                    columnData.add(rs.getString("TenPhim"));
                    columnData.add(rs.getString("TheLoai"));
                    columnData.add(rs.getString("NgayChieu"));
                    columnData.add(rs.getString("BatDau"));
                    columnData.add(rs.getString("ThoiLuong"));
                    columnData.add(rs.getString("MaRap"));
                }
                records.addRow(columnData);
            }
            connection.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Creates new form DatVe
     */
    public DatVe(String tenPhim, String MaRap, String batdau, int MaKH1) {
        initComponents();
        setLocationRelativeTo(null);
        this.Phim_List.setSelectedItem(tenPhim);
        this.Rap_List.setSelectedItem(MaRap);
        this.BatDau_List.setSelectedItem(batdau);
        this.MaKH = MaKH1;
       setTitle("Đặt vé");
    }
    
    public DatVe(int MaKh){
        initComponents();
        this.MaKH = MaKh;
        setLocationRelativeTo(null);
        setTitle("Đặt vé");
    }
    
    public DatVe(){
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Khách hàng");
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
        jLabel2 = new javax.swing.JLabel();
        Phim_List = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Phim_Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        Rap_List = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        BatDau_List = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Ngay_List = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ĐẶT VÉ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Phim");

        Phim_List.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Phim_ListItemStateChanged(evt);
            }
        });
        Phim_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Phim_ListActionPerformed(evt);
            }
        });

        Phim_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Phim", "Thể Loại", "Ngày chiếu", "Bắt đầu", "Thời lượng", "Rạp"
            }
        ));
        Phim_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phim_TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Phim_Table);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Rạp");

        Rap_List.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Rap_ListItemStateChanged(evt);
            }
        });
        Rap_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rap_ListActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Bắt đầu");

        BatDau_List.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BatDau_ListItemStateChanged(evt);
            }
        });
        BatDau_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatDau_ListActionPerformed(evt);
            }
        });

        jButton1.setText("Tiếp tục");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày");

        Ngay_List.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Ngay_ListItemStateChanged(evt);
            }
        });
        Ngay_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ngay_ListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ngay_List, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Phim_List, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rap_List, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BatDau_List, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Phim_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Rap_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Ngay_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BatDau_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        try{
            connection = new MySQLConnection().Connect();
            
            statement = connection.prepareStatement("SELECT * FROM PHIM");
            rs = statement.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
//            DefaultTableModel records = (DefaultTableModel) Phim_List.getModel();
            
            
            DefaultComboBoxModel records = (DefaultComboBoxModel) Phim_List.getModel();
            
//            for ( i = 1; i <= q; i++){}
            i = 0;
            records.removeAllElements();
            while(rs.next()){
                
                records.insertElementAt(rs.getString("TenPhim"), i);
                i++; 
            }
            records.setSelectedItem(' ');
            connection.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }   
    }//GEN-LAST:event_formWindowActivated

    private void Phim_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phim_TableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Phim_TableMouseClicked

    private void Phim_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Phim_ListActionPerformed
        // TODO add your handling code here:
        try{
            connection = new MySQLConnection().Connect();
            
            statement = connection.prepareStatement("SELECT distinct lichchieu.MaRap FROM Rapchieu inner join lichchieu using(marap) inner join phim using(maphim) where tenphim = ?");
            statement.setString(1, Phim_List.getSelectedItem().toString());
            rs = statement.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
//            DefaultTableModel records = (DefaultTableModel) Phim_List.getModel();
            
            
            DefaultComboBoxModel records = (DefaultComboBoxModel) Rap_List.getModel();
            
//            for ( i = 1; i <= q; i++){}
            i = 0;
            records.removeAllElements();
            while(rs.next()){
                records.insertElementAt(rs.getString("MaRap"), i);
                i++; 
            }
//            records.setSelectedItem('');
            connection.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_Phim_ListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        DatVeChonGhe dv = new DatVeChonGhe( 
//                Phim_List.getSelectedItem().toString(), 
//                Rap_List.getSelectedItem().toString(),
//                BatDau_List.getSelectedItem().toString(), 
//                this.MaKH
//        );
        DatVeChonGhe dv= new DatVeChonGhe(Phim_List.getSelectedItem().toString(), Rap_List.getSelectedItem().toString(), Ngay_List.getSelectedItem().toString(), BatDau_List.getSelectedItem().toString(), this.MaKH);   
        dv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int Huy = JOptionPane.YES_NO_OPTION;
        JOptionPane.showMessageDialog(this, "Bạn muôn hủy quá trình đặt vé?", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if(Huy == JOptionPane.YES_OPTION){
            this.dispose();
            new User(this.MaKH).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Phim_ListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Phim_ListItemStateChanged
        // TODO add your handling code here:
        DefaultComboBoxModel records = (DefaultComboBoxModel) BatDau_List.getModel();
        records.removeAllElements();
        records = (DefaultComboBoxModel) Ngay_List.getModel();
        records.removeAllElements();
        records = (DefaultComboBoxModel) Rap_List.getModel();
        records.removeAllElements();
    }//GEN-LAST:event_Phim_ListItemStateChanged

    private void BatDau_ListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BatDau_ListItemStateChanged
        // TODO add your handling code here:
//        upDateDB();
    }//GEN-LAST:event_BatDau_ListItemStateChanged

    private void Rap_ListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Rap_ListItemStateChanged
        // TODO add your handling code here:
        DefaultComboBoxModel records = (DefaultComboBoxModel) BatDau_List.getModel();
        records.removeAllElements();
        records = (DefaultComboBoxModel) Ngay_List.getModel();
        records.removeAllElements();
    }//GEN-LAST:event_Rap_ListItemStateChanged

    private void Rap_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rap_ListActionPerformed
        // TODO add your handling code here:
        if (Rap_List.getSelectedItem() == null || Phim_List.getSelectedItem() == null){
            DefaultComboBoxModel records = (DefaultComboBoxModel) Ngay_List.getModel();
            records.removeAllElements();
            records = (DefaultComboBoxModel) BatDau_List.getModel();
            records.removeAllElements();
        }
        else{
            try{
                connection = new MySQLConnection().Connect();

                statement = connection.prepareStatement("SELECT distinct ngaychieu FROM Rapchieu inner join lichchieu using(marap) inner join phim using(maphim) where tenphim = ? and marap = ?");
                statement.setString(1, Phim_List.getSelectedItem().toString());
                statement.setString(2, Rap_List.getSelectedItem().toString());
                rs = statement.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();

                q = stData.getColumnCount();

    //            DefaultTableModel records = (DefaultTableModel) Phim_List.getModel();


                DefaultComboBoxModel records = (DefaultComboBoxModel) Ngay_List.getModel();

    //            for ( i = 1; i <= q; i++){}
                i = 0;
                records.removeAllElements();
                while(rs.next()){
                    records.insertElementAt(rs.getString("NgayChieu"), i);
                    i++; 
                }
    //            records.setSelectedItem('');
                connection.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_Rap_ListActionPerformed

    private void Ngay_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ngay_ListActionPerformed
        // TODO add your handling code here:
        if (Phim_List.getSelectedItem() == null ||  Rap_List.getSelectedItem() == null || Ngay_List.getSelectedItem() == null){
            DefaultComboBoxModel records = (DefaultComboBoxModel) BatDau_List.getModel();
            records.removeAllElements();
        }
        else{
            try{
                connection = new MySQLConnection().Connect();

                statement = connection.prepareStatement("SELECT distinct * FROM Rapchieu inner join lichchieu using(marap) inner join phim using(maphim) where tenphim = ? and marap = ? and ngaychieu = ?");
                statement.setString(1, Phim_List.getSelectedItem().toString());
                statement.setString(2, Rap_List.getSelectedItem().toString());
                statement.setString(3, Ngay_List.getSelectedItem().toString());
                rs = statement.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();

                q = stData.getColumnCount();

    //            DefaultTableModel records = (DefaultTableModel) Phim_List.getModel();


                DefaultComboBoxModel records = (DefaultComboBoxModel) BatDau_List.getModel();

    //            for ( i = 1; i <= q; i++){}
                i = 0;
                records.removeAllElements();
                while(rs.next()){
                    records.insertElementAt(rs.getString("BatDau"), i);
                    i++; 
                }
    //            records.setSelectedItem('');
                connection.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_Ngay_ListActionPerformed

    private void BatDau_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatDau_ListActionPerformed
        // TODO add your handling code here:
        if(Phim_List.getSelectedItem() != null && Rap_List.getSelectedItem() != null && Ngay_List.getSelectedItem() != null && BatDau_List.getSelectedItem() != null)
            upDateDB();
    }//GEN-LAST:event_BatDau_ListActionPerformed

    private void Ngay_ListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Ngay_ListItemStateChanged
        // TODO add your handling code here:
        DefaultComboBoxModel records = (DefaultComboBoxModel) BatDau_List.getModel();
        records.removeAllElements();
    }//GEN-LAST:event_Ngay_ListItemStateChanged

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
//            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DatVe().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BatDau_List;
    private javax.swing.JComboBox<String> Ngay_List;
    private javax.swing.JComboBox<String> Phim_List;
    private javax.swing.JTable Phim_Table;
    private javax.swing.JComboBox<String> Rap_List;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
