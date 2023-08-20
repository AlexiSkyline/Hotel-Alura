package com.skyline.hotelalura.views.guest;

import com.skyline.hotelalura.views.Home;
import com.skyline.hotelalura.views.reservation.ReservationRegister;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.util.Objects;

public class GuestRegister extends JFrame  {

    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtPhoneNumber;
    private JTextField txtReservationNumber;
    private JDateChooser txtBirthDate;
    private JComboBox<Format> txtNationality;
    private JLabel labelExit;
    private JLabel labelBack;
    private int xMouse, yMouse;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GuestRegister frame = new GuestRegister();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GuestRegister() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(GuestRegister.class.getResource("/images/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);

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
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Home home = new Home();
                home.setVisible(true);
                dispose();
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
        btnExit.setBackground(Color.white);
        btnExit.setBounds(857, 0, 53, 36);
        contentPane.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(SystemColor.black);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        header.setLayout(null);
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnBack = new JPanel();
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReservationRegister frame = new ReservationRegister();
                frame.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBack.setBackground(Color.white);
                labelBack.setForeground(Color.black);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnBack.setBackground(new Color(12, 138, 199));
                labelBack.setForeground(Color.white);
            }
        });
        btnBack.setLayout(null);
        btnBack.setBackground(new Color(12, 138, 199));
        btnBack.setBounds(0, 0, 53, 36);
        header.add(btnBack);

        labelBack = new JLabel("<");
        labelBack.setHorizontalAlignment(SwingConstants.CENTER);
        labelBack.setForeground(Color.WHITE);
        labelBack.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelBack.setBounds(0, 0, 53, 36);
        btnBack.add(labelBack);

        txtName = new JTextField();
        txtName.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtName.setBounds(560, 135, 285, 33);
        txtName.setBackground(Color.WHITE);
        txtName.setColumns(10);
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtName);

        txtSurname = new JTextField();
        txtSurname.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtSurname.setBounds(560, 204, 285, 33);
        txtSurname.setColumns(10);
        txtSurname.setBackground(Color.WHITE);
        txtSurname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtSurname);

        txtBirthDate = new JDateChooser();
        txtBirthDate.setBounds(560, 278, 285, 36);
        txtBirthDate.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(GuestRegister.class.getResource("/images/icon-reservas.png"))));
        txtBirthDate.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtBirthDate.setDateFormatString("yyyy-MM-dd");
        contentPane.add(txtBirthDate);

        txtNationality = new JComboBox();
        txtNationality.setBounds(560, 350, 289, 36);
        txtNationality.setBackground(SystemColor.text);
        txtNationality.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNationality.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
        contentPane.add(txtNationality);

        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(562, 119, 253, 14);
        lblName.setForeground(SystemColor.textInactiveText);
        lblName.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblName);

        JLabel lblSurname = new JLabel("SURNAME");
        lblSurname.setBounds(560, 189, 255, 14);
        lblSurname.setForeground(SystemColor.textInactiveText);
        lblSurname.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblSurname);

        JLabel lblBirthDate = new JLabel("BIRTH DATE");
        lblBirthDate.setBounds(560, 256, 255, 14);
        lblBirthDate.setForeground(SystemColor.textInactiveText);
        lblBirthDate.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblBirthDate);

        JLabel lblNationality = new JLabel("NATIONALITY");
        lblNationality.setBounds(560, 326, 255, 14);
        lblNationality.setForeground(SystemColor.textInactiveText);
        lblNationality.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNationality);

        JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
        lblPhoneNumber.setBounds(562, 406, 253, 14);
        lblPhoneNumber.setForeground(SystemColor.textInactiveText);
        lblPhoneNumber.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtPhoneNumber.setBounds(560, 424, 285, 33);
        txtPhoneNumber.setColumns(10);
        txtPhoneNumber.setBackground(Color.WHITE);
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtPhoneNumber);

        JLabel lblTitle = new JLabel("GUEST REGISTER");
        lblTitle.setBounds(606, 55, 234, 42);
        lblTitle.setForeground(new Color(12, 138, 199));
        lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitle);

        JLabel lblReservationNumber = new JLabel("RESERVATION NUMBER");
        lblReservationNumber.setBounds(560, 474, 253, 14);
        lblReservationNumber.setForeground(SystemColor.textInactiveText);
        lblReservationNumber.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblReservationNumber);

        txtReservationNumber = new JTextField();
        txtReservationNumber.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtReservationNumber.setBounds(560, 495, 285, 33);
        txtReservationNumber.setColumns(10);
        txtReservationNumber.setBackground(Color.WHITE);
        txtReservationNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtReservationNumber);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(560, 170, 289, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2);

        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(560, 240, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_1);

        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(560, 314, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_2);

        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(560, 386, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_3);

        JSeparator separator_1_2_4 = new JSeparator();
        separator_1_2_4.setBounds(560, 457, 289, 2);
        separator_1_2_4.setForeground(new Color(12, 138, 199));
        separator_1_2_4.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_4);

        JSeparator separator_1_2_5 = new JSeparator();
        separator_1_2_5.setBounds(560, 529, 289, 2);
        separator_1_2_5.setForeground(new Color(12, 138, 199));
        separator_1_2_5.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_5);

        JPanel btnSave = new JPanel();
        btnSave.setBounds(723, 560, 122, 35);
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnSave.setLayout(null);
        btnSave.setBackground(new Color(12, 138, 199));
        contentPane.add(btnSave);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel labelSave = new JLabel("SAVE");
        labelSave.setHorizontalAlignment(SwingConstants.CENTER);
        labelSave.setForeground(Color.WHITE);
        labelSave.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelSave.setBounds(0, 0, 122, 35);
        btnSave.add(labelSave);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 489, 634);
        panel.setBackground(new Color(12, 138, 199));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel background = new JLabel("");
        background.setBounds(0, 121, 479, 502);
        panel.add(background);
        background.setIcon(new ImageIcon(Objects.requireNonNull(GuestRegister.class.getResource("/images/registro.png"))));

        JLabel logo = new JLabel("");
        logo.setBounds(194, 39, 104, 107);
        panel.add(logo);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(GuestRegister.class.getResource("/images/Ha-100px.png"))));
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
