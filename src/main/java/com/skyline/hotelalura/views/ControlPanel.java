package com.skyline.hotelalura.views;

import com.skyline.hotelalura.models.Reservation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class ControlPanel extends JFrame {
    private JPanel contentPane;
    private JTextField txtSearch;
    private JTable guestTable;
    private JTable reservationTable;
    private DefaultTableModel modelo;
    private DefaultTableModel guestModel;
    private JLabel labelBack;
    private JLabel labelExit;
    private int xMouse, yMouse;

    public ControlPanel() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ControlPanel.class.getResource("/images/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtSearch = new JTextField();
        txtSearch.setBounds(536, 127, 193, 31);
        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("SYSTEM SEARCH");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 280, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        reservationTable = new JTable();
        reservationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reservationTable.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = (DefaultTableModel) reservationTable.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("Date Check In");
        modelo.addColumn("Date Check Out");
        modelo.addColumn("Value");
        modelo.addColumn("Payment Method");
        JScrollPane scroll_table = new JScrollPane(reservationTable);
        panel.addTab("Reservations", new ImageIcon(Objects.requireNonNull(ControlPanel.class.getResource("/images/reservado.png"))), scroll_table, null);
        scroll_table.setVisible(true);

        guestTable = new JTable();
        guestTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        guestTable.setFont(new Font("Roboto", Font.PLAIN, 16));
        guestModel = (DefaultTableModel) guestTable.getModel();
        guestModel.addColumn("ID");
        guestModel.addColumn("Name");
        guestModel.addColumn("Surname");
        guestModel.addColumn("Birth Date");
        guestModel.addColumn("Nationality");
        guestModel.addColumn("Phone");
        guestModel.addColumn("Reservation ID");
        JScrollPane scroll_tableHuespedes = new JScrollPane(guestTable);
        panel.addTab("Guests", new ImageIcon(Objects.requireNonNull(ControlPanel.class.getResource("/images/pessoas.png"))), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(ControlPanel.class.getResource("/images/Ha-100px.png"))));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnBack = new JPanel();
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Home frame = new Home();
                frame.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBack.setBackground(new Color(12, 138, 199));
                labelBack.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnBack.setBackground(Color.white);
                labelBack.setForeground(Color.black);
            }
        });
        btnBack.setLayout(null);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(0, 0, 53, 36);
        header.add(btnBack);

        labelBack = new JLabel("<");
        labelBack.setHorizontalAlignment(SwingConstants.CENTER);
        labelBack.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelBack.setBounds(0, 0, 53, 36);
        btnBack.add(labelBack);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnExit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnExit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnExit.setLayout(null);
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(857, 0, 53, 36);
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnSearch = new JPanel();
        btnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btnSearch.setLayout(null);
        btnSearch.setBackground(new Color(12, 138, 199));
        btnSearch.setBounds(748, 125, 122, 35);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnSearch);

        JLabel lblSearch = new JLabel("SEARCH");
        lblSearch.setBounds(0, 0, 122, 35);
        btnSearch.add(lblSearch);
        lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearch.setForeground(Color.WHITE);
        lblSearch.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEdit = new JPanel();
        btnEdit.setLayout(null);
        btnEdit.setBackground(new Color(12, 138, 199));
        btnEdit.setBounds(635, 508, 122, 35);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEdit);

        JLabel lblEdit = new JLabel("EDIT");
        lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
        lblEdit.setForeground(Color.WHITE);
        lblEdit.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEdit.setBounds(0, 0, 122, 35);
        btnEdit.add(lblEdit);

        JPanel btnDelete = new JPanel();
        btnDelete.setLayout(null);
        btnDelete.setBackground(new Color(12, 138, 199));
        btnDelete.setBounds(767, 508, 122, 35);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnDelete);

        JLabel lblDelete = new JLabel("DELETE");
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setForeground(Color.WHITE);
        lblDelete.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblDelete.setBounds(0, 0, 122, 35);
        btnDelete.add(lblDelete);
        setResizable(false);
    }

    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }
}
