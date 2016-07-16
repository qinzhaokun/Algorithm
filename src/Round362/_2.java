package Round362;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/15.
 */
public class _2 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String [] arr = s.split("e");
            int pow = Integer.parseInt(arr[1]);
            String [] pre =arr[0].split("\\.");
            int n = pre[1].length()-pow;
            boolean dot = false;
            if(n > 0) {arr[0] = pre[0] + pre[1].substring(0,pow);arr[1] = pre[1].substring(pow);dot = true;}
            else {
                arr[0] = pre[0] + pre[1];
                char [] tmp = new char[-n];
                Arrays.fill(tmp,'0');
                arr[0] += new String(tmp);
            }

            int i = 0;
            while(i < arr[0].length() && arr[0].charAt(i) == '0') i++;
            if(i == arr[0].length()) System.out.print("0");
            else{
                System.out.print(arr[0].substring(i));
            }
            if(dot){
                i = 0;
                while(i < arr[1].length() && arr[1].charAt(i) == '0') i++;
                if(i != arr[1].length()){
                    System.out.print("." + arr[1]);
                }
            }

            System.out.println();
        }
    }
}
