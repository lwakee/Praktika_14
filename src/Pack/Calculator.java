package Pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    public Calculator() {
        setTitle("Калькулятор");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Поля для ввода чисел
        add(new JLabel("Число 1:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Число 2:"));
        num2Field = new JTextField();
        add(num2Field);

        // Кнопки для операций
        JButton addButton = new JButton("Сложить");
        addButton.addActionListener(new OperationListener("+"));
        add(addButton);

        JButton subtractButton = new JButton("Вычесть");
        subtractButton.addActionListener(new OperationListener("-"));
        add(subtractButton);

        JButton multiplyButton = new JButton("Умножить");
        multiplyButton.addActionListener(new OperationListener("*"));
        add(multiplyButton);

        JButton divideButton = new JButton("Разделить");
        divideButton.addActionListener(new OperationListener("/"));
        add(divideButton);

        // Метка для вывода результата
        resultLabel = new JLabel("Результат: ");
        add(resultLabel);
    }

    private class OperationListener implements ActionListener {
        private String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            resultLabel.setText("Ошибка: деление на ноль");
                            return;
                        }
                        break;
                }

                resultLabel.setText("Результат: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: введите числа");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}