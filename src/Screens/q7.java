package Screens;

import connection.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class q7 {
    public JPanel q7;
    private JLabel lblq7;
    private JTable tblq7;
    private JButton btnq7;
    private JScrollPane spq7;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Onoma Selexous","Onoma Organismou","Sinolo Posou"};

    public q7() {
        btnq7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    model.setColumnIdentifiers(columns);
                    //tblq1 = new JTable(model);

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT s.onoma as name, e.organismos_onoma as name2, SUM(e.poso) as sinolo FROM ergo as e INNER JOIN stelexos as s ON e.stelexos_id = s.stelexos_id INNER JOIN eteria as c ON e.organismos_onoma = c.organismos_onoma GROUP BY s.stelexos_id, e.organismos_onoma ORDER BY SUM(e.poso) DESC limit 5 ");
                    //ps.setString(1,txtOnoma.getText());
                    //ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name"),rs.getString("name2"),rs.getString("sinolo")};

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


                tblq7 = new JTable(model);
                spq7.setViewportView(tblq7);

            }
        });
    }
}
