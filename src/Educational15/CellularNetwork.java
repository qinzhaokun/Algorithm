package Educational15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zqin on 2016/7/30.
 */
public class CellularNetwork {

    public static void main(String [] args){
        int [] a = new int [100005];
        int [] b = new int [100005];

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();int m = scanner.nextInt();
            for(int i = 0;i < n;i++) a[i] = scanner.nextInt();
            for(int i = 0;i < m;i++) b[i] = scanner.nextInt();
            int max = 0;
            Arrays.sort(b,0,m);
            for(int i = 0;i < n;i++){
                int index = find(b,m,a[i]);
                int k = Math.abs(b[index]-a[i]);
                if(index-1 >= 0 && Math.abs(b[index-1]-a[i])< k ) k = Math.abs(b[index-1]-a[i]);
                if(index+1 < m && Math.abs(b[index+1]-a[i])< k ) k = Math.abs(b[index+1]-a[i]);

                if(max < k) max = k;
            }
            System.out.println(max);
        }
    }
    public static int find(int [] b, int m,int t){
        int i = 0; int j = m-1;
        while(i < j){
            int mid = i + (j-i)/2;
            if(b[mid] == t) return mid;
            else if(b[mid] > t) j = mid-1;
            else i = mid+1;
        }
        return i;
    }
}
