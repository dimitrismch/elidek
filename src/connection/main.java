package connection;

import Screens.Query_main;
import Screens.q1;
import Screens.q1b;
import Screens.q1c;
import Screens.q2;
import Screens.q3;
import Screens.q4;
import Screens.q5;
import Screens.q6;
import Screens.q7;
import Screens.q8;
/*
import javax.swing.*;
import javax.swing.JTable;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
*/


import javax.swing.*;
import javax.swing.JTable;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


public class main {

    public static void main(String[] args) {
        Connection con = ConnectSQL.get_connection();

        if (con != null) {
            // Do something.
            System.out.println("Ready!");
        }
        JFrame f=new JFrame("ELIDEK");
        f.setSize(300,300);
        f.add(new Query_main().Query_main);
        //f.add(new q1().q1);
        //f.add(new q1b().q1b);
        //f.add(new q1c().q1c);
        //f.add(new q2().q2);
        //f.add(new q3().q3);
        //f.add(new q4().q4);
        //f.add(new q5().q5);
        //f.add(new q6().q6);
        //f.add(new q7().q7);
        //f.add(new q8().q8);

        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }

}
