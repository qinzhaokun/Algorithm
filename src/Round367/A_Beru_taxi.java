package Round367;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/12.
 */
public class A_Beru_taxi {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            int n = scanner.nextInt();
            double min = Double.MAX_VALUE;
            for(int i = 0;i < n;i++){
                double x = scanner.nextDouble(); double y = scanner.nextDouble(); double v = scanner.nextDouble();

                double time = Math.sqrt((x-a)*(x-a)+(y-b)*(y-b))/v;
                if(time < min) min = time;
            }
            DecimalFormat df = new DecimalFormat( "0.00000000000000000000");
            System.out.println(df.format(min));
        }
    }
}
