package roundB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/28.
 */
public class SherlockandWatsonGymSecrets {

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
        while(index<=T){
            int a =scanner.nextInt();
            int b =scanner.nextInt();
            int n =scanner.nextInt();
            k =scanner.nextLong();
            long ret = 0;
            for(int i = 1;i <= n;i++){
                for(int j = 1;j <= n;j++){
                    if(i != j){
                        long q1 = pow(i%k,a);
                        long q2 = pow(j%k,b);

                        if((q1+q2)%k == 0) ret++;

                        ret %= 1000000007;
                    }
                }
            }

            System.out.println("Case #"+index+": "+(long)ret);
            index++;
        }
    }

    public static long pow(long t,int n){
        if(n == 0) return 1;
        if(n == 1) return t;
        int mid = n/2;
        long ret = pow(t,mid);
        ret %= k;
        if(n %2 == 0){
            return (ret*ret)%k;
        }
        else{
            return (ret*ret*t)%k;
        }
    }

}
