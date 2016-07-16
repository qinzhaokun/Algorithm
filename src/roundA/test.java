package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class test {

    public static void main(String [] args){
        try {
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));
            System.setOut(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();scanner.nextLine();
        while(n-->0){
            String line = scanner.nextLine();
            int l = line.length();
            int [][] dp = new int[4][l];
            char [] last = new char[l];


        }

    }
}
