import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraFront {
    private JFrame ventana;
    private JLabel calculos = new JLabel();
    private JTextField pantalla = new JTextField();
    private JButton btn0 = new JButton("0");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btnIgual = new JButton("=");
    private JButton btnDividir = new JButton("/");
    private JButton btnPunto = new JButton(".");
    private JButton btnLimpiar = new JButton("C");
    private JButton btnBorrar = new JButton("<-");
    private JButton btnSumar = new JButton("+");
    private JButton btnMultiplicar = new JButton("*");
    private JButton btnRestar = new JButton("-");
    private JButton btnTema = new JButton("L/D");

    private boolean isDarkMode = true;

    public CalculadoraFront() {
        Ventana();
        añadirComponentes();
        añadirEventosAccion();
    }

    public void Ventana() {
        ventana = new JFrame();
        ventana.setTitle("Calculadora");
        ventana.setSize(300, 500);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#253652"));
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void añadirComponentes() {
        calculos.setBounds(250, 0, 50, 50);
        calculos.setForeground(Color.decode("#12b68d"));
        ventana.add(calculos);

        pantalla.setBounds(10, 40, 270, 40);
        pantalla.setFont(new Font("Arial", Font.BOLD, 20));
        pantalla.setBackground(Color.decode("#152640"));
        pantalla.setForeground(Color.decode("#12b68d"));
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        ventana.add(pantalla);

        add(btnBorrar, 150, 110, "#152640", "#12b68d");
        add(btnLimpiar, 80, 110, "#152640", "#12b68d");
        add(btnTema, 10, 110, "#152640", "#12b68d");
        add(btnIgual, 220, 350, 60, 100, "#12b68d", "#15253e");
        add(btnDividir, 220, 110, "#152640", "#12b68d");
        add(btnMultiplicar, 220, 230, "#152640", "#12b68d");
        add(btnRestar, 220, 170, "#152640", "#12b68d");
        add(btnSumar, 220, 290, "#152640", "#12b68d");
        add(btn7, 10, 170, "#253652", "#FFFFFF");
        add(btn8, 80, 170, "#253652", "#FFFFFF");
        add(btn9, 150, 170, "#253652", "#FFFFFF");
        add(btn4, 10, 230, "#253652", "#FFFFFF");
        add(btn5, 80, 230, "#253652", "#FFFFFF");
        add(btn6, 150, 230, "#253652", "#FFFFFF");
        add(btn1, 10, 290, "#253652", "#FFFFFF");
        add(btn2, 80, 290, "#253652", "#FFFFFF");
        add(btn3, 150, 290, "#253652", "#FFFFFF");
        add(btn0, 10, 350, 130, 40, "#253652", "#FFFFFF");
        add(btnPunto, 150, 350, "#253652", "#FFFFFF");
    }

    private void add(JButton boton, int x, int y) {
        add(boton, x, y, 60, 40, "#253652", "#FFFFFF");
    }

    private void add(JButton boton, int x, int y, int ancho, int alto) {
        add(boton, x, y, ancho, alto, "#253652", "#FFFFFF");
    }

    private void add(JButton boton, int x, int y, String colorFondo, String colorFuente) {
        add(boton, x, y, 60, 40, colorFondo, colorFuente);
    }

    private void add(JButton boton, int x, int y, int ancho, int alto, String colorFondo, String colorFuente) {
        boton.setBounds(x, y, ancho, alto);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setBackground(Color.decode(colorFondo));
        boton.setForeground(Color.decode(colorFuente));
        boton.setBorderPainted(false);
        ventana.add(boton);
    }

    private void añadirEventosAccion() {
        CalculadoraBack calculadora = new CalculadoraBack(pantalla);

        JButton[] botones = {btnLimpiar, btnBorrar, btnDividir, btnRestar, btn7, btn8, btn9, btnMultiplicar,
                btn4, btn5, btn6, btnSumar, btn1, btn2, btn3, btnIgual, btn0, btnPunto};

        for (JButton boton : botones) {
            boton.addActionListener(calculadora);
        }

        btnTema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTema();
            }
        });
    }

    private void toggleTema() {
        if (isDarkMode) {
            ventana.getContentPane().setBackground(Color.decode("#FFFFFF"));
            pantalla.setBackground(Color.decode("#F0F0F0"));
            pantalla.setForeground(Color.decode("#000000"));
            calculos.setForeground(Color.decode("#000000"));
            cambiarColorBotones("#F0F0F0", "#000000", "#FFFFFF", "#000000", "#000000", "#F0F0F0", "#FFFFFF", "#000000");
        } else {
            ventana.getContentPane().setBackground(Color.decode("#253652"));
            pantalla.setBackground(Color.decode("#152640"));
            pantalla.setForeground(Color.decode("#12b68d"));
            calculos.setForeground(Color.decode("#12b68d"));
            cambiarColorBotones("#253652", "#FFFFFF", "#152640", "#12b68d", "#12b68d", "#15253e", "#152640", "#12b68d");
        }
        isDarkMode = !isDarkMode;
    }

    private void cambiarColorBotones(String colorFondoNumerico, String colorFuenteNumerico,
                                     String colorFondoOperaciones, String colorFuenteOperaciones,
                                     String colorFondoIgual, String colorFuenteIgual,
                                     String colorFondoTema, String colorFuenteTema) {
        JButton[] botonesNumericos = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunto};
        JButton[] botonesOperaciones = {btnDividir, btnMultiplicar, btnRestar, btnSumar, btnLimpiar, btnBorrar};

        for (JButton boton : botonesNumericos) {
            boton.setBackground(Color.decode(colorFondoNumerico));
            boton.setForeground(Color.decode(colorFuenteNumerico));
        }

        for (JButton boton : botonesOperaciones) {
            boton.setBackground(Color.decode(colorFondoOperaciones));
            boton.setForeground(Color.decode(colorFuenteOperaciones));
        }

        btnIgual.setBackground(Color.decode(colorFondoIgual));
        btnIgual.setForeground(Color.decode(colorFuenteIgual));

        btnTema.setBackground(Color.decode(colorFondoTema));
        btnTema.setForeground(Color.decode(colorFuenteTema));
    }
}
