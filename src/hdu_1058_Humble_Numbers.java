/*
Problem Description
A number whose only prime factors are 2,3,5 or 7 is called a humble number. The sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, 25, 27, ... shows the first 20 humble numbers. 

Write a program to find and print the nth element in this sequence
 

Input
The input consists of one or more test cases. Each test case consists of one integer n with 1 <= n <= 5842. Input is terminated by a value of zero (0) for n.
 

Output
For each test case, print one line saying "The nth humble number is number.". Depending on the value of n, the correct suffix "st", "nd", "rd", or "th" for the ordinal number nth has to be used like it is shown in the sample output.
 

Sample Input
1
2
3
4
11
12
13
21
22
23
100
1000
5842
0
 

Sample Output
The 1st humble number is 1.
The 2nd humble number is 2.
The 3rd humble number is 3.
The 4th humble number is 4.
The 11th humble number is 12.
The 12th humble number is 14.
The 13th humble number is 15.
The 21st humble number is 28.
The 22nd humble number is 30.
The 23rd humble number is 32.
The 100th humble number is 450.
The 1000th humble number is 385875.
The 5842nd humble number is 2000000000.
*/


package hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ABC on 2016/5/26 0026.
 */
public class hdu_1058_Humble_Numbers {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = new ArrayList<>();
        int max = 0;
        while(true){
            int tmp = scanner.nextInt();
            if(tmp  == 0) break;
            else input.add(tmp);
            if(max < tmp) max = tmp;
        }

        long [] data = new long [max+1];
        data[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0,i7 = 0;

        for(int i = 1;i < max;i++){
            data[i] = getMin(data,i2,i3,i5,i7);

            if(data[i2]*2 == data[i]) i2++;
            if(data[i3]*3 == data[i]) i3++;
            if(data[i5]*5 == data[i]) i5++;
            if(data[i7]*7 == data[i]) i7++;

        }

        for(int i = 0;i < input.size();i++){
            System.out.println("The " + input.get(i) + getLast(input.get(i))+" humble number is " + data[(int)input.get(i)-1] + ".");
        }

    }

    public static long getMin(long []data, int i2, int i3, int i5,int i7){
        long min = data[i2]*2;
        if(min > data[i3]*3) min = data[i3]*3;
        if(min > data[i5]*5) min = data[i5]*5;
        if(min > data[i7]*7) min = data[i7]*7;
        return min;
    }

    public static String getLast(int num){
        if(num%100 == 11 || num%100 == 12 || num%100 == 13) return "th";
        if(num % 10 == 1) return "st";
        else if(num % 10 == 2) return "nd";
        else if(num % 10 == 3) return "rd";
        else return "th";
    }
}


