// Importa las clases necesarias para la interfaz gráfica y eventos
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Define la clase principal que extiende JFrame y maneja eventos de acción
public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField display; // Campo de texto para mostrar números y resultados
    private double num1 = 0, num2 = 0, resultado = 0; // Variables para los operandos y el resultado
    private char operacion = ' '; // Variable para la operación seleccionada

    // Constructor de la calculadora
    public CalculadoraGUI() {
        setTitle("Calculadora Alejo"); // Título de la ventana
        setSize(400, 500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
        setLayout(new BorderLayout()); // Usa BorderLayout para organizar los componentes

        display = new JTextField(); // Inicializa el campo de texto
        display.setEditable(false); // No permite edición directa
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente grande y negrita
        add(display, BorderLayout.NORTH); // Coloca el display en la parte superior

        JPanel panel = new JPanel(); // Panel para los botones
        panel.setLayout(new GridLayout(5, 5, 6, 8)); // Organiza los botones en una cuadrícula

        // Array con los textos de los botones
        String[] botones = {
                "7", "8", "9", "/", "√",
                "4", "5", "6", "*", "^",
                "1", "2", "3", "-", "%",
                "0", "e", "x²", "+", "√x",
                "(", ")", "π", "C", "="
        };

        panel.setBackground(Color.pink); // Fondo rosa para el panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        // Crea y añade cada botón al panel
        for (String texto : botones) {
            JButton boton = new JButton(texto); // Crea el botón con el texto
            boton.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente grande y negrita
            boton.addActionListener(this); // Asocia el evento de acción
            panel.add(boton); // Añade el botón al panel
        }

        add(panel, BorderLayout.CENTER); // Coloca el panel de botones en el centro

        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // No permite redimensionar la ventana
        setVisible(true); // Hace visible la ventana
    }

    // Convierte un número decimal a fracción simplificada
    private String decimalToFraction(double value) {
        final double TOLERANCE = 1.0E-6; // Tolerancia para la aproximación
        double num = value;
        int sign = (num < 0) ? -1 : 1; // Guarda el signo
        num = Math.abs(num); // Trabaja con valor absoluto
        int whole = (int) num; // Parte entera
        num -= whole; // Parte decimal
        if (num < TOLERANCE) return String.valueOf(sign * whole); // Si es entero, retorna solo el entero
        int denominator = 1;
        // Busca el denominador adecuado para la fracción
        while (Math.abs(num * denominator - Math.round(num * denominator)) > TOLERANCE && denominator < 10000) {
            denominator++;
        }
        int numerator = (int) Math.round(num * denominator); // Calcula el numerador
        if (whole == 0)
            return (sign * numerator) + "/" + denominator; // Solo fracción
        else
            return (sign * whole) + " " + numerator + "/" + denominator; // Entero y fracción
    }

    // Maneja los eventos de los botones
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Obtiene el texto del botón presionado

        // Si es un número, lo añade al display
        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            display.setText(display.getText() + comando);
        }
        // Si es "C", limpia todo
        else if (comando.equals("C")) {
            display.setText("");
            num1 = num2 = resultado = 0;
            operacion = ' ';
        }
        // Si es raíz cuadrada, calcula y muestra el resultado
        else if (comando.equals("√")) {
            try {
                double valor = Double.parseDouble(display.getText());
                resultado = Math.sqrt(valor);
                display.setText(resultado + " | " + decimalToFraction(resultado)); // Muestra decimal y fracción
                num1 = resultado;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
        // Si es "=", realiza la operación seleccionada
        else if (comando.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
                switch (operacion) {
                    case '+': resultado = num1 + num2; break;
                    case '-': resultado = num1 - num2; break;
                    case '*': resultado = num1 * num2; break;
                    case '/':
                        if (num2 != 0) resultado = num1 / num2;
                        else {
                            display.setText("Error");
                            return;
                        }
                        break;
                    case '^': resultado = Math.pow(num1, num2); break;
                }
                display.setText(resultado + " | " + decimalToFraction(resultado)); // Muestra decimal y fracción
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
        // Si es una operación (+, -, *, /, ^), la guarda y limpia el display
        else {
            if (!display.getText().isEmpty()) {
                try {
                    num1 = Double.parseDouble(display.getText());
                    operacion = comando.charAt(0);
                    display.setText("");
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
            }
        }
    }

    // Método principal para iniciar la calculadora
    public static void main(String[] args) {
        new CalculadoraGUI(); // Crea la instancia y muestra la ventana
    }
}