package Round368;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/20.
 */
public class A_Brains_Photos {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int m = scanner.nextInt(); int n = scanner.nextInt();scanner.nextLine();
            boolean flag = true;
            for(int i = 0;i < m;i++){
                String line = scanner.nextLine();
                String [] each = line.split(" ");

                for(int j = 0;j < n;j++){
                    if(each[j].charAt(0) == 'C' || each[j].charAt(0) == 'M' || each[j].charAt(0) == 'Y') flag = false;
                }
            }

            if(flag){
                System.out.println("#Black&White");
            }
            else{
                System.out.println("#Color");
            }
        }
    }
}
