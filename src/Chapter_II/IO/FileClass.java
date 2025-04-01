package src.Chapter_II.IO;

import java.io.File;
import java.io.FilenameFilter;

class MyFileNameFilter implements FilenameFilter {
    String str;
    public MyFileNameFilter(String str) {
        this.str = "." + str;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(str);
    }
}

public class FileClass {
    static void p(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) {
        String dirName = "C:\\Users\\papri\\Full";
        File file1 = new File("C:\\Users\\papri\\Full");
        File file2 = new File(dirName);
        MyFileNameFilter filter = new MyFileNameFilter("dat");

        p(file1.getAbsolutePath());
        p(file1.getPath());
        p(file1.exists() ? "exist" : "don't exist");
        p(file2.exists() ? "exist" : "don't exist");
        p(file1.getName());
        p(file2.getName());
        p(file1.isDirectory() ? " dir" : " not dir");
        System.out.println();

        String[] fileDir = file1.list(filter);
        if (fileDir == null) throw new AssertionError();
        for (String string : fileDir) {
            System.out.println(STR."???   \{string}   ???");
        }
        if(file2.isDirectory()) {
            String[] fileList = file2.list();
            for (int i = 0; i < fileList.length; i++) {
                File f = new File(dirName + "\\" + fileList[i]);
                if(f.isDirectory()) System.out.println(fileList[i] + " dir");
                else System.out.println(fileList[i] + " file");
            }
        }
        else System.out.println(dirName + " not a dir");
    }
}
