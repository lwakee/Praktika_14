package Pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCalculator extends JFrame {
    private JTextField display;
    private double num1, num2;
    private String operator;
    private boolean isDecimalPressed = false; // Флаг для проверки нажатия точки

    public ButtonCalculator() {
        setTitle("Калькулятор с кнопками");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Поле для отображения
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Панель для кнопок
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        add(buttonPanel, BorderLayout.CENTER);

        // Кнопки
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonListener());
            buttonPanel.add(button);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9]")) {
                display.setText(display.getText() + command);
            } else if (command.equals(".")) {
                if (!isDecimalPressed) { // Проверяем, была ли уже нажата точка
                    display.setText(display.getText() + ".");
                    isDecimalPressed = true;
                }
            } else if (command.equals("C")) {
                display.setText("");
                num1 = 0;
                num2 = 0;
                operator = null;
                isDecimalPressed = false; // Сбрасываем флаг точки
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
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
                            display.setText("Ошибка: деление на ноль");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                isDecimalPressed = false; // Сбрасываем флаг точки
            } else {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
                isDecimalPressed = false; // Сбрасываем флаг точки
            }
        }
    }

    public static void main(String[] args) {
        new ButtonCalculator().setVisible(true);
    }
}