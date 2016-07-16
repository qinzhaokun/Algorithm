/*
Problem Description
Ignatius was born in a leap year, so he want to know when he could hold his birthday party. Can you tell him?

Given a positive integers Y which indicate the start year, and a positive integer N, your task is to tell the Nth leap year from year Y.

Note: if year Y is a leap year, then the 1st leap year is year Y.
 

Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case contains two positive integers Y and N(1<=N<=10000).
 

Output
For each test case, you should output the Nth leap year from year Y.
 

Sample Input
3
2005 25
1855 12
2004 10000
 

Sample Output
2108
1904
43236

Hint

We call year Y a leap year only if (Y%4==0 && Y%100!=0) or Y%400==0.
*/

package hdu;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/26 0026.
 */
public class hdu_1076_An_Easy_Task {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while(T > 0){
            int Y = scanner.nextInt();
            int N = scanner.nextInt();
            int i = 1;
            while(true){
                if((Y%4==0 && Y%100!=0) || Y%400==0) break;
                Y++;
            }
            while(true){
                if(i == N) break;
                if(Y % 400 == 399) Y+=1;
                else if(Y % 400 == 398) Y+=2;
                else if(Y % 400 == 397) Y+=3;
                else if(Y % 400 ==396) Y+=4;
                else if(Y % 100 == 96) Y+=8;
                else Y+=4;
                i++;
            }
            System.out.println(Y);
            T--;
        }
    }
}
