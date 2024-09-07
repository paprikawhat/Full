package src.GuiSwing;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;

public class Label {
    public static void main(String[] args) {
        // JFrame a GUI window to add components
        JFrame frame = new JFrame();// Создание фрейма
        // Создание экземпляров ImageIcon содержащих изображения из каталога проекта
        ImageIcon logo = new ImageIcon("redCircle.png");
        ImageIcon psy = new ImageIcon("fire.png");
        // JLabel - a GUI display area for a strung, an image or both
        JLabel label = new JLabel("Текст лейбла"); // Создание экземпляра JLabel
        // Создание экземпляра для границы
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 6);
        // JPanel представляет собой контейнер для других компонентов
        JPanel redPanel = new JPanel();

        frame.setVisible(true); // Выставление параметра видимости в true
        frame.setTitle("Заголовок фрейма"); // Изменение заголовка
        frame.setIconImage(logo.getImage()); // Изменение изображения заголовка фрейма
        frame.setSize(1200,1200); // Настройка размеров фрейма
        frame.setLayout(null);
        frame.setResizable(true); // Включение возможности изменять размер фрейма
        frame.getContentPane().setBackground(Color.DARK_GRAY); // Изменить цвета фона фрейма
        // Также в метод setBackground может быть передан новый экземпляр Colour
        // в конструктор которого должен быть передан цвет в формате rgb/hex
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрывать окно при закрытии
        // По умолчанию - скрыть
        redPanel.setSize(750,750);
        redPanel.setBackground(Color.BLACK);
        redPanel.setBounds(70, 70, 500, 500);
        frame.add(redPanel);
        label.setText("FIRE! FIRE! FIRE!"); // Изменение текста в label
        frame.add(label); // Добавление лейбла во фрейм
        label.setIcon(psy); // Присвоение иконки
        // Изменение положения текста внутри label
        // LEFT, CENTER, RIGHT относительно изображения
        label.setHorizontalTextPosition(JLabel.CENTER); //
        // Изменение вертикального положения текста
        // TOP, CENTER, BOTTOM относительно изображения
        label.setVerticalTextPosition(JLabel.TOP);
        // Изменение цвета текста
        label.setForeground(new Color(245, 225, 100));
        // Изменение шрифта текста
        label.setFont(new Font("myFont", Font.PLAIN, 50));
        label.setIconTextGap(-15); // Изменение расстояния между тестом и изображением
        label.setBackground(Color.blue); // Изменение фона label
        label.setOpaque(true); // Оператор для отображения цвета фона label
        label.setBorder(border); //  Присваивание границы для label
        label.setVerticalAlignment(JLabel.CENTER); // Выбор позиции по вертикали
        label.setHorizontalAlignment(JLabel.CENTER); // Горизонтальная позиция
        // Изменение отступов и размеров объекта label
        label.setBounds(40, 50, 900, 900);
        //frame.pack(); // Автоматически выставляет размер фрейма со всем наполнением
        // Всегда должен стоять после всех компонентов фрейма
    }
}
