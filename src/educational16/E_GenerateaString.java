package educational16;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/22.
 */
public class E_GenerateaString {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n  = scanner.nextInt(); int x = scanner.nextInt(); int y = scanner.nextInt();

            double [] a = new double[2*n+1];

            for(int i = 1;i <=n;i++){
                if(a[i] == 0) a[i]  = i*x;


                if(a[i] > i*x) a[i] = i*x;

                    if(a[2*i] == 0)
                        a[2*i] = a[i] + y;
                else{
                        if(a[2*i] > a[i] + y) a[2*i] = a[i] + y;
                    }
                    int t = 2*i;double last = a[2*i];
                    while(t > 0) {
                        if(a[t] == 0 || a[t] > last){

                            a[t] = last;
                        }

                        last += x;
                        t--;
                    }

                t = 2*i;last = a[2*i];
                while(t <= 2*n){
                    if(a[t] == 0 || a[t] > last){
                        a[t] = last;
                    }

                    last += x;
                    t++;
                }

            }

            System.out.println(a[n]);
        }
    }
}
