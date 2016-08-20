package Round363;

import java.util.Scanner;

/**
 * Created by zqin on 2016/7/19.
 */
public class _1 {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        char[] m = line.toCharArray();
        int[] pos = new int[n];
        int min = -1;
            int last = -1;
        for (int i = 0; i < n; i++) {
            pos[i] = scanner.nextInt();
            if (m[i] == 'R') {last = i;}
            else{
                if(last != -1){
                    if(min == -1 || (pos[i]-pos[last])/2 < min){
                        min = (pos[i]-pos[last])/2;
                    }
                }
            }

        }
            System.out.println(min);
    }



    }
}
