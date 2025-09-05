import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Usuario {
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public String getSaludo() {
        return "Hola, " + nombre;
    }
}
// Clase principal
public class VentanaSaludo extends JFrame {
    private JTextField campoTexto;
    private JLabel etiquetaSaludo;
    private JButton botonSaludar, botonLimpiar;

    public VentanaSaludo() {
        inicializarComponentes();
        configurarEventos();
    }
    private void inicializarComponentes() {
        setTitle("App de Saludo ICC490");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        // Personalización visual
        getContentPane().setBackground(new Color(250, 250, 250));
        // Campo de texto
        campoTexto = new JTextField();
        campoTexto.setBounds(50, 40, 200, 30);
        add(campoTexto);
        // Botón Saludar
        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 40, 120, 30);
        add(botonSaludar);
        // Botón Limpiar
        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(270, 80, 120, 30);
        add(botonLimpiar);
        // Etiqueta de saludo
        etiquetaSaludo = new JLabel("");
        etiquetaSaludo.setBounds(50, 120, 350, 30);
        etiquetaSaludo.setFont(new Font("Arial", Font.BOLD, 16));
        add(etiquetaSaludo);
    }
    private void configurarEventos() {
        // Acción del botón Saludar
        botonSaludar.addActionListener(e -> {
            String nombre = campoTexto.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa tu nombre.");
            } else {
                Usuario u = new Usuario(nombre);
                etiquetaSaludo.setText(u.getSaludo());
            }
        });
        // Acción del botón Limpiar
        botonLimpiar.addActionListener(e -> {
            campoTexto.setText("");
            etiquetaSaludo.setText("");
        });
        // Acción con tecla ENTER
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick(); // Simula clic en el botón Saludar
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaSaludo ventana = new VentanaSaludo();
            ventana.setVisible(true);
        });
    }
}
