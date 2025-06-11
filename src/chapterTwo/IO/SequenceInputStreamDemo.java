package src.chapterTwo.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumeration implements Enumeration <FileInputStream> {
    private final Enumeration<String> files;
    public InputStreamEnumeration(Vector<String> files) {
        this.files = files.elements();
    }
    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }
    @Override
    public FileInputStream nextElement() {
        try {
            return  new FileInputStream(files.nextElement());
        } catch (IOException e){
            return null;
        }
    }
}
 
public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();
        files.addElement("file_byteArray_IO");
        files.addElement("File");
        files.addElement("file2_RW_IO");
        InputStreamEnumeration ise = new InputStreamEnumeration(files);
        InputStream sis = new SequenceInputStream(ise);
        try {
            while(( c = sis.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("NULL");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                sis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
