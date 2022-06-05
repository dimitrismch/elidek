package Screens;

/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;


import connection.ConnectSQL;


public class q1 {
    public JPanel q1;
    private JLabel lbl1q1;
    private JTable tbl1q1;
    private JButton btn1q1;
    private JScrollPane sp1q1;
    private JTextField txt1q1;
    private JTextField txt2q1;
    private JTextField txt3q1;
    private JTable tbl2q1;
    private JButton btn2q1;
    private JLabel lbl2q2;
    private JScrollPane sp2q1;
    private JLabel lbl3q1;
    private JTextField txt4q1;
    private JTable tbl3q1;
    private JButton btn3q1;
    private JScrollPane sp3q1;
    private JLabel lbltxt1;
    private JLabel lbltxt2;
    private JLabel lbltxt3;
    private JLabel lbltxt4;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onoma Programmatwn"};

    private DefaultTableModel model2 = new DefaultTableModel();;
    Object[] columns2 = {"Titloi Ergwn"};

    private DefaultTableModel model3 = new DefaultTableModel();;
    Object[] columns3 = {"Onomata Erevnitwn","Epitheta Erevniten"};
    public q1() {
        btn1q1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT onoma FROM programma");
                    // ps.setString(1,txtOnoma.getText());
                    //ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("onoma")};

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


                tbl1q1 = new JTable(model);
                sp1q1.setViewportView(tbl1q1);
            }
        });

        btn2q1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model2.setColumnIdentifiers(columns2);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT e.titlos as Titlos FROM ergo as e INNER JOIN stelexos as s ON e.stelexos_id = s.stelexos_id WHERE e.diarkeia = ? or  e.organismos_onoma=? or s.onoma = ?  ");

                    String z=new String();
                    z=txt1q1.getText();
                    int j=10000;


                    if(z.isEmpty()==false) {

                        j = Integer.parseInt(z);
                    }

                    //SimpleDateFormat format1=new SimpleDateFormat("yyyy/MM/dd");

                    //String z2=new String();

/*
                    if(z2.isEmpty()==false) {

                        z2=txt2q1.getText();
                   }
                    else
                       z2="3333/11/11";
*/
                   ps.setInt(1,j);
                   ps.setString(2,txt2q1.getText());
                   ps.setString(3,txt3q1.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("Titlos")};

                        //tblq1.addRow(row);
                        model2.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                tbl2q1 = new JTable(model2);
                sp2q1.setViewportView(tbl2q1);

            }
        });
        btn3q1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model3.setColumnIdentifiers(columns3);


                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT r.onoma as name, r.epitheto as surname  FROM erevnitis as r INNER JOIN doulevei as d ON r.erevnitis_id = d.erevnitis_id  WHERE d.ergo_titlos = ? ");
                    ps.setString(1,txt4q1.getText());


                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name"),rs.getString("surname")};


                        model3.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                tbl3q1 = new JTable(model3);
                sp3q1.setViewportView(tbl3q1);


            }
        });
    }
}
