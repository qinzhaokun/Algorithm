package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/27.
 */
public class Gballoon {

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
        int [] V = new int[1005];
        int [][] a = new int[1005][1005];
        int [] initH = new int[1005];
        int T  = scanner.nextInt();
        int index = 1;
        while (index <= T){
            int n = scanner.nextInt();int m = scanner.nextInt();int q = scanner.nextInt();
            for(int i = 0;i < m;i++) V[i] = scanner.nextInt();
            for(int i  = 0;i < n;i++){
                int p = scanner.nextInt();
                initH[i] = scanner.nextInt();
                for(int j = 0;j < m;j++){
                    if(p == 0){
                        a[i][j] = 0;
                    }
                    else if(p*V[j] < 0){
                        a[i][j] = (int)(Math.ceil(-(double)(p)/(double)(V[j])));
                    }
                    else{
                        a[i][j] = -1;
                    }
                }
            }

            int [][] dp = new int[n][q+1];
            for(int i = 0;i < n;i++){
                for(int j = 0;j <= q;j++){
                    dp[i][j] = -1;
                }
            }
            for(int j = 0;j <= q;j++){
                if(j > 0) dp[0][j] = dp[0][j-1];
              for(int k = 0;k < m;k++){
                  int cost = Math.abs(initH[0]-k);
                  if(cost <= j && a[0][k] >= 0){
                      if(dp[0][j] == -1){
                          dp[0][j] = a[0][k];
                      }
                      else{
                          dp[0][j] = Math.min(dp[0][j],a[0][k]);
                      }
                  }
              }
            }

            for(int i = 1;i < n;i++){
                for(int j = 0;j <= q;j++){
                    if(j > 0) dp[i][j] = dp[i][j-1];
                    for(int k = 0;k < m;k++){
                        int cost = Math.abs(initH[i]-k);
                        if(cost <= j && dp[i-1][j-cost] >= 0 && a[i][k] >= 0){
                            if(dp[i][j] == -1){
                             dp[i][j] = Math.max(dp[i-1][j-cost],a[i][k]);
                            }
                            else{
                                dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][j-cost],a[i][k]));
                            }

                        }
                    }
                }
                //cal dp[i][j]
            }
            System.out.print("Case #"+index+": ");
            if(dp[n-1][q] == -1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(dp[n-1][q]);
            }
            index++;
        }
    }
}
