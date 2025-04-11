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
        System.out.print(s);
    }

    public static void main(String[] args) {
        String dirName = "C:\\Users\\papri\\Full\\src\\Chapter_I\\IO";
        File file1 = new File("C:\\Users\\papri\\Full");
        File file2 = new File(dirName);
        MyFileNameFilter filterPng = new MyFileNameFilter("png");
        MyFileNameFilter filterDat = new MyFileNameFilter("dat");
        p(file1.exists() ? "exist" : "don't exist");
        System.out.println();
        p(file2.exists() ? "exist" : "don't exist");
        System.out.println();
        p(file1.getName()+" ");
        p(file1.getAbsolutePath()+"\n");
        p(file2.getName()+" ");
        p(file2.getPath()+"\n");
        p("File 1 is " + (file1.isDirectory() ? "dir" : "not dir")+"\n");
        System.out.println();

        String[] fileDir = file1.list(filterPng);
        if (fileDir == null) throw new AssertionError();
        for (String string : fileDir) {
            System.out.println(STR."???   \{string}   ???");
        }
        System.out.println();

        if(file1.isDirectory()) {
            String[] fileList = file1.list(filterDat);
            for (String string : fileList) {
                File f = new File(dirName + "\\" + string);
                if (f.isDirectory()) System.out.println(string + " dir");
                else System.out.println(string + " file");
            }
        }
        else System.out.println(dirName + " not a dir");
    }
}
