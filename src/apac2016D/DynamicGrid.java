package apac2016D;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/27.
 */
public class DynamicGrid {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int now = 0;
        int index = 0;
        boolean [][]g = new boolean[105][105];
        boolean [][]numG = new boolean[105][105];
        while (index++ <= T){
            int r = scanner.nextInt(); int c = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < r; i++){
                String line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++){
                    g[i][j] = (line.charAt(j) == '1');
                }
            }

            int n = scanner.nextInt();
            now = cal(g,numG,r,c);
            System.out.println("Case #" + index + " :");
            scanner.nextLine();
            for (int i = 0; i < n; i++){
                String line = scanner.nextLine();
                if(line.charAt(0) == 'Q'){
                    System.out.println(now);
                }
                else{
                    String [] arr = line.split(" ");
                    int u  = Integer.valueOf(arr[1]);
                    int v = Integer.valueOf(arr[2]);
                    if(g[u][v] != (arr[3].charAt(0) == '1')){
                        g[u][v] = !g[u][v];
                        now = cal(g,numG,r,c);
                    }
                }
            }
        }
    }

    public static int cal(boolean [][]g,boolean [][]numG, int r, int c){
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                numG[i][j] = false;
            }
        }
        int indexI = 1;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (g[i][j] && !numG[i][j]){
                    dfs(g, r, c, numG, i, j);
                    indexI++;
                }
            }
        }
        return indexI-1;
    }
    public static void dfs(boolean [][]g, int r, int c, boolean [][]numG, int i, int j){
        numG[i][j] = true;
        int [][]d = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int t = 0; t < 4; t++){
            int newI = i + d[t][0];
            int newJ = j + d[t][1];
            if (newI >= 0 && newI < r && newJ >= 0 && newJ < c && g[newI][newJ] && !numG[newI][newJ]){
                dfs(g, r, c, numG, newI, newJ);
            }
        }
    }
}
