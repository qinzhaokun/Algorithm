package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class _3 {
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
            int n = scanner.nextInt();
            double a = scanner.nextInt();
            double b = 0,c = 0;
            double [] aa = new double[n+1];
            for(int i = 0;i < n;i++){
                aa[i+1] = scanner.nextDouble();
            }
            a = -a;
            aa[0] = a;
            double l = 0;double e = 2;double mid = (l+e)/2;
            while(true){
                mid = (l+e)/2;
                double re = cal(mid,aa);
                if(Math.abs(re-0) < 0.000000001){
                    break;
                }
                if(re == 0) break;
                if(re < 0) e = mid;
                else l = mid;
            }
            mid-=1;
            DecimalFormat df = new DecimalFormat( "0.000000000000");

            System.out.println("Case #"+r+": " +df.format(mid));
        r++;
        }
    }

    public static double cal(double x, double [] aa){
        int n = aa.length;
        double re = aa[n-1];
        double base = x;
        for(int i = n-2;i >= 0;i--){
            re += aa[i]*x;
            x*=base;
        }
        return re;
    }
}
