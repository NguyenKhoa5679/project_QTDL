import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author 
 */
public class JFrameDangNhap extends javax.swing.JFrame {
    private int MaKh;

    /**
     * Creates new form JFrameDangNhap
     */
    public JFrameDangNhap() {
        initComponents();
        setTitle("Đăng nhập đặt vé");
        setLocationRelativeTo(null);
//        this.getContentPane().setBackground(java.awt.Color.ORANGE); //Set màu cho background giao diện

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountName = txtacc.getText();
                String password = txtpass.getText(); //Vì passwordfield không hiển thị dạng chuỗi mà hiển thị dạng mảng kí tự

                boolean check_value_empty = check_value_empty(accountName, password);
                
                if (check_value_empty) {
                    JOptionPane.showMessageDialog(rootPane, "Chưa nhập tài khoản hoặc mật khẩu");
                } else {
                    int check = login_status(accountName, password);
                    if (check == 1) {
                        setVisible(false);
                        
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
//                                JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");
                                    if(Role.getSelectedItem() == "Khách hàng"){
                                        User user = new User(MaKh);
                                        user.setVisible(true);
                                    }
                                    else{
                                        Admin nv = new Admin();
                                        nv.setVisible(true);
                                    }
                            }
                      
                        });
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu không hợp lệ !");
                    }
                }

            }

        });
    }

    public boolean check_value_empty(String firstV, String secondV) {
        String pass_input = new String(secondV);
        if (!firstV.equals("") && !pass_input.equals("")) {
            return false;
        } else {
            return true;
        }

    }
    
    public static String getMd5(String input) 
    { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
     
    public int login_status(String accountName, String pass){
        JDBC_Connect connectJDBC = new JDBC_Connect();
        Connection conn = connectJDBC.connect();
        
        if(Role.getSelectedItem() == "Khách hàng"){
        
            String query_string = "select * from kh where username = ? and password = ?";

            PreparedStatement pstm = null;

            try {
                //Tạo đối tượng Statement
                pstm = conn.prepareStatement(query_string);
                String pass_input = new String(pass);
                //Truyền 2 giá trị vào tham số ? tương ứng
                pstm.setString(1, accountName);
                pstm.setString(2, getMd5(pass_input));

                //Thực hiện truy vấn và trả về đối tượng ResultSet

                ResultSet rs = pstm.executeQuery();
                int check = 0;
                //Duyệt lần lượt kết quả trả về
                while(rs.next()){
                    MaKh = rs.getInt("MaKh");
                    //Tồn tại 1 hàng dữ liệu
                    check = 1;
                }

                //Đóng kết nối
                conn.close();
                if(check == 1){
                    return 1;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            String query_string = "select * from nhanvien where username = ? and password = ?";

            PreparedStatement pstm = null;

            try {
                //Tạo đối tượng Statement
                pstm = conn.prepareStatement(query_string);
                String pass_input = new String(pass);
                //Truyền 2 giá trị vào tham số ? tương ứng
                pstm.setString(1, accountName);
                pstm.setString(2, getMd5(pass_input));

                //Thực hiện truy vấn và trả về đối tượng ResultSet

                ResultSet rs = pstm.executeQuery();
                int check = 0;
                //Duyệt lần lượt kết quả trả về
                while(rs.next()){
//                    MaKh = rs.getInt("MaKh");
                    //Tồn tại 1 hàng dữ liệu
                    check = 1;
                }

                //Đóng kết nối
                conn.close();
                if(check == 1){
                    return 1;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
            return 0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnlogin1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtacc = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        btnlogin2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Role_label = new javax.swing.JLabel();
        Role = new javax.swing.JComboBox<>();

        btnlogin1.setText("Đăng nhập");
        btnlogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 51, 51));
        setForeground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đăng Nhập ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tài khoản:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        txtacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccActionPerformed(evt);
            }
        });

        btnlogin.setText("Đăng nhập");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));

        btnlogin2.setText("Đăng ký");
        btnlogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin2ActionPerformed(evt);
            }
        });

        Role_label.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Role_label.setText("Vai trò:");

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng", "Quản trị viên" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Role_label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnlogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtacc)
                                    .addComponent(txtpass)
                                    .addComponent(Role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(145, 145, 145))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnlogin, btnlogin2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtacc))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Role_label)
                    .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnlogin, btnlogin2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogin1ActionPerformed

    private void btnlogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_btnlogin2ActionPerformed

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
//            java.util.logging.Logger.getLogger(JFrameDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameDangNhap().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel Role_label;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnlogin1;
    private javax.swing.JButton btnlogin2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtacc;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables

    private static final String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
    private static final String username = "root";
    private static final String password = "khoa";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    int q, i,id, deletiItem;
    
    
    
    private class JDBC_Connect {

        public JDBC_Connect() {
            
        }

        private Connection connect() {
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            return connection;
            }
            catch(HeadlessException | ClassNotFoundException | SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
