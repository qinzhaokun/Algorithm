/*
Problem Description
Alice and Bob are playing a game. There are two piles of cards. There are N cards in each pile, and each card has a score. They take turns to pick up the top or bottom card from either pile, and the score of the card will be added to his total score. Alice and Bob are both clever enough, and will pick up cards to get as many scores as possible. Do you know how many scores can Alice get if he picks up first?
 

Input
The first line contains an integer T (T≤100), indicating the number of cases. 
Each case contains 3 lines. The first line is the N (N≤20). The second line contains N integer ai (1≤ai≤10000). The third line contains N integer bi (1≤bi≤10000).
 

Output
For each case, output an integer, indicating the most score Alice can get.
 

Sample Input
2 
 
1 
23 
53 
 
3 
10 100 20 
2 4 3 
 

Sample Output
53 
105 
*/


package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/15 0015.
 */
public class dp_hdu_4597_play_game {

    static int [] a = new int[25];
    static int [] b = new int[25];
    static int [][][][] dp = new int[25][25][25][25];

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while((t--) > 0){
            int n = scanner.nextInt();
            int sum = 0;
            for(int i = 1;i <= n;i++){
                sum += scanner.nextInt();
                a[i] = sum;
            }
            sum = 0;
            for(int i = 1;i <= n;i++){
                sum += scanner.nextInt();
                b[i] = sum;
            }

            for(int i = 0;i <= n+1;i++) for(int j = 0;j <= n+1;j++) for(int k = 0;k <= n+1;k++) for(int s = 0;s <= n+1;s++) dp[i][j][k][s] = -1;
            dfs(0,n+1,0,n+1);
            System.out.println(dp[0][n+1][0][n+1]);

        }
    }

    public static int dfs(int il,int ir, int jl,int jr){
        //if(il > ir || jl > jr) return 0;
        if( dp[il][ir][jl][jr] > 0) return dp[il][ir][jl][jr];
        //dp[il][ir][jl][jr] = 0;
        int max = 0;
        int one = 0; int two = 0;
        if(ir > il) one = a[ir-1]-a[il];
        if(jr > jl) two = b[jr-1]-b[jl];
        int sum = one + two;
        if(ir > il+1){
            max = Math.max(max,sum - dfs(il+1,ir,jl,jr));
            max = Math.max(max,sum - dfs(il,ir-1,jl,jr));
            //else max = Math.max(max,two);
        }
        if(jr > jl+1){
            max = Math.max(max,sum-dfs(il,ir,jl+1,jr));
            max = Math.max(max,sum-dfs(il,ir,jl,jr-1));
            //else max = Math.max(max,one);
        }
         dp[il][ir][jl][jr] = max;
        return max;
    }
}
