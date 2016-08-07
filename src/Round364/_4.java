package Round364;

import java.util.Scanner;

/**
 * Created by zqin on 2016/7/23.
 */
public class _4 {

    public static void main(String [] args){
        Scanner scanner= new Scanner(System.in);
        while(scanner.hasNext()){
            double n = scanner.nextDouble();double l = scanner.nextDouble();double v1 = scanner.nextDouble();
            double v2 = scanner.nextDouble();double k = scanner.nextDouble();

            double t = 0;
            while(n > 0){
                n-=k;

                if(n <= 0) {t += (l/v2);break;}
                double nextT = (2.0*l)/(v1+v2);
                double less = v1*nextT;
                if(less >= l){
                    t += (l/v1);
                    break;
                }
                l -= less;
                t += nextT;
            }
            System.out.println(t);
        }
    }
}
