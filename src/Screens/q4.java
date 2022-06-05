package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectSQL;
public class q4 {
    public JPanel q4;
    private JTable tblq4;
    private JButton btnq4;
    private JLabel lblq4;
    private JScrollPane spq4;


    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onomata Organismwn"};


    public q4() {
        btnq4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement(" SELECT first.organismos_onoma as name  FROM frequency AS first  INNER JOIN frequency AS second  ON first.organismos_onoma = second.organismos_onoma  WHERE first.y - second.y = 1 and first.organismos_onoma = second.organismos_onoma and first.freq = second.freq ");
                    //ps.setString(1,txtOnoma.getText());
                    //ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name")};

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


                tblq4 = new JTable(model);
                spq4.setViewportView(tblq4);
            }
        });

    }
}
