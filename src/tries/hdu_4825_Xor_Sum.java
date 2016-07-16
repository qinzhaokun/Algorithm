package tries;

import java.util.Scanner;

/**
 * Created by KUN on 2016/5/28.
 */
public class hdu_4825_Xor_Sum {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int total = T;
        while(T > 0){
            int Tcase = total -T + 1;
            System.out.println("Case #" + Tcase + ":");
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Triess root = new Triess();
            for(int i = 0;i < n;i++){
                int tmp = scanner.nextInt();
                Triess now = root;
                for(int j = 31;j >= 0;j--){
                    if(((tmp >> j) & 1) == 0){
                        if(now.zero == null) now.zero = new Triess();
                        now = now.zero;
                    }
                    else{
                        if(now.one == null) now.one = new Triess();
                        now = now.one;
                    }
                    if(j == 0) now.value = tmp;
                }
            }

            for(int i = 0;i < m;i++){
                int tmp = scanner.nextInt();

                Triess now = root;
                for(int j = 31;j >= 0;j--){
                    if(((tmp >> j) & 1) == 0){
                        if(now.one != null) now = now.one;
                        else if(now.zero != null) now = now.zero;
                    }
                    else{
                        if(now.zero != null) now = now.zero;
                        else if(now.one != null) now = now.one;
                    }
                }

                System.out.println(now.value);
            }
            T--;
        }
    }

    //public static insert(root)
}

class Triess{
    public Triess zero;
    public Triess one;
    public int value;

    Triess(){value = -1;}
}

