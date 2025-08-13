import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, resultado = 0;
    private char operacion = ' ';

    public CalculadoraGUI() {
        setTitle("Calculadora Alejo");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false); // No permite que el usuario escriba directamente
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5, 6, 8));

        String[] botones = {
                "7", "8", "9", "/", "√",
                "4", "5", "6", "*", "^",
                "1", "2", "3", "-", "%",
                "0", "e", "x²", "+", "√x",
                "(", ")", "π", "c", "="
        };

        panel.setBackground(Color.pink);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(this);
            panel.add(boton);
        }

        add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            display.setText(display.getText() + comando);
        } else if (comando.equals("C")) {
            display.setText("");
            num1 = num2 = resultado = 0;
            operacion = ' ';
        } else if (comando.equals("√")) {
            try {
                double valor = Double.parseDouble(display.getText());
                resultado = Math.sqrt(valor);
                display.setText("" + resultado);
                num1 = resultado;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (comando.equals("=")) {
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
                display.setText("" + resultado);
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else {
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

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}