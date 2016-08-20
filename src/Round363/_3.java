package Round363;

import java.util.Scanner;

/**
 * Created by zqin on 2016/7/19.
 */
public class _3 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int dp0 = 0,dp1 = n,dp2=n;
            for(int i = 1;i <= n;i++){
                int v = scanner.nextInt();
                if(v == 0){
                    int min = Math.min(dp0,Math.min(dp1,dp2));
                    dp0 =  min+1;
                    dp1 = dp2 = n;
                }
                else if(v == 1){
                    int min = Math.min(dp0,Math.min(dp1,dp2));
                    dp1 = Math.min(dp0,dp2);
                    dp2 = n;
                    dp0 = min+1;
                }
                else if(v == 2){
                    int min = Math.min(dp0,Math.min(dp1,dp2));
                    dp2 = Math.min(dp0,dp1);
                    dp1 = n;
                    dp0 = min+1;
                }
                else{
                    int min = Math.min(dp0,Math.min(dp1,dp2));
                    int dp1tmp = Math.min(dp0,dp2);
                    dp2 = Math.min(dp0,dp1);
                    dp1 = dp1tmp;
                    dp0 = min+1;
                }
            }
            System.out.println(Math.min(dp0,Math.min(dp1,dp2)));
        }
    }
}
