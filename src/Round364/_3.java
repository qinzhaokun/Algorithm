package Round364;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zqin on 2016/7/23.
 */
public class _3 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] a = new int[100];
       // int max = 0;
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            scanner.nextLine();
            Arrays.fill(a,0);
            String line = scanner.nextLine();
            int count = 0;
            for(int i = 0;i < line.length();i++){
                if(a[line.charAt(i)-'A'] == 0) count++;
                a[line.charAt(i)-'A']++;
            }
            int sum = 0;int max = n;
            int j = 0;
            Arrays.fill(a,0);
            int i = 0;
            for(i = 0;i < n;i++) {
                a[line.charAt(i) - 'A']++;
                if (a[line.charAt(i) - 'A'] == 1) sum++;
                if (sum == count) {
                    if (max > i - j + 1) max = i - j + 1;
                    while (j < n && a[line.charAt(j) - 'A'] > 1) {a[line.charAt(j)-'A']--;j++;}
                    if(max > i-j+1) max = i-j+1;
                    break;
                }
            }
            i++;
            for(;i<n;i++) {
                a[line.charAt(i)-'A']++;
                if(line.charAt(i) != line.charAt(j)) {continue;}
                while (j < n && a[line.charAt(j) - 'A'] > 1) {a[line.charAt(j)-'A']--;j++;}
                if(max > i-j+1) max = i-j+1;
            }

            System.out.println(max);
            }



    }
}
