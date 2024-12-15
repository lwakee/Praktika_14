package Pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Second extends JFrame {
    private JComboBox<String> countryComboBox;
    private JLabel infoLabel;

    public Second() {
        setTitle("Выбор страны");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Создаем выпадающий список
        String[] countries = {"Австралия", "Китай", "Англия", "Россия"};
        countryComboBox = new JComboBox<>(countries);
        add(countryComboBox);

        // Метка для вывода информации
        infoLabel = new JLabel("Выберите страну");
        add(infoLabel);

        // Слушатель для выбора страны
        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                switch (selectedCountry) {
                    case "Россия":
                        infoLabel.setText("UTC +3");
                        break;
                    case "Австралия":
                        infoLabel.setText("UTC +10");
                        break;
                    case "Китай":
                        infoLabel.setText("UTC +8");
                        break;
                    case "Англия":
                        infoLabel.setText("UTC");
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new Second().setVisible(true);
    }
}