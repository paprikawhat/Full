package src.Chapter_II.JavaUtil.ResourseBundleClass;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
/*

            НЕ РАБОТАЕТ !!!

*/
class SampleRB extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];
        resources[0][0] = "title";
        resources[0][1] = "My Program";
        resources[1][0] = "stopText";
        resources[1][1] = "STOP";
        resources[2][0] = "startText";
        resources[2][1] = "START";
        return resources;
    }
}
class SampleRB_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];
        resources[0][0] = "title";
        resources[0][1] = "Mein Programm";
        resources[1][0] = "stopText";
        resources[1][1] = "ANSCHLAG";
        resources[2][0] = "startText";
        resources[2][1] = "ANFANG";
        return resources;
    }
}
class SampleRB_ru extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];
        resources[0][0] = "title";
        resources[0][1] = "Заголовок";
        resources[1][0] = "stopText";
        resources[1][1] = "СТОП";
        resources[2][0] = "startText";
        resources[2][1] = "СТАРТ";
        return resources;
    }
}

public class ResourceBundleClass {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("SampleRB", Locale.US);
        System.out.println(rb.getString("title"));
        System.out.println(rb.getString("stopText"));
        System.out.println(rb.getString("startText"));

        rb = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);
        System.out.println(rb.getString("title"));
        System.out.println(rb.getString("stopText"));
        System.out.println(rb.getString("startText"));
    }
}
