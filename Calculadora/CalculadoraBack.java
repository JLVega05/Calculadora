import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraBack implements ActionListener {
    private JTextField pantalla;
    public CalculadoraBack(JTextField pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento = e.getSource();

        if (evento instanceof JButton) {
            JButton boton = (JButton) evento;
            String textoBoton = boton.getText();

            switch (textoBoton) {
                case "C":
                    pantalla.setText("");
                    break;
                case "<-":
                    String textoPantalla = pantalla.getText();
                    if (!textoPantalla.isEmpty()) {
                        pantalla.setText(textoPantalla.substring(0, textoPantalla.length() - 1));
                    }
                    break;
                case "=":
                    realizarCalculo();
                    break;
                default:
                    pantalla.setText(pantalla.getText() + textoBoton);
                    break;
            }
        }
    }

    private void realizarCalculo() {
        try {
            String textoPantalla = pantalla.getText();
            String[] partes = textoPantalla.split("(?<=[-+*/])|(?=[-+*/])");

            if (partes.length != 3) {
                pantalla.setText("Error");
                return;
            }

            double num1 = Double.parseDouble(partes[0]);
            char operacion = partes[1].charAt(0);
            double num2 = Double.parseDouble(partes[2]);

            double resultado = 0;

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        pantalla.setText("Error");
                        return;
                    }
                    break;
            }

            pantalla.setText(String.valueOf(resultado));
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }
}
