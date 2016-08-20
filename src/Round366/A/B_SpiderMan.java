package Round366.A;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/7.
 */
public class B_SpiderMan {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n  = scanner.nextInt();
            int win = 2;
            for(int i = 0;i < n;i++){
                int a = scanner.nextInt();
                if(a % 2 == 0){
                    win = 3-win;
                }

                System.out.println(win);
            }
        }
    }
}
