package Round365;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zqin on 2016/8/4.
 */
public class B_Mishka_and_trip {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        long [] a = new long[100005];
        while(scanner.hasNext()){
            int n = scanner.nextInt(); int k = scanner.nextInt();
            long sum = 0;
            long total = 0;
            for(int i = 0;i < n;i++) {
                a[i] = scanner.nextInt();
                sum += a[i];
                if(i > 0) total += a[i]*a[i-1];
                if(i == n-1) total += a[i]*a[0];
            }
            int have = 0;
            boolean f = false;
            //Set<Integer> set = new HashSet<Integer>();
            int last = -2;
            for(int i = 0;i < k;i++){

                long tmp = sum;
                int c = scanner.nextInt()-1;
                if(c == 0) f=true;
                if(c-1 != last){
                    if(c!= 0) tmp-=a[c-1];
                    else{
                        tmp -= a[n-1];
                    }
                }

                if(c != n-1) tmp-=a[c+1];
                else{
                    if(!f)
                    tmp-= a[0];
                }
                have+=a[c];
                tmp-=have;
                if(tmp >= 0)
                total += (a[c]*tmp);
                last = c;
            }

            System.out.println(total);
        }
    }
}
