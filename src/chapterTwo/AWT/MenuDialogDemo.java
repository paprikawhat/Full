package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.*;

public class MenuDialogDemo extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;
    SampleDialog myDialog;
    MenuDialogDemo() {
        myDialog = new SampleDialog(this,"New dialog box");
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);
        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close"));
        file.add(item4 = new MenuItem("-"));
        file.add(item5 = new MenuItem("Quit..."));
        mbar.add(file);
        Menu edit = new Menu("Edit");
        MenuItem item6, item7, item8, item9;
        edit.add(item6 = new MenuItem("Cut"));
        edit.add(item7 = new MenuItem("Copy"));
        edit.add(item8 = new MenuItem("Paste"));
        edit.add(item9 = new MenuItem("-"));
        Menu sub = new Menu("Special");
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("First"));
        sub.add(item11 = new MenuItem("Second"));
        sub.add(item12 = new MenuItem("Third"));
        edit.add(sub);
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);
        mbar.add(edit);
        // Создание обработчика событий действий и элементов
        MyMenuHandler mmh = new MyMenuHandler();
        MenuItem[] menuItems = {item1, item2, item3, item4, item6, item7, item8, item9, item10, item11, item12};
        for(MenuItem mi : menuItems) {
            mi.addActionListener(mmh);
        }
        debug.addActionListener(mmh);
        test.addActionListener(mmh);
        item5.addActionListener((e) -> System.exit(0));
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        g.drawString(msg, 60, 220);
        if(debug.getState()) {
            g.drawString("Debug is on", 60, 240);
        } else {
            g.drawString("Debug is off", 60, 240);
        }
        if(test.getState()) {
            g.drawString("Testing is on", 60, 260);
        } else {
            g.drawString("Testing is off", 60, 260);
        }
    }
    public static void main(String[] args) {
        MenuDialogDemo md = new MenuDialogDemo();
        md.setSize(400,400 );
        md.setVisible(true);
        md.setTitle("Menu demo");
    }
    class MyMenuHandler implements ActionListener, ItemListener {
        public void actionPerformed(ActionEvent e) {
            msg = "You selected ";
            String arg = e.getActionCommand();
            switch (arg) {
                case "New..." -> {
                    msg += "New.";
                    myDialog.setVisible(true);
                }
                case "Open..." -> msg+= "Open.";
                case "Close" -> msg += "Close.";
                case "Edit" -> msg += "Edit.";
                case "Cut" -> msg += "Cut.";
                case "Copy" -> msg += "Copy.";
                case "Paste" -> msg += "Paste.";
                case "First" -> msg += "First.";
                case "Second" -> msg += "Second.";
                case "Third" -> msg += "Third.";
                case "Debug" -> msg += "Debug.";
                case "Testing" -> msg += "Testing.";
            }
            repaint();
        }
        public void itemStateChanged(ItemEvent e) {
            repaint();
        }
    }
}
class SampleDialog extends Dialog {
    SampleDialog(Frame parent, String title) {
        super(parent, title,false);
        setLayout(new FlowLayout());
        setSize(200,200);
        add(new Label("Press this button"));
        Button b;
        add(b = new Button("Cancel"));
        b.addActionListener((e) -> dispose());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void paint(Graphics g) {
        g.drawString("This is a dialog box", 40, 140);
    }
}
