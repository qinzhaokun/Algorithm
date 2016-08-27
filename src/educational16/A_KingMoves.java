package educational16;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/22.
 */
public class A_KingMoves {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            int n = 8;
            if(line.charAt(0) == 'a' || line.charAt(0) == 'h'){
                n -= 3;
            }
            if(line.charAt(1) == '1' || line.charAt(1) == '8'){
                n -= 3;
            }
            if(n == 2) n++;
            System.out.println(n);
        }
    }
}
