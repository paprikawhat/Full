package src.GuiSwing;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        // JFrame a GUI window to add components
        JFrame frame = new JFrame();// Создание фрейма
        // Создание экземпляров ImageIcon содержащих изображения из каталога проекта
        ImageIcon logo = new ImageIcon("redCircle.png");
        ImageIcon psy = new ImageIcon("fire.png");
        frame.setVisible(true); // Выставление параметра видимости в true
        frame.setTitle("Заголовок фрейма"); // Изменение заголовка
        frame.setIconImage(logo.getImage()); // Изменение изображения заголовка фрейма
        frame.setSize(1200, 1200); // Настройка размеров фрейма
        frame.setLayout(null);
        frame.setResizable(true); // Включение возможности изменять размер фрейма
        frame.getContentPane().setBackground(Color.DARK_GRAY); // Изменить цвета фона фрейма
        // Также в метод setBackground может быть передан новый экземпляр Colour
        // в конструктор которого должен быть передан цвет в формате rgb/hex
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрывать окно при закрытии
        // По умолчанию - скрыть
    }
}
