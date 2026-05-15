
package presentacion.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import presentacion.controles.ControlAgregarCotizacion;
import presentacion.controles.ControlAuth;
import presentacion.controles.ControlConsultarCotizaciones;
import presentacion.controles.ControlCotizaciones;
import presentacion.interfaces.IControlAgregarCotizacion;
import presentacion.interfaces.IControlConsultarCotizaciones;
import presentacion.interfaces.IControlCotizaciones;

/**
 *
 * @author PC Gamer
 */
public class VistaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public VistaLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("SGISCA / TRAG - Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null); 
        setResizable(false); 

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Bienvenido");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setForeground(new Color(33, 37, 41));

        JLabel lblSubtitle = new JLabel("Inicia sesión para continuar");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSubtitle.setForeground(new Color(108, 117, 125));

        topPanel.add(lblTitle);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(lblSubtitle);
        topPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0); 
        gbc.weightx = 1.0;

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsuario.setForeground(new Color(73, 80, 87));
        gbc.gridy = 0;
        formPanel.add(lblUsuario, gbc);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setPreferredSize(new Dimension(300, 40));

        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(206, 212, 218), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0); 
        formPanel.add(txtUsuario, gbc);


        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPassword.setForeground(new Color(73, 80, 87));
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        formPanel.add(lblPassword, gbc);


        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setPreferredSize(new Dimension(300, 40));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(206, 212, 218), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 40, 0);
        formPanel.add(txtPassword, gbc);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new BorderLayout());

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBackground(new Color(13, 110, 253)); 
        btnIngresar.setFocusPainted(false); 
        btnIngresar.setBorderPainted(false); 
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresar.setPreferredSize(new Dimension(300, 45));

      
        btnIngresar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnIngresar.setBackground(new Color(11, 94, 215)); 
            }

            public void mouseExited(MouseEvent evt) {
                btnIngresar.setBackground(new Color(13, 110, 253)); 
            }
        });

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        bottomPanel.add(btnIngresar, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if (usuario.isBlank() || password.isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese usuario y contraseña.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        btnIngresar.setEnabled(false);
        btnIngresar.setText("Validando credenciales...");

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                ControlAuth controlAuth = new ControlAuth();
                return controlAuth.hacerLogin(usuario, password);
            }

            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                btnIngresar.setEnabled(true);
                btnIngresar.setText("Ingresar");

                try {
                    boolean exito = get();
                    if (exito) {

                        IControlAgregarCotizacion controlAgregar = new ControlAgregarCotizacion();
                        IControlConsultarCotizaciones controlConsultar = new ControlConsultarCotizaciones();

                        IControlCotizaciones controlCotizaciones = new ControlCotizaciones(controlAgregar, controlConsultar);

                        ((ControlAgregarCotizacion) controlAgregar).setControlCotizaciones(controlCotizaciones);
                        ((ControlConsultarCotizaciones) controlConsultar).setControlCotizaciones(controlCotizaciones);

                        controlCotizaciones.administrarCotizaciones();

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(VistaLogin.this, "Usuario o contraseña incorrectos", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Error de red. Asegúrate de que el API Gateway esté encendido.", "Error del Servidor", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println("Fallo al inicializar el tema del sistema");
        }

        EventQueue.invokeLater(() -> {
            new VistaLogin().setVisible(true);
        });
    }
}
