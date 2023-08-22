package com.skyline.hotelalura.views;

import com.skyline.hotelalura.views.reservation.ReservationRegister;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Home extends JFrame {

    private JPanel contentPane;
    private int xMouse, yMouse;
    private JLabel labelExit;
    private JLabel labelRegister;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Home frame = new Home();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Home() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 609);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

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

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(12, 138, 199));
        panelMenu.setBounds(0, 0, 257, 609);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(50, 58, 150, 150);
        panelMenu.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(Home.class.getResource("/images/aH-150px.png"))));

        JPanel btnRegister = new JPanel();
        btnRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegister.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnRegister.setBackground(new Color(12, 138, 199));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                ReservationRegister reservationRegister = new ReservationRegister();
                reservationRegister.setVisible(true);
                dispose();
            }
        });
        btnRegister.setBounds(0, 255, 257, 56);
        btnRegister.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnRegister);
        btnRegister.setLayout(null);

        this.labelRegister = new JLabel("Registro de reservas");
        this.labelRegister.setIcon(new ImageIcon(Objects.requireNonNull(Home.class.getResource("/images/reservado.png"))));
        this.labelRegister.setForeground(SystemColor.text);
        this.labelRegister.setBounds(25, 11, 205, 34);
        this.labelRegister.setFont(new Font("Roboto", Font.PLAIN, 18));
        this.labelRegister.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegister.add(this.labelRegister);

        JPanel btnSearch = new JPanel();
        btnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSearch.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnSearch.setBackground(new Color(12, 138, 199));
            }
            @SneakyThrows
            @Override
            public void mouseClicked(MouseEvent e) {
                ControlPanel controlPanel = new ControlPanel();
                controlPanel.setVisible(true);
                dispose();
            }
        });
        btnSearch.setBounds(0, 312, 257, 56);
        btnSearch.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnSearch);
        btnSearch.setLayout(null);

        JLabel lblReservationSearch = new JLabel("Search");
        lblReservationSearch.setIcon(new ImageIcon(Objects.requireNonNull(Home.class.getResource("/images/pessoas.png"))));
        lblReservationSearch.setBounds(27, 11, 200, 34);
        lblReservationSearch.setHorizontalAlignment(SwingConstants.LEFT);
        lblReservationSearch.setForeground(Color.WHITE);
        lblReservationSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnSearch.add(lblReservationSearch);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 219, 201, 2);
        panelMenu.add(separator);
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 944, 36);
        contentPane.add(header);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });

        btnExit.setLayout(null);
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(891, 0, 53, 36);
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel dateToday = new JPanel();
        dateToday.setBackground(new Color(118, 187, 223));
        dateToday.setBounds(256, 84, 688, 121);
        contentPane.add(dateToday);
        dateToday.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Hotel Alura Reservation System");
        lblNewLabel_1.setBounds(180, 11, 356, 42);
        dateToday.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));

        JLabel labelFecha = new JLabel("New label");
        labelFecha.setBounds(35, 64, 294, 36);
        dateToday.add(labelFecha);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
        Date currentDate = new Date();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(currentDate);
        labelFecha.setText("Today is " + date);

        JLabel lblNewLabel = new JLabel("Welcome");
        lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        lblNewLabel.setBounds(302, 234, 147, 46);
        contentPane.add(lblNewLabel);

        String descriptionText = "<html><body>Hotel reservation system. Control and manage optimally and easily <br> the flow of bookings and guests of the hotel   </body></html>";
        JLabel labelDescription = new JLabel(descriptionText);
        labelDescription.setFont(new Font("Roboto", Font.PLAIN, 17));

        labelDescription.setBounds(312, 291, 598, 66);
        contentPane.add(labelDescription);

        String descriptionText1 = "<html><body>This tool will allow you to keep a complete and detailed control of your bookings and guests, will have access to special tools for specific tasks such as:</body></html>";
        JLabel labelDescription_1 = new JLabel(descriptionText1);
        labelDescription_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescription_1.setBounds(311, 345, 569, 88);
        contentPane.add(labelDescription_1);

        JLabel lblNewLabel_3 = new JLabel("- Booking and Guest Registration");
        lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(312, 444, 295, 27);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("- Editing Existing Bookings and Guests");
        lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_1.setBounds(312, 482, 355, 27);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel("- Delete all types of records");
        lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_2.setBounds(312, 520, 295, 27);
        contentPane.add(lblNewLabel_3_2);
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
