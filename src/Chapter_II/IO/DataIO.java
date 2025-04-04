package src.Chapter_II.IO;

import java.io.*;

public class DataIO {
    public static void main(String[] args) {
        try (DataOutputStream dOut =
                     new DataOutputStream(new FileOutputStream("Test_Data_IO.dat")))
        {
            dOut.writeInt(65);
            dOut.writeBoolean(true);
            dOut.writeInt(33);
            dOut.writeDouble(4.20);
            dOut.writeInt(77);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            e.getStackTrace();
        }

        try (DataInputStream dIn =
                     new DataInputStream(new FileInputStream("Test_Data_IO.dat")))
        {
            int i = dIn.readInt();
            boolean b = dIn.readBoolean();
            int i1 = dIn.readInt();
            double d = dIn.readDouble();
            int i2 =dIn.readInt();
            System.out.println(STR."\{i}, \{i1}, \{i2} : \{b} : \{d}");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}