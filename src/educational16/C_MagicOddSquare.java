package educational16;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/22.
 */
public class C_MagicOddSquare {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int [][] a = new int[n][n];
            for(int i = 0; i< n; ++i)
                for(int j = 0; j < n; ++j)
                    a[i][j] = 0;
            int x = 0, y = n/2;
            a[x][y] = 1;
            for(int i = 2; i<= n*n; ++i){
                int xNew = x-1;
                int yNew = y+1;
                if(yNew > n-1)
                    yNew = 0;
                if(xNew < 0)
                    xNew = n-1;
                if(a[xNew][yNew] != 0){
                    xNew = x+1;
                    yNew = y;
                }
                a[xNew][yNew] = i;
                x = xNew;
                y = yNew;
            }
            for(int i = 0; i< n; ++i){
                for(int j = 0; j < n; ++j){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
