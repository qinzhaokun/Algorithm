/*
Description

司令部的将军们打算在N*M的网格地图上部署他们的炮兵部队。一个N*M的地图由N行M列组成，地图的每一格可能是山地（用"H" 表示），也可能是平原（用"P"表示），如下图。在每一格平原地形上最多可以布置一支炮兵部队（山地上不能够部署炮兵部队）；一支炮兵部队在地图上的攻击范围如图中黑色区域所示： 


如果在地图中的灰色所标识的平原上部署一支炮兵部队，则图中的黑色的网格表示它能够攻击到的区域：沿横向左右各两格，沿纵向上下各两格。图上其它白色网格均攻击不到。从图上可见炮兵的攻击范围不受地形的影响。 
现在，将军们规划如何部署炮兵部队，在防止误伤的前提下（保证任何两支炮兵部队之间不能互相攻击，即任何一支炮兵部队都不在其他支炮兵部队的攻击范围内），在整个地图区域内最多能够摆放多少我军的炮兵部队。 
Input

第一行包含两个由空格分割开的正整数，分别表示N和M； 
接下来的N行，每一行含有连续的M个字符('P'或者'H')，中间没有空格。按顺序表示地图中每一行的数据。N <= 100；M <= 10。
Output

仅一行，包含一个整数K，表示最多能摆放的炮兵部队的数量。
Sample Input

5 4
PHPP
PPHH
PPPP
PHPP
PHHP
Sample Output

6
*/


package dp;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/22 0022.
 */
public class dp_state_poj_1185 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int [][] matrix = new int[m][n];
            int [] rows = new int[m];
            scanner.nextLine();
            for(int i = 0;i < m;i++){
                String line = scanner.nextLine();
                for(int j = 0;j < line.length();j++){
                    if(line.charAt(j) == 'P'){
                        matrix[i][j] = 1;
                    }
                    else{
                        rows[i] += (1 << (n-1-j));
                    }
                }
            }

            int [] state = new int [1 << n];
            int count = 0;
            for(int i = 0;i < (1 << n);i++){
                if((i & (i << 1)) == 0 && (i & (i << 2)) == 0) state[count++] = i;
            }

            //dp[r][i][j] means the r row with state i and r-1 row with state j, the max number so fast ([0,r])
            int [][][] dp = new int[m][count][count];
            for(int i = 0;i < m;i++) for(int j = 0;j < count;j++) for(int k = 0;k < count;k++) dp[i][j][k] = -1;
            if(m > 0){
                for(int i = 0;i < count;i++){
                    if((state[i] & rows[0]) == 0) dp[0][i][0] = countOne(state[i]);
                }
            }


            for(int r = 1;r < m;r++){
                for(int i = 0;i < count;i++){ //all state in r
                    for(int j = 0;j < count;j++){ //all state in r -1
                        for(int k = 0;k < count;k++){ //all state in r-2
                            if((state[i] & rows[r]) == 0
                                    &&(state[k] & state[i]) == 0 && (state[i] & state[j]) == 0
                                    && dp[r-1][j][k] != -1){
                                int now = countOne(state[i]);
                                if(now + dp[r-1][j][k] > dp[r][i][j]) dp[r][i][j] = now + dp[r-1][j][k];
                                if(dp[r][i][j] == 8) {
                                    System.out.print(r + " " + i +" " +  j);
                                }
                            }
                        }
                    }
                }
            }

            int max = dp[m-1][0][0];
           for(int i = 0;i < count;i++){
               for(int j = 0;j < count;j++){
                   if(max < dp[m-1][i][j]) max = dp[m-1][i][j];
               }
           }

            System.out.println(max);
        }
    }

    public static int countOne(int i) {
        int count = 0;
        while (i != 0) {
            i = (i & (i-1));
            count++;
        }
        return count;
    }
}
