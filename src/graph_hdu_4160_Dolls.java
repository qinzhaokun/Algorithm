/*Problem Description
Do you remember the box of Matryoshka dolls last week? Adam just got another box of dolls from Matryona. This time, the dolls have different shapes and sizes: some are skinny, some are fat, and some look as though they were attened. Specifically, doll i can be represented by three numbers wi, li, and hi, denoting its width, length, and height. Doll i can fit inside another doll j if and only if wi < wj , li < lj , and hi < hj .
That is, the dolls cannot be rotated when fitting one inside another. Of course, each doll may contain at most one doll right inside it. Your goal is to fit dolls inside each other so that you minimize the number of outermost dolls.
 

Input
The input consists of multiple test cases. Each test case begins with a line with a single integer N, 1 ≤ N ≤ 500, denoting the number of Matryoshka dolls. Then follow N lines, each with three space-separated integers wi, li, and hi (1 ≤ wi; li; hi ≤ 10,000) denoting the size of the ith doll. Input is followed by a single line with N = 0, which should not be processed.
 

Output
For each test case, print out a single line with an integer denoting the minimum number of outermost dolls that can be obtained by optimally nesting the given dolls.
 

Sample Input
3
5 4 8
27 10 10
100 32 523
3
1 2 1
2 1 1
1 1 2
4
1 1 1
2 3 2
3 2 2
4 4 4
0
 

Sample Output
1
3
2
 

*/

package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/9 0009.
 */
public class graph_hdu_4160_Dolls {

    static int sum = 0;

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int [][] arr = new int[505][3];
        boolean [][] g = new boolean[505][505];
        boolean [] isColor = new boolean[505];
        int [] path = new int[505];
        while(sc.hasNext()){
            int N = sc.nextInt();if(N == 0) break;
            for(int i = 0;i < N;i++){
                path[i] = 0;
                for(int j = 0;j < N;j++) g[i][j] = false;
            }
            for(int i = 0;i < N;i++) {
                arr[i][0] = sc.nextInt();arr[i][1] = sc.nextInt();arr[i][2] = sc.nextInt();

                for(int j = 0;j < i;j++){
                    if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1] && arr[i][2] > arr[j][2]) g[i][j] = true;
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] && arr[i][2] < arr[j][2]) g[j][i] = true;
                }
            }
            sum = 0;

            for(int i = 0;i < N;i++){
                Arrays.fill(isColor,false);
                if(dfs(g,i,N,isColor,path)) sum++;
            }
            System.out.println(N-sum);
        }
    }

    public static boolean dfs(boolean [][] g, int j,int N,boolean [] isColor, int [] path) {
        for(int i = 0;i < N;i++){
            if(g[j][i] && !isColor[i]){
                isColor[i] = true;
                if(path[i] == 0 || dfs(g,path[i],N,isColor,path)){
                    path[i] = j;
                    return true;
                }
            }
        }
        return false;
    }

}
