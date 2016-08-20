package Round367;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/12.
 */
public class B_Interesting_drink {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] a = new int[100005];
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            for(int i = 0;i < n;i++) a[i] = scanner.nextInt();

            Arrays.sort(a,0,n);

            int q = scanner.nextInt();
            for(int i = 0;i < q;i++){
                int m = scanner.nextInt();
                int index = find(a,n,m);
                if(a[index] <= m) index++;
                System.out.println(index);
            }
        }
    }

    public static int find(int [] a ,int n, int m){
        int i = 0;int j = n-1;
        while(i < j){
            int mid = i+(j-i)/2+1;
            if(a[mid] > m){
                j = mid-1;
            }
            else{
                i = mid;
            }
        }
        return i;
    }
}
