package Screens;

import connection.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class q8 {
    public JPanel q8;
    private JLabel lblq8;
    private JTable tblq8;
    private JScrollPane spq8;
    private JButton btnq8;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onoma Erevniti","Epitheto Erevniti","Arithmos Ergwn","ID Erevniti"};


    public q8() {
        btnq8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement(" SELECT r.onoma as name, r.epitheto as surname ,count(d.ergo_titlos) as freq, r.erevnitis_id as id FROM doulevei AS d INNER JOIN erevnitis AS r ON d.erevnitis_id = r.erevnitis_id LEFT JOIN paradosi_paradoteou AS p ON p.ergo_titlos = d.ergo_titlos WHERE p.titlos_paradoteou is NULL GROUP BY r.erevnitis_id HAVING count(d.ergo_titlos)>=5 ");
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


                tblq8 = new JTable(model);
                spq8.setViewportView(tblq8);
            }

        });
    }
}
