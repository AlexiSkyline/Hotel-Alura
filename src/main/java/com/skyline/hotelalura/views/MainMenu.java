package com.skyline.hotelalura.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class MainMenu extends JFrame {

    private final JPanel contentPane;
    private final JLabel labelExit;
    public int xMouse, yMouse;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainMenu() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/images/aH-40px.png")));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 910, 537);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        Panel panel = new Panel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 910, 537);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel background = new JLabel("");
        background.setBounds(-50, 0, 732, 501);
        background.setIcon(new ImageIcon(Objects.requireNonNull(MainMenu.class.getResource("/images/menu-img.png"))));
        panel.add(background);

        JLabel logo = new JLabel("");
        logo.setBounds(722, 80, 150, 156);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(MainMenu.class.getResource("/images/aH-150px.png"))));
        panel.add(logo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 500, 910, 37);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel copyright = new JLabel("Developed by AlexiSkyline © 2023");
        copyright.setBounds(315, 11, 284, 19);
        copyright.setForeground(new Color(240, 248, 255));
        copyright.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(copyright);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
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
        panel.add(header);

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
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(857, 0, 53, 36);
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(754, 300, 83, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setBackground(SystemColor.window);
        panel.add(btnLogin);

        JLabel loginImage = new JLabel("");
        loginImage.setBounds(0, 0, 80, 70);
        btnLogin.add(loginImage);
        loginImage.setHorizontalAlignment(SwingConstants.CENTER);
        loginImage.setIcon(new ImageIcon(Objects.requireNonNull(MainMenu.class.getResource("/images/login.png"))));

        JLabel title = new JLabel("LOGIN");
        title.setBounds(754, 265, 83, 24);
        title.setBackground(SystemColor.window);
        panel.add(title);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(SystemColor.textHighlight);
        title.setFont(new Font("Roboto Light", Font.PLAIN, 20));
    }

    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
