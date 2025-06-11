package src.chapterTwo.JavaUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        String testString = "This is a string for: testing findLine in Scanner class .";

        Scanner strScan = new Scanner(testString);
        strScan.findInLine("for:");
        if(strScan.hasNext()) {
            System.out.println(strScan.next());
        }else {
            System.out.println("Error mf!");
        }
        strScan.close();

        FileWriter fileOut = new FileWriter("ScannerTest.txt");
        fileOut.write("524, 457, 325, 132, 327, 435, 41, 6, 1, 4, done");
        fileOut.close();

        FileReader fileReader = new FileReader("ScannerTest.txt");
        Scanner scanFromFile = new Scanner(fileReader);

        System.out.println(scanFromFile.delimiter());
        scanFromFile.useDelimiter(", ");

        while (scanFromFile.hasNext()) {
            if (scanFromFile.hasNextDouble()) {
                sum+= scanFromFile.nextDouble();
                count++;
            } else {
                String str = scanFromFile.next();
                if(str.equals("done")) {
                    break;
                } else {
                    System.out.println("Wrong input !!!");
                    return;
                }
            }
        }

        System.out.printf("Sum of numbers in file: %.0f \n", sum);
        System.out.print("Now enter more numbers(\"done\" to finish): ");

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum+= scanner.nextDouble();
                System.out.println(sum);
                count++;
            } else {
                String str = scanner.next();
                if(str.equals("done")) {
                    break;
                } else {
                    System.out.println("Wrong input !!!");
                    continue;
                }
            }
        }

        scanner.close();
        scanFromFile.close();
        System.out.printf("The average is %.1f", sum/count);
    }
}