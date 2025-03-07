package src.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* Отображение содержимого текстового файла. Для использования необходимо указать
 * имя файла, который хотите посмотреть. Для TEST.txt введите следующую команду:
 * java ShowFile TEST.txt  */
public class FileShow {
    public static void main(String[] args) {
        FileInputStream fis = null;
        int i;
        // Удостовериться что имя файла было указано
        if(args.length != 1) {
            System.out.println("Использование: ShowFile имя-файла");
            return;
        }
        // Следующий код читает символы до тех пор, пока не встретит EOF, и затем
        // закрывает файл
        try {
            fis = new FileInputStream(args[0]);
            do {
                i = fis.read();
                if(i != -1) System.out.println((char) i);
            } while(i != -1);
            // Необязательное исключение
        } catch (FileNotFoundException e) {
        System.out.println("Не удалось отрыть файл");
        return;
    } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        } finally {
            // Закрытие файла внутри блока finally
            try {
                if(fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла");
            }
        }
    }

}
