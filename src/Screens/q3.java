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

public class q3 {
    public JPanel q3;
    private JLabel q3lbl;
    private JTextField q3txt;
    private JScrollPane q3sp;
    private JTable q3tbl;
    private JButton btnaq3;
    private JScrollPane q3bsp;
    private JTable q3btbl;
    private JButton btnbq3;
    private JLabel q3blbl;
    private JLabel lbl1q2;

    private DefaultTableModel model = new DefaultTableModel();
    Object[] columns = {"Titlos Ergou"};

    private DefaultTableModel model2 = new DefaultTableModel();
    Object[] columns2 = {"Onoma Erevniti","Epitheto Erevniti"};

    public q3() {
        btnaq3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                model.setColumnIdentifiers(columns);

                Connection c = ConnectSQL.get_connection();

                PreparedStatement ps;
                ps = c.prepareStatement(" SELECT p.ergo_titlos as titlos FROM afora_pedio as p WHERE p.epistimoniko_pedio_onoma = ? ");

                ps.setString(1,q3txt.getText());

                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Object[] row = {rs.getString("titlos")};


                    model.addRow(row);
                }
                rs.close();
                ps.close();
            }catch (SQLClientInfoException er){
                er.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


                q3tbl = new JTable(model);
                q3sp.setViewportView(q3tbl);

            }
        });
        btnbq3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model2.setColumnIdentifiers(columns2);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement(" SELECT DISTINCT r.onoma as name, r.epitheto as surname FROM ergo as e INNER JOIN afora_pedio as f ON e.titlos = f.ergo_titlos INNER JOIN doulevei as d ON e.titlos = d.ergo_titlos INNER JOIN erevnitis as r ON r.erevnitis_id = d.erevnitis_id WHERE f.epistimoniko_pedio_onoma = ? and e.liksi >= '2022/6/1' and e.enarksi <= '2022/6/1' ");

                    ps.setString(1,q3txt.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name"),rs.getString("surname")};


                        model2.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                q3btbl = new JTable(model2);
                q3bsp.setViewportView(q3btbl);

            }
        });
    }
}
