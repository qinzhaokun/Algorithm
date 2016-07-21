package Round363;

import java.util.Scanner;

/**
 * Created by zqin on 2016/7/19.
 */
public class _2 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {


            int m = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();

            char [][] a = new char[m][n];
            int [] r = new int [m];
            int [] c = new int [n];
            int sum = 0;
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                char[] arr = line.toCharArray();
                for (int j = 0; j < n; j++) {
                    a[i][j] = arr[j];
                    if(arr[j] == '*'){
                        r[i]++;
                        c[j]++;
                        sum++;
                    }
                }
            }
            boolean flag = false;
           for(int i = 0;i < m;i++){
               if(flag) break;
               for(int j = 0;j < n;j++){
                   int num = r[i]+c[j];
                   if(a[i][j] == '*') num--;
                   if(num == sum){
                       System.out.println("YES");
                       System.out.println((i+1) + " " + (j+1));
                       flag = true;break;
                   }
               }
           }
            if(!flag){
                System.out.println("NO");
            }
        }
    }
}
