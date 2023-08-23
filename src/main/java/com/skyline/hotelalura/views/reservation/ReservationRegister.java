package com.skyline.hotelalura.views.reservation;

import com.skyline.hotelalura.config.components.DaggerReservationComponent;
import com.skyline.hotelalura.config.components.ReservationComponent;
import com.skyline.hotelalura.controllers.ReservationController;
import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.views.ControlPanel;
import com.skyline.hotelalura.views.Home;
import com.skyline.hotelalura.views.guest.GuestRegister;
import com.toedter.calendar.JDateChooser;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReservationRegister extends JFrame {
    private JPanel contentPane;
    public static JTextField txtValue;
    public static JDateChooser txtDateEntry;
    public static JDateChooser txtDateDeparture;
    public static JComboBox<String> txtPaymentMethod;
    private  int xMouse, yMouse;
    private JLabel labelExit;
    private JLabel labelBack;
    private Reservation reservation;
    private ReservationController reservationController;
    private boolean isUpdate = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ReservationRegister frame = new ReservationRegister();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ReservationRegister() {
        super("Reservation");
        this.initComponent();
    }

    public ReservationRegister(Reservation reservation) {
        super("Reservation");
        this.reservation = reservation;
        this.initComponent();
    }

    public ReservationRegister(Reservation reservation, boolean isUpdate) {
        super("Reservation");
        this.reservation = reservation;
        this.isUpdate = isUpdate;
        this.initComponent();
    }

    public void initComponent() {
        ReservationComponent component = DaggerReservationComponent.create();
        this.reservationController = component.buildReservationController();

        if (this.reservation != null) {
            txtDateEntry.setDate(this.reservation.getDateEntry());
            txtDateDeparture.setDate(this.reservation.getDateDeparture());
            txtPaymentMethod.setSelectedItem(this.reservation.getPaymentMethod());
            txtValue.setText(String.valueOf(this.reservation.getValue()));
        }

        setIconImage(Toolkit.getDefaultToolkit().getImage(ReservationRegister.class.getResource("/images/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 195, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);

        JSeparator separator_1_3 = new JSeparator();
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 453, 289, 2);
        panel.add(separator_1_3);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 281, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_1);

        JLabel lblCheckIn = new JLabel("DATE DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 136, 169, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("DATE DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 221, 187, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblPaymentMethod = new JLabel("PAYMENT METHOD");
        lblPaymentMethod.setForeground(SystemColor.textInactiveText);
        lblPaymentMethod.setBounds(68, 382, 187, 24);
        lblPaymentMethod.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblPaymentMethod);

        JLabel lblTitle = new JLabel("RESERVATION SYSTEM");
        lblTitle.setBounds(109, 60, 219, 42);
        lblTitle.setForeground(new Color(12, 138, 199));
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(lblTitle);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(ReservationRegister.class.getResource("/images/Ha-100px.png"))));

        JLabel background = new JLabel("");
        background.setBounds(0, 140, 500, 409);
        panel_1.add(background);
        background.setBackground(Color.WHITE);
        background.setIcon(new ImageIcon(Objects.requireNonNull(ReservationRegister.class.getResource("/images/reservas-img-3.png"))));

        JLabel lblValue = new JLabel("VALUE OF THE RESERVE");
        lblValue.setForeground(SystemColor.textInactiveText);
        lblValue.setBounds(72, 303, 196, 14);
        lblValue.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblValue);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 362, 289, 2);
        separator_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isUpdate) {
                    ControlPanel frame = new ControlPanel();
                    frame.setVisible(true);
                    dispose();
                } else {
                    Home home = new Home();
                    home.setVisible(true);
                    dispose();
                }
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
        btnExit.setLayout(null);
        btnExit.setBackground(new Color(12, 138, 199));
        btnExit.setBounds(429, 0, 53, 36);
        panel_1.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

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

        JPanel btnBack = new JPanel();
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isUpdate) {
                    ControlPanel frame = new ControlPanel();
                    frame.setVisible(true);
                    dispose();
                } else {
                    Home home = new Home();
                    home.setVisible(true);
                    dispose();
                }
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
        labelBack.setBounds(0, 0, 53, 36);
        btnBack.add(labelBack);
        labelBack.setHorizontalAlignment(SwingConstants.CENTER);
        labelBack.setFont(new Font("Roboto", Font.PLAIN, 23));

        txtDateEntry = new JDateChooser();
        txtDateEntry.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtDateEntry.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservationRegister.class.getResource("/images/icon-reservas.png"))));
        txtDateEntry.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
        txtDateEntry.setBounds(68, 161, 289, 35);
        txtDateEntry.getCalendarButton().setBounds(268, 0, 21, 33);
        txtDateEntry.setBackground(Color.WHITE);
        txtDateEntry.setBorder(new LineBorder(SystemColor.window));
        txtDateEntry.setDateFormatString("yyyy-MM-dd");
        txtDateEntry.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtDateEntry.addPropertyChangeListener(evt -> this.calculateValueReservation());
        txtDateEntry.setForeground(Color.BLACK);
        if (reservation != null) {
            txtDateEntry.setDate(reservation.getDateEntry());
        }
        panel.add(txtDateEntry);

        txtDateDeparture = new JDateChooser();
        txtDateDeparture.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservationRegister.class.getResource("/images/icon-reservas.png"))));
        txtDateDeparture.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
        txtDateDeparture.setBounds(68, 246, 289, 35);
        txtDateDeparture.getCalendarButton().setBounds(267, 1, 21, 31);
        txtDateDeparture.setBackground(Color.WHITE);
        txtDateDeparture.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtDateDeparture.addPropertyChangeListener(evt -> this.calculateValueReservation());
        txtDateDeparture.setDateFormatString("yyyy-MM-dd");
        txtDateDeparture.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtDateDeparture.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        if (reservation != null) {
            txtDateDeparture.setDate(reservation.getDateDeparture());
        }
        panel.add(txtDateDeparture);

        txtValue = new JTextField();
        txtValue.setBackground(SystemColor.text);
        txtValue.setForeground(Color.BLACK);
        txtValue.setBounds(68, 328, 289, 35);
        txtValue.setEditable(false);
        txtValue.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtValue.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        if (reservation != null) {
            txtValue.setText(String.valueOf(reservation.getValue()));
        }
        panel.add(txtValue);
        txtValue.setColumns(10);

        txtPaymentMethod = new JComboBox();
        txtPaymentMethod.setBounds(68, 417, 289, 38);
        txtPaymentMethod.setBackground(SystemColor.text);
        txtPaymentMethod.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtPaymentMethod.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"Credit Card", "Debit Card", "Cash"}));
        if (reservation != null) {
            txtPaymentMethod.setSelectedItem(reservation.getPaymentMethod());
        }
        panel.add(txtPaymentMethod);

        JPanel btnNext = new JPanel();

        JLabel lblNext = new JLabel(isUpdate ? "UPDATE" : "NEXT");
        lblNext.setHorizontalAlignment(SwingConstants.CENTER);
        btnNext.add(lblNext);
        lblNext.setForeground(Color.WHITE);
        lblNext.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblNext.setBounds(0, 0, 122, 35);

        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isUpdate) updateReservation();
                else buildReservation();
            }
        });
        btnNext.setLayout(null);
        btnNext.setBackground(SystemColor.textHighlight);
        btnNext.setBounds(238, 493, 122, 35);
        panel.add(btnNext);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

    private static double calculateValueReservation() {
        if (txtDateEntry.getDate() == null || txtDateDeparture.getDate() == null) return 0;

        double value = 0;
        try {
            Date dateEntry = parseDate(txtDateEntry.getDate());
            Date dateDeparture = parseDate(txtDateDeparture.getDate());
            long diff = dateDeparture.getTime() - dateEntry.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

            if (dateEntry.before(dateDeparture)) {
                value = days * 5000;
                txtValue.setText(String.valueOf(value));
                return value;
            } else {
                JOptionPane.showMessageDialog(null, "The departure date must be greater than the entry date.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error calculating the value of the reservation.");
        }

        return 0;
    }

    private static BigInteger generateIdReservation() {
        BigInteger code = BigInteger.valueOf(0);
        try {
            code = new BigInteger(String.valueOf(new Random().nextInt(999999999)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generating reservation code.");
        }
        return code;
    }

    private void buildReservation() {
        if (ReservationRegister.txtDateEntry.getDate() != null && ReservationRegister.txtDateDeparture.getDate() != null) {
            if (ReservationRegister.txtDateEntry.getDate().before(ReservationRegister.txtDateDeparture.getDate())) {
                reservation = Reservation.builder()
                        .id(ReservationRegister.generateIdReservation())
                        .dateEntry(ReservationRegister.parseDate(txtDateEntry.getDate()))
                        .dateDeparture(ReservationRegister.parseDate(txtDateDeparture.getDate()))
                        .value(BigDecimal.valueOf(ReservationRegister.calculateValueReservation()))
                        .paymentMethod(txtPaymentMethod.getSelectedItem().toString())
                        .build();

                GuestRegister frame = new GuestRegister(reservation);
                frame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The departure date must be greater than the entry date.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must fill in all fields.");
        }
    }

    @SneakyThrows
    private void updateReservation() {
        if (ReservationRegister.txtDateEntry.getDate() != null && ReservationRegister.txtDateDeparture.getDate() != null) {
            if (ReservationRegister.txtDateEntry.getDate().before(ReservationRegister.txtDateDeparture.getDate())) {
                reservation.setDateEntry(ReservationRegister.parseDate(txtDateEntry.getDate()));
                reservation.setDateDeparture(ReservationRegister.parseDate(txtDateDeparture.getDate()));
                reservation.setValue(BigDecimal.valueOf(ReservationRegister.calculateValueReservation()));
                reservation.setPaymentMethod(txtPaymentMethod.getSelectedItem().toString());

                this.reservationController.updateReservation(reservation);
                ControlPanel frame = new ControlPanel();
                frame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The departure date must be greater than the entry date.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must fill in all fields.");
        }
    }

    private static Date parseDate(Date date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateFormat.format(date));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing date.");
        }
        return null;
    }
}
