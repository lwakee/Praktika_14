package Pack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Third extends JFrame {
    private JTextArea textArea;

    public Third() {
        setTitle("Программа с меню");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем меню
        JMenuBar menuBar = new JMenuBar();

        // Меню "Файл"
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Меню "Правка"
        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        // Меню "Справка"
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);

        // Добавляем меню в панель меню
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Текстовое поле
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Слушатели для пунктов меню
        exitItem.addActionListener(e -> System.exit(0));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Файл сохранен"));
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());

        // Слушатель для пункта "О программе"
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Программа с меню\nВерсия 1.0"));
    }


    public static void main(String[] args) {
        new Third().setVisible(true);
    }
}