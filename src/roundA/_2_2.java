package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class _2_2 {
    static int [][] matrix = new int[55][55];
    static boolean [][] isV = new boolean[55][55];
    static int m = 0,n = 0;
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
        int t = scanner.nextInt();
        int r = 1;
        while(r <= t){
            m = scanner.nextInt();n = scanner.nextInt();
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }
            m--;n--;
            int sum = 0;
            int last = -1;
            while(true){
                if(last == sum) break;
                last = sum;
                for(int i = 1;i <= m-1;i++){
                    for(int j = 1;j <= n-1;j++){
                        clear();
                        int min = dfs(i,j,matrix[i][j]);
                        if(min != Integer.MAX_VALUE && min > matrix[i][j]){
                            sum += (min-matrix[i][j]);
                            matrix[i][j] = min;
                        }
                    }
                }
            }


            System.out.println("Case #"+r+": " + sum);
            r++;
        }
    }

    public static int dfs(int i, int j,int ta){
        if(i == 0 || i == m || j == 0 || j == n) return matrix[i][j];
        if(ta < matrix[i][j]) return matrix[i][j];
        if(i == 1 && j == 1){
            int a = 0;
        }
        int [][] d = {{0,1},{0,-1},{-1,0},{1,0}};
        isV[i][j] = true;
        int min = Integer.MAX_VALUE;
        for(int t = 0;t < 4;t++){
            int nextI = i + d[t][0];
            int nextJ = j + d[t][1];
            if(isV[nextI][nextJ]) continue;
            int value1 = dfs(nextI,nextJ,ta);
            if(value1 < min) min = value1;
        }
        return min;
    }

    public static void clear(){
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                isV[i][j] = false;
            }
        }
    }
}
