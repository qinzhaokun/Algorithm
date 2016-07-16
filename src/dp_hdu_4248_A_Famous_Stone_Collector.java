/*
Problem Description
Mr. B loves to play with colorful stones. There are n colors of stones in his collection. Two stones with the same color are indistinguishable. Mr. B would like to 
select some stones and arrange them in line to form a beautiful pattern. After several arrangements he finds it very hard for him to enumerate all the patterns. So he asks you to write a program to count the number of different possible patterns. Two patterns are considered different, if and only if they have different number of stones or have different colors on at least one position.
 

Input
Each test case starts with a line containing an integer n indicating the kinds of stones Mr. B have. Following this is a line containing n integers - the number of 
available stones of each color respectively. All the input numbers will be nonnegative and no more than 100.
 

Output
For each test case, display a single line containing the case number and the number of different patterns Mr. B can make with these stones, modulo 1,000,000,007, 
which is a prime number.
 

Sample Input
3
1 1 1
2
1 2
 

Sample Output
Case 1: 15
Case 2: 8

Hint

In the first case, suppose the colors of the stones Mr. B has are B, G and M, the different patterns Mr. B can form are: B; G; M; BG; BM; GM; GB; MB; MG; 
BGM; BMG; GBM; GMB; MBG; MGB.
*/

package dp;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/6 0006.
 */
public class dp_hdu_4248_A_Famous_Stone_Collector {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int  M = 1000000007;

        int [][] c = new int[10007][107];
        c[0][0] = 1;
        for(int i = 1;i < 10007;i++){
            for(int j = 0;j <= i && j < 107;j++){
                if(j == 0) {c[i][j] = 1;}
                else {c[i][j] = (c[i-1][j] + c[i-1][j-1])%M;}
            }
        }

        int count = 0;

        while(scanner.hasNext()){
            count++;
            int n = scanner.nextInt();
            int [] nums = new int[n];
            for(int i =0;i < n;i++) nums[i] = scanner.nextInt();

            int [][] dp = new int[n][10007];

            for(int j = 0;j <= nums[0];j++) dp[0][j] = 1;

            int sum = nums[0];

            for(int i = 1;i < n;i++){
                for(int j = 0;j <= sum ;j++){
                    for(int k = 0;k <=nums[i];k++){
                        dp[i][j+k] +=(dp[i-1][j]*(c[j+k][k]%M))%M;
                    }
                }
                sum += nums[i];
            }

            int ret = 0;
            for(int j = 1;j <= sum;j++) ret = (ret + dp[n-1][j])%M;

            System.out.println("Case " + count + ": " + ret);
        }
    }
}
