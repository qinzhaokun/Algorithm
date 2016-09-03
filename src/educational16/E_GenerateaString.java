package educational16;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/22.
 */
public class E_GenerateaString {

//    public static void main(String []args){
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNext()){
//            int n  = scanner.nextInt(); int x = scanner.nextInt(); int y = scanner.nextInt();
//
//            double [] a = new double[2*n+1];
//
//            for(int i = 1;i <=n;i++){
//                if(a[i] == 0) a[i]  = i*x;
//
//
//                if(a[i] > i*x) a[i] = i*x;
//
//                    if(a[2*i] == 0)
//                        a[2*i] = a[i] + y;
//                else{
//                        if(a[2*i] > a[i] + y) a[2*i] = a[i] + y;
//                    }
//                    int t = 2*i;double last = a[2*i];
//                    while(t > 0) {
//                        if(a[t] == 0 || a[t] > last){
//
//                            a[t] = last;
//                        }
//
//                        last += x;
//                        t--;
//                    }
//
//                t = 2*i;last = a[2*i];
//                while(t <= 2*n){
//                    if(a[t] == 0 || a[t] > last){
//                        a[t] = last;
//                    }
//
//                    last += x;
//                    t++;
//                }
//
//            }
//
//            System.out.println(a[n]);
//        }
//    }
/*
traditional dp, use dp[i] to represent the minimum effort to get i a. if i is odd, it can be obtained by i-1 a add one or i+1 a min one.
if i is even, other the situation above, it can get by double i/2 (a[i/2]+y)
*/

    //Accepted solution
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n  = scanner.nextInt(); int x = scanner.nextInt(); int y = scanner.nextInt();
            long [] a= new long[n+2]; a[0] = 0;
            for(int i = 1;i < n+2;i++){
                if(a[i] == 0) a[i] = a[i-1]+x;
                else a[i] = Math.min(a[i],a[i-1]+x);
                if((i&1) == 0){
                    if(a[i/2]+y < a[i]) a[i] = a[i/2]+y;
                }
                if(a[i]+x < a[i-1]) a[i-1] = a[i]+x;
            }
            System.out.println(a[n]);
        }
    }
}
