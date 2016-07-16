package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class _2 {

    static int [][] matrix = new int[55][55];
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
            int index = 0;
            int sum = 0;
            m--;n--;
            while(true){
                int min = getMin(index,index);
                if(min < 0) break;
                sum += fill(index+1,index+1,min);
                index++;
            }
            System.out.println("Case #"+r+": " + sum);
            r++;
        }
    }


    static int getMin(int m1, int n1){
        int topM = m1;
        int botM = m-m1;
        int leftN = n1;
        int rightN = n-n1;
        if(topM+1 >= botM || leftN+1 >= rightN) return -1;
        else{
            int min = Integer.MAX_VALUE;
            for(int i = leftN+1;i <= rightN-1;i++){
                if(min > matrix[topM][i]) min = matrix[topM][i];
                if(min > matrix[botM][i]) min = matrix[botM][i];
            }
            for(int i = topM+1;i <= botM-1;i++){
                if(min > matrix[i][leftN]) min = matrix[i][leftN];
                if(min > matrix[i][rightN]) min = matrix[i][rightN];
            }
            return min;
        }

    }

    static int fill(int m1, int n1,int min){
        int topM = m1;
        int botM = m-m1;
        int leftN = n1;
        int rightN = n-n1;
        int sum = 0;
        for(int i = leftN;i <= rightN;i++){
            if(matrix[topM][i] < min){
                sum += (min - matrix[topM][i]);
                matrix[topM][i] = min;
            }
            if(matrix[botM][i] < min){
                sum += (min - matrix[botM][i]);
                matrix[botM][i] = min;
            }
        }
        for(int i = topM;i <= botM;i++){
            if(matrix[i][leftN] < min){
                sum += (min - matrix[i][leftN]);
                matrix[i][leftN] = min;
            }
            if(matrix[i][rightN] < min){
                sum += (min - matrix[i][rightN]);
                matrix[i][rightN] = min;
            }
        }
        return sum;
    }
}
