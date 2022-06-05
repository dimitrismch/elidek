package Screens;

import connection.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class q5 {
    public JPanel q5;
    private JLabel lblq5;
    private JTable tblq5;
    private JScrollPane spq5;
    private JButton btnq5;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Erevnitiko Pedio A","Erevnitiko Pedio B","Sixnotita"};


    public q5() {
        btnq5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement(" SELECT first.epistimoniko_pedio_onoma as name1, second.epistimoniko_pedio_onoma as name2, COUNT(1) as freq FROM afora_pedio AS first INNER JOIN afora_pedio AS second ON first.ergo_titlos = second.ergo_titlos  WHERE first.epistimoniko_pedio_onoma < second.epistimoniko_pedio_onoma  GROUP BY first.epistimoniko_pedio_onoma, second.epistimoniko_pedio_onoma   ORDER BY COUNT(1) DESC  limit 3 ");
                    //ps.setString(1,txtOnoma.getText());
                    //ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name1"),rs.getString("name2"),rs.getString("freq")};

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


                tblq5 = new JTable(model);
                spq5.setViewportView(tblq5);
            }

        });
    }
}
