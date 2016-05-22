/*
Description

Farmer John has purchased a lush new rectangular pasture composed of M by N (1 ≤ M ≤ 12; 1 ≤ N ≤ 12) square parcels. He wants to grow some yummy corn for the cows on a number of squares. Regrettably, some of the squares are infertile and can't be planted. Canny FJ knows that the cows dislike eating close to each other, so when choosing which squares to plant, he avoids choosing squares that are adjacent; no two chosen squares share an edge. He has not yet made the final choice as to which squares to plant.

Being a very open-minded man, Farmer John wants to consider all possible options for how to choose the squares for planting. He is so open-minded that he considers choosing no squares as a valid option! Please help Farmer John determine the number of ways he can choose the squares to plant.

Input

Line 1: Two space-separated integers: M and N 
Lines 2..M+1: Line i+1 describes row i of the pasture with N space-separated integers indicating whether a square is fertile (1 for fertile, 0 for infertile)
Output

Line 1: One integer: the number of ways that FJ can choose the squares modulo 100,000,000.
Sample Input

2 3
1 1 1
0 1 0
Sample Output

9
Hint

Number the squares as follows:
1 2 3
  4  

There are four ways to plant only on one squares (1, 2, 3, or 4), three ways to plant on two squares (13, 14, or 34), 1 way to plant on three squares (134), and one way to plant on no squares. 4+3+1+1=9.
*/

package dp;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/22 0022.
 */
public class dp_state_poj_3254_corn_fields {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int [][] matrix = new int [m][n];
            int [] eachRow = new int[m];
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    matrix[i][j] = scanner.nextInt();
                    //eachRow: using a binary number to represent a row, e.g. 0101 --> 1010
                    if(matrix[i][j] == 0) eachRow[i] |= (1 << (n-j-1));
                }
            }

            //number of state
            int count = 0;
            //states is the collection of all valid states.
            int [] states = new int [1 << n];
            for(int i = 0;i < (1<<n);i++){
                if((i & (i << 1)) == 0) states[count++] = i;
            }

            // dp[i][j] is the all possible number in terms of state[i]
            int [][] dp = new int[m][count];


            for(int j = 0;j < count;j++){
                //if states[j] & eachRow[0]) == 0, which is means that states[j] is valid
                if((states[j] & eachRow[0]) == 0) dp[0][j] = 1;
            }

            for(int i = 1;i < m;i++){
                for(int j = 0;j < count;j++){
                    for(int k = 0;k < count;k++){
                        if((states[k] & eachRow[i]) == 0 && (states[j] & states[k]) == 0) dp[i][k] += dp[i-1][j];
                    }
                }
            }

            int ret = 0;
            for(int j = 0;j < count;j++) {ret += dp[m-1][j];ret %= 100000000;}
            System.out.println(ret);
        }
    }
}
