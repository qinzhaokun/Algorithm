package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class _1 {

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
        int t = scanner.nextInt();
        int r = 1;
        while(r <= t){
            int n = scanner.nextInt();scanner.nextLine();
            String target = "";
            String output = "";
            int max = 0;
            for(int i = 0;i < n;i++){
                String line = scanner.nextLine();
                String afterReMove = remove(line);
                int num = count(afterReMove);
                if(max < num || (max == num && line.compareTo(target) < 0)){
                    max = num;target = afterReMove;output = line;
                }
            }
            System.out.println("Case #"+r+": " + output);
            r++;
        }

    }

    static int count(String line){
        int [] c = new int[26];
        int num = 0;
        for(int i = 0;i < line.length();i++){
            int tmp = line.charAt(i)-'A';
            if(c[tmp] == 0) {num++;c[tmp]++;}
        }
        return num;
    }

    static String remove(String line){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < line.length();i++){
            if(line.charAt(i) != ' ') sb.append(line.charAt(i));
        }
        return sb.toString();
    }
}
