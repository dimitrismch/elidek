package Screens;

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


import javax.swing.*;
import javax.swing.JTable;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Query_main {
    private JButton btnq1;
    private JButton btnq2;
    private JButton btnq3;
    private JButton btnq4;
    private JButton btnq5;
    private JButton btnq6;
    private JButton btnq7;
    private JButton btnq8;
    private JLabel lblq;
    public JPanel Query_main;

    public Query_main() {
        btnq1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 1");
                f.setSize(300,300);
                f.add(new q1().q1);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        btnq2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 2");
                f.setSize(300,300);
                f.add(new q2().q2);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        btnq3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 3");
                f.setSize(300,300);
                f.add(new q3().q3);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        btnq4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 4");
                f.setSize(300,300);
                f.add(new q4().q4);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        btnq5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 5");
                f.setSize(300,300);
                f.add(new q5().q5);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
        btnq6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 6");
                f.setSize(300,300);
                f.add(new q6().q6);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
        btnq7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f=new JFrame("ELIDEK QUERY 7");
                f.setSize(300,300);
                f.add(new q7().q7);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
        btnq8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame("ELIDEK QUERY 8");
                f.setSize(300,300);
                f.add(new q8().q8);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
    }
}
