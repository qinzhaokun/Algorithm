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
            int x1 = -1; int y1 = -1;
            int x2 = -1;int y2 = -1;
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                char[] arr = line.toCharArray();
                for (int j = 0; j < n; j++) {
                    if(arr[j] == '*'){
                        if(x1 == -1){
                            x1 = i;y1 = j;
                        }
                        else if(i == x1 || j == y1){
                            continue;
                        }
                        else if(x2 == -1){
                            x2 = i;y2 = j;
                        }
                        else if(i == x2 || j == y2){
                            continue;
                        }
                        else{
                            flag = true;
                        }
                    }
                }
            }
            if(flag){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                if(x2 == -1){
                   if(x1 == -1){
                       System.out.println(1 + " " + 1);
                   }
                    else{
                       System.out.println((x1+1) + " "+(y1+1));
                   }
                }
                else {
                    System.out.println((x2+1)+" "+(y1+1));
                }
            }


        }
    }
}
