package Screens;

import connection.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class q2 {
    public JPanel q2;
    private JTable tbl1q2;
    private JTable tbl2q2;
    private JButton btn2q2;
    private JButton btn1q2;
    private JLabel lbl1q2;
    private JLabel lbl2q2;
    private JScrollPane sp1q2;
    private JScrollPane sp2q2;

    private DefaultTableModel model = new DefaultTableModel();
    Object[] columns = {"ID_Erevniti","Onoma Erevniti","Epitheto Erevniti","Titlos Ergou"};

    private DefaultTableModel model2 = new DefaultTableModel();
    Object[] columns2 = {"ID Erevniti","Onoma Erevniti","Epitheto Erevniti","Age"};


    public q2() {
        btn1q2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);


                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT r.erevnitis_id as id,r.onoma as name, r.epitheto as surname, d.ergo_titlos as titlos FROM doulevei as d INNER JOIN erevnitis AS r ON d.erevnitis_id = r.erevnitis_id ORDER BY(d.erevnitis_id) ");


                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("id"),rs.getString("name"),rs.getString("surname"),rs.getString("titlos")};

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


                tbl1q2 = new JTable(model);
                sp1q2.setViewportView(tbl1q2);
            }

        });


        btn2q2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model2.setColumnIdentifiers(columns2);


                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT erevnitis_id ,onoma,epitheto,ilikia FROM erevnitis WHERE ilikia > 60");


                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("erevnitis_id"),rs.getString("onoma"),rs.getString("epitheto"),rs.getString("ilikia")};


                        model2.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                tbl2q2 = new JTable(model2);
                sp2q2.setViewportView(tbl2q2);
            }

        });
    }
}
