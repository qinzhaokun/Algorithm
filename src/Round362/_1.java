package Round362;

import java.util.Scanner;

/**
 * Created by KUN on 2016/7/15.
 */
public class _1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            if(x < s) System.out.println("NO");
            else if(x == s) System.out.println("YES");
            else if(x < s+t) System.out.println("NO");
            else{
                int a = (x-s)%t;
                if(a == 0 || a == 1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
