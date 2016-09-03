package roundB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/28.
 */
public class SherlockandParentheses {

    public static void main(String []args){

        try {
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));
            System.setOut(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int index = 1;
        while(index <= T){
            int l = scanner.nextInt();int r = scanner.nextInt();
            long m = Math.min(l,r);
            double ret = 0;
            ret = (1+m)*m/2;
            System.out.println("Case #"+index+": "+(long)ret);
            index++;
        }
    }
}
