/*
Description

New convocation of The Fool Land's Parliament consists of N delegates. According to the present regulation delegates should be divided into disjoint groups of different sizes and every day each group has to send one delegate to the conciliatory committee. The composition of the conciliatory committee should be different each day. The Parliament works only while this can be accomplished. 
You are to write a program that will determine how many delegates should contain each group in order for Parliament to work as long as possible. 
Input

The input file contains a single integer N (5<=N<=1000 ).
Output

Write to the output file the sizes of groups that allow the Parliament to work for the maximal possible time. These sizes should be printed on a single line in ascending order and should be separated by spaces.
Sample Input

7
Sample Output

3 4
*/

package poj;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/4 0004.
 */
public class poj_1032_Parliament {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        int sum = 0;
        int i = 2;
        while(sum < m) {sum+=i;i++;}
        i--;
        sum -= i;

        if(sum + i == m){
            for(int j = 2;j <i;j++) System.out.print(j+ " ");
            System.out.print(i);
        }
        else{
            int len = i-2;
            int [] arr = new int[len];
            for(int j = 0;j < len;j++) arr[j] = j+2;

            int more = m - sum;
            int index = i-3;
            while(more > 0){
                arr[index--]++;
                if(index == -1) index = i-3;
                more--;
            }
            for(int j = 0;j < len-1;j++) System.out.print(arr[j] + " ");
            System.out.print(arr[len-1]);
        }

    }
}
