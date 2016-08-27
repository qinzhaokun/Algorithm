package Round368;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/20.
 */
public class C_Pythagorean_Triples {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            double n = scanner.nextDouble();
            double m=0,k=0;
            double i = 1;
            for(;i < n;i++){
                m = (n*n-i*i)/(2*i);
                k = (n*n+i*i)/(2*i);
                if(m < n) continue;
                if(m %1 == 0 && k %1 == 0){
                    break;
                }
            }
            if(i < n){
                NumberFormat ddf1= NumberFormat.getNumberInstance() ;
                DecimalFormat df = new DecimalFormat("#");
                ddf1.setMaximumFractionDigits(0);
                String s= df.format(m) ;
                String t = df.format(k);
                System.out.println(s + " " + t);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
