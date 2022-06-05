package Screens;

import connection.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class q6 {
    private JTable tblq6;
    private JButton btnq6;
    public JPanel q6;
    private JLabel lblq6;
    private JScrollPane spq6;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onoma Erevniti","Epitheto Erevniti","Arithmos Ergwn","ID Erevniti"};


    public q6() {
        btnq6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement(" SELECT r.onoma as name, r.epitheto as surname, count(e.titlos) as freq, r.erevnitis_id as id FROM doulevei AS d INNER JOIN ergo AS e ON d.ergo_titlos = e.titlos INNER JOIN erevnitis AS r ON d.erevnitis_id = r.erevnitis_id WHERE r.ilikia < 40 and e.liksi >= '2022/6/1' and e.enarksi <= '2022/6/1' GROUP BY r.erevnitis_id ORDER BY COUNT(e.titlos) DESC limit 5 ");
                    //ps.setString(1,txtOnoma.getText());
                    //ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name"),rs.getString("surname"),rs.getString("freq"),rs.getString("id")};

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


                tblq6 = new JTable(model);
                spq6.setViewportView(tblq6);
            }

        });
    }
}
