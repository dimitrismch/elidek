package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.ConnectSQL;

public class q1c {
    public JPanel q1c;
    private JLabel lblq1c;
    private JTextField txtq1c;
    private JTable tblq1c;
    private JButton btnq1c;
    private JScrollPane spq1c;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onoma Erevniti"};

    public q1c() {
        btnq1c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);


                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT r.onoma as name FROM erevnitis as r INNER JOIN doulevei as d ON r.erevnitis_id = d.erevnitis_id  WHERE d.ergo_titlos = ? ");
                    ps.setString(1,txtq1c.getText());


                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name")};


                        model.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                tblq1c = new JTable(model);
                spq1c.setViewportView(tblq1c);

            }
        });
    }
}
