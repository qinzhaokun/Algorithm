package roundB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/28.
 */
public class _2 {

    static long k;
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

        int T = scanner.nextInt();
        int index = 1;
        Map<Long,Long> map = new HashMap<>();
        while(index<=T){
            map.clear();
            int a =scanner.nextInt();
            int b =scanner.nextInt();
            long n =scanner.nextLong();
            k =scanner.nextLong();
            long ret = 0;

            for(int i = 1;i <= k;i++){
                long q1 = pow(i%k,a);
                q1 %= k;
                if(map.containsKey(q1)){
                    long v = map.get(q1)+1+get(i,n);
                    map.put(q1,v);
                }
                else{
                    long v = 1+get(i,n);
                    map.put(q1,v);
                }
            }

            for(int i = 1;i <= k;i++){
                long q2 = pow(i%k,b);
                q2 %= k;
                if(map.containsKey(k-q2)){
                    long v = map.get(k-q2);
                    long q1 = pow(i%k,a);
                    if(q1 == k-q2 && v > 0)
                        v -= 1;
                    long u = 1+get(i,n);

                    ret += (u*v)%1000000007;
                    ret %= 1000000007;
                }
                if(q2 == 0){
                    if(map.containsKey(0L)){
                        long v = map.get(0L);
                        long u = 1+get(i,n);
                        ret += (u*v)%1000000007;
                        ret %= 1000000007;
                    }
                }
            }
//            long rr = 0;
//            for(int i = 1;i <= k;i++){
//                long q1 = pow(i%k,a);
//                long q2 = pow(i%k,b);
//                if((q1+q2)%k == 0){
//                    long v = get(i,n)+1;
//                    rr += v;
//                    rr %= 1000000007;
//                }
//            }
           // ret -= rr;
//            for(int i = 1;i <= k;i++){
//                for(int j = 1;j <= k;j++){
//                    if(i != j){
//                        long q1 = pow(i%k,a);
//                        long q2 = pow(j%k,b);
//
//                        if((q1+q2)%k == 0){
//
//                            long s1 = get(i,n);
//                            long s2 = get(j,n);
//                            long ss = (s1*s2)%1000000007;
//                            ret+=ss;
//                        }
//                        ret %= 1000000007;
//                    }
//                }
//            }

            System.out.println("Case #"+index+": "+(long)ret);
            index++;
        }
    }

    public static long pow(long t,long n){
        if(n == 0) return 1;
        if(n == 1) return t;
        long mid = n/2;
        long ret = pow(t,mid);
        ret %= k;
        if(n %2 == 0){
            return (ret*ret)%k;
        }
        else{
            return (ret*ret*t)%k;
        }
    }

    public static long get(int i, long n){

        double ret = ((double)n-(double)i)/(double)k;
        long rr = (long)(Math.floor(ret)%1000000007);
        return rr;
    }

}
