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


public class q1b {
    public JPanel q1b;
    private JTextField txt1q1b;
    private JTextField txt2q1b;
    private JTextField txt3q1b;
    private JButton btnq1b;
    private JTable tblq1b;
    private JLabel lbl1q1b;
    private JLabel lbl2q1b;
    private JLabel lbl3q1b;
    private JScrollPane spq1b;


    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Titlos Ergou"};


    public q1b() {
        btnq1b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT e.titlos as Titlos FROM ergo as e INNER JOIN stelexos as s ON e.stelexos_id = s.stelexos_id WHERE e.diarkeia = 19 or  e.enarksi = '2022/4/6' or s.onoma = 'The Seven'  ");
                   //ps.setString(1,txt1q1b.getText());
                   // ps.setString(2,txt2q1b.getText());
                   // ps.setString(3,txt3q1b.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("Titlos")};

                        //tblq1.addRow(row);
                        model.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                tblq1b = new JTable(model);
                spq1b.setViewportView(tblq1b);
            }

        });
    }
}
