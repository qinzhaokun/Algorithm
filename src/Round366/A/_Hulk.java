package Round366.A;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/7.
 */
public class _Hulk {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        boolean hate = true;
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            hate = true;
            while(n > 1){
                if(hate)
                    System.out.print("I hate that ");
                else
                    System.out.print("I love that ");

                hate = !hate;
                n--;
            }

            if(hate)
                System.out.println("I hate it");
            else
                System.out.println("I love it");
        }
    }
}
