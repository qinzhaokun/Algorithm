/*
Problem Description
有n种物品，并且知道每种物品的数量。要求从中选出m件物品的排列数。例如有两种物品A,B，并且数量都是1，从中选2件物品，则排列有"AB","BA"两种。
 

Input
每组输入数据有两行，第一行是二个数n,m(1<=m,n<=10)，表示物品数，第二行有n个数，分别表示这n件物品的数量。
 

Output
对应每组数据输出排列数。(任何运算不会超出2^31的范围)
 

Sample Input
2 2
1 1
 

Sample Output
2
*/


package mother_function;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/1 0001.
 */
public class mother_function_hdu_1521_pailiezuhe {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] arr = new int [n];
        for(int i = 0;i < n;i++) arr[i] = scanner.nextInt();

        double [] xishu = new double [m+1];
        xishu[0] = 1.0;
        for(int i = 1;i <= m;i++) xishu[i] = i*xishu[i-1];
        for(int i = 0;i <= m;i++) xishu[i] = 1.0/xishu[i];

        double [] xishu2 = new double[m+1];
        double [] xishu3 = new double[m+1];

        if(n > 0){
            for(int i = 0;i <= arr[0] && i <= m;i++) xishu2[i] = xishu[i];
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j <= arr[i];j++){
                for(int k = 0;k <=m && k + j <= m;k++){
                    xishu3[k+j] += xishu2[k]*xishu[j];
                }
            }
            for(int k = 0;k <=m;k++) {xishu2[k] = xishu3[k];xishu3[k] = 0;}
        }

        System.out.println((int)Math.rint(((1.0/xishu[m])*xishu2[m])));
    }
}
