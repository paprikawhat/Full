package src.chapterTwo;

public class Processes {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println(Runtime.version());
        Process p = null;
        try {
            p = r.exec("explorer"); // Выполнение стандартных команд
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "test file");
            proc.start();
        } catch (Exception e) {
            System.out.println("A!!!!");
        }
    }
}
