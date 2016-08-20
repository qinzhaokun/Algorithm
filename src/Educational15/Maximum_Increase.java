package Educational15;

import java.util.Scanner;

/**
 * Created by zqin on 2016/7/29.
 */
public class Maximum_Increase {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int [] a = new int[n];
            for(int i = 0;i < n;i++) a[i] = scanner.nextInt();

            System.out.println(lis(a));
        }
    }
    public static int lis(int [] array)
    {
        Integer []lis = new Integer[array.length];
        int max = 0;
        for(int i =0;i<array.length;i++)
        {
            if(i == 0) lis[i] = 1;
            else{
                if(array[i] > array[i-1]) lis[i] = lis[i-1]+1;
                else lis[i] = 1;
            }
            if(max < lis[i]) max = lis[i];
        }
        return max;
    }

}
