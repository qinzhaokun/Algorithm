/*
Problem Description
Nowadays, we all know that Computer College is the biggest department in HDU. But, maybe you don't know that Computer College had ever been split into Computer College and Software College in 2002.
The splitting is absolutely a big event in HDU! At the same time, it is a trouble thing too. All facilities must go halves. First, all facilities are assessed, and two facilities are thought to be same if they have the same value. It is assumed that there is N (0<N<1000) kinds of facilities (different value, different kinds).
 

Input
Input contains multiple test cases. Each test case starts with a number N (0 < N <= 50 -- the total number of different facilities). The next N lines contain an integer V (0<V<=50 --value of facility) and an integer M (0<M<=100 --corresponding number of the facilities) each. You can assume that all V are different.
A test case starting with a negative integer terminates input and this test case is not to be processed.
 

Output
For each case, print one line containing two integers A and B which denote the value of Computer College and Software College will get respectively. A and B should be as equal as possible. At the same time, you should guarantee that A is not less than B.
 

Sample Input
2
10 1
20 1
3
10 1 
20 2
30 1
-1
 

Sample Output
20 10
40 40
*/


package hdu;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/28 0028.
 */
//多重背包问题
public class hdu_1171_Big_Event_in_HDU {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(true){
            int n = scanner.nextInt();
            if(n < 0) break;
            int [] value = new int[n];
            int [] num = new int[n];
            int total = 0;
            for(int i = 0; i < n;i++) {value[i] = scanner.nextInt();num[i] = scanner.nextInt(); total += value[i]*num[i];}
            int sum = total;
            total /= 2;total+=1;
            boolean [][] dp = new boolean [2][total];

            //for(int i = 0;i < total;i++) dp[0][i] = true;
            dp[0][0] = true;
            int d = 1;

            for(int i = 0;i < n;i++){
                for(int j = 0;j < total;j++){
                    int number = 0;
                    while(number <= num[i] && j - number*value[i] >= 0){
                        if(dp[1-d][j-number*value[i]]) {dp[d][j] = true;break;}
                        number++;
                    }
                }
                d = 1-d;
            }
            int j = total-1;
            while(j >= 0 && !dp[1-d][j]) j--;

            System.out.println(sum-j + " " + j);

        }
    }
}
