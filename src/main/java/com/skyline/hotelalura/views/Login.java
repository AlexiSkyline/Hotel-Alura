package com.skyline.hotelalura.views;

import com.skyline.hotelalura.config.components.DaggerUserComponent;
import com.skyline.hotelalura.config.components.UserComponent;
import com.skyline.hotelalura.controllers.AuthController;
import com.skyline.hotelalura.views.validators.ItemForm;
import com.skyline.hotelalura.views.validators.validationOptions.LengthValidator;
import com.skyline.hotelalura.views.validators.validationOptions.RequiredValidator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.Objects;

public class Login extends JFrame {

    public final AuthController controller;
    private final JPanel contentPane;
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;
    public int xMouse, yMouse;
    private final JLabel labelExit;


    public Login() {
        UserComponent component = DaggerUserComponent.create();
        this.controller = component.buildSellerController();

        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 788, 527);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(12, 138, 199));
        panel_1.setBounds(484, 0, 304, 527);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel imgHotel = new JLabel("");
        imgHotel.setBounds(0, 0, 304, 538);
        panel_1.add(imgHotel);
        imgHotel.setIcon(new ImageIcon(Objects.requireNonNull(Login.class.getResource("/images/img-hotel-login-.png"))));

        JPanel btnExit = new JPanel();
        btnExit.setBounds(251, 0, 53, 36);
        panel_1.add(btnExit);
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
                btnExit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnExit.setBackground(new Color(12, 138, 199));
        btnExit.setLayout(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setForeground(SystemColor.text);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);

        this.txtUsername = new JTextField();
        this.txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (txtUsername.getText().equals("Enter your username")) {
                    txtUsername.setText("");
                    txtUsername.setForeground(Color.black);
                }
                if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
                    txtPassword.setText("********");
                    txtPassword.setForeground(Color.gray);
                }
            }
        });
        this.txtUsername.setFont(new Font("Roboto", Font.PLAIN, 16));
        this.txtUsername.setText("Enter your username");
        this.txtUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.txtUsername.setForeground(SystemColor.activeCaptionBorder);
        this.txtUsername.setBounds(65, 256, 324, 32);
        panel.add(this.txtUsername);
        this.txtUsername.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 120, 215));
        separator.setBounds(65, 292, 324, 2);
        panel.add(separator);

        JLabel labelTitulo = new JLabel("LOG IN");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        labelTitulo.setBounds(65, 149, 202, 26);
        panel.add(labelTitulo);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.textHighlight);
        separator_1.setBounds(65, 393, 324, 2);
        panel.add(separator_1);

        this.txtPassword = new JPasswordField();
        this.txtPassword.setText("********");
        this.txtPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (String.valueOf(txtPassword.getPassword()).equals("********")) {
                    txtPassword.setText("");
                    txtPassword.setForeground(Color.black);
                }
                if (txtUsername.getText().isEmpty()) {
                    txtUsername.setText("Enter your username");
                    txtUsername.setForeground(Color.gray);
                }
            }
        });
        this.txtPassword.setForeground(SystemColor.activeCaptionBorder);
        this.txtPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
        this.txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.txtPassword.setBounds(65, 353, 324, 32);
        panel.add(this.txtPassword);

        JLabel labelUsername = new JLabel("Username");
        labelUsername.setForeground(SystemColor.textInactiveText);
        labelUsername.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        labelUsername.setBounds(65, 219, 107, 26);
        panel.add(labelUsername);

        JLabel labelPassword = new JLabel("password");
        labelPassword.setForeground(SystemColor.textInactiveText);
        labelPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        labelPassword.setBounds(65, 316, 140, 26);
        panel.add(labelPassword);

        JPanel btnLogin = new JPanel();
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(SystemColor.textHighlight);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Login.this.login();
            }
        });
        btnLogin.setBackground(SystemColor.textHighlight);
        btnLogin.setBounds(65, 431, 122, 44);
        panel.add(btnLogin);
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setBounds(0, 0, 122, 44);
        btnLogin.add(lblNewLabel);
        lblNewLabel.setForeground(SystemColor.controlLtHighlight);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon(Objects.requireNonNull(Login.class.getResource("/images/lOGO-50PX.png"))));
        lblNewLabel_1.setBounds(65, 65, 48, 59);
        panel.add(lblNewLabel_1);

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
        header.setBackground(SystemColor.window);
        header.setBounds(0, 0, 784, 36);
        panel.add(header);
        header.setLayout(null);
    }

    private void login() {
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (this.isValidInput()) {
            try {
                boolean response = this.controller.login(username, password);

                if (response) {
                    Home home = new Home();
                    home.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog( null, "Incorrect username and/or password",
                            "Error Login", JOptionPane.WARNING_MESSAGE );
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog( null, "Error connecting to database",
                        "Error Login", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private boolean isValidInput() {
        if (this.txtUsername.getText().equals("Enter your username")) this.txtUsername.setText("");
        if (String.valueOf(this.txtPassword.getPassword()).equals("********")) this.txtPassword.setText("");

        ItemForm userNameItem = new ItemForm("Username", this.txtUsername.getText())
                .addValidator(new RequiredValidator())
                .addValidator(new LengthValidator(5, 20));

        ItemForm passwordItem = new ItemForm("Password", String.valueOf(this.txtPassword.getPassword()))
                .addValidator(new RequiredValidator())
                .addValidator(new LengthValidator(5, 16));

        if (!userNameItem.isValid()) {
            userNameItem.printMessage();
            this.txtUsername.requestFocus();
            return false;
        }

        if (!passwordItem.isValid()) {
            passwordItem.printMessage();
            this.txtPassword.requestFocus();
            return false;
        }

        return true;
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
