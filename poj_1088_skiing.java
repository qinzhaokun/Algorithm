/*
Description

Michael喜欢滑雪百这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。Michael想知道载一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子 
 1  2  3  4 5

16 17 18 19 6

15 24 25 20 7

14 23 22 21 8

13 12 11 10 9

一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。
Input

输入的第一行表示区域的行数R和列数C(1 <= R,C <= 100)。下面是R行，每行有C个整数，代表高度h，0<=h<=10000。
Output

输出最长区域的长度。
Sample Input

5 5
1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9
Sample Output

25
*/


package poj;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/4 0004.
 */
public class poj_1088_skiing {
    public static void main(String [] args){
        Scanner scanner = new Scanner((System.in));

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int [][] arr = new int[m][n];

        int [][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++) {arr[i][j] = scanner.nextInt();dp[i][j] = -1;}
        }

        int max = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                dfs(arr,dp,i,j);
                if(dp[i][j] > max) max = dp[i][j];
            }
        }
        System.out.println(max);
    }

    public static void dfs(int [][] arr, int [][] dp, int i, int j){
        if(dp[i][j] != -1) return;

        int [][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        int max = 1;
        for(int k = 0;k < 4;k++){
            int newI = i+d[k][0];
            int newJ = j+d[k][1];
            if(newI>=0 && newI < arr.length && newJ >= 0 && newJ < arr[0].length && arr[i][j] > arr[newI][newJ]){
                dfs(arr,dp,newI,newJ);
                if(max < 1 + dp[newI][newJ]) max = 1 + dp[newI][newJ];
            }
        }
        dp[i][j] = max;
    }
}
