package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/16.
 */
public class _2_standard {
    static int [][] matrix = new int[55][55];
    static int [][] after = new int[55][55];
    static int [][] d = {{-1,0},{1,0},{0,1},{0,-1}};
    static int m = 0,n = 0;
    public static void main(String [] args) {
//        try {
//            FileInputStream input = new FileInputStream(args[0]);
//            System.setIn(input);
//            PrintStream output = new PrintStream(new FileOutputStream(args[1]));
//            System.setOut(output);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int r = 1;
        while (r <= t) {
            m = scanner.nextInt();n = scanner.nextInt();
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    matrix[i][j] = scanner.nextInt();
                    if(i == 0 || j == 0 || i == m-1 || j == n-1) after[i][j] = matrix[i][j];
                    else after[i][j] = 1000;
                }
            }

            boolean isChange = true;
            while(isChange){
                isChange = false;
                for(int i = 1;i < m-1;i++){
                    for(int j = 1;j < n-1;j++){
                        int min = after[i][j];
                        for(int k = 0;k < 4;k++){
                            int I = i + d[k][0]; int J = j + d[k][1];
                            if(after[I][J] < min && after[I][J] >= matrix[i][j]) min =  after[I][J];
                        }
                        if(min < after[i][j]) {after[i][j] = min;isChange = true;}
                    }
                }
            }
            int ans = 0;
            for(int i = 1;i < m-1;i++){
                for(int j = 1;j < n-1;j++){
                    ans += after[i][j] - matrix[i][j];
                }
            }
            System.out.println("Case #"+r+": " + ans);
            r++;
        }
    }
}
