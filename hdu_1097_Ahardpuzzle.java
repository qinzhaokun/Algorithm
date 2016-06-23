/*
lcy gives a hard puzzle to feng5166,lwg,JGShining and Ignatius: gave a and b,how to know the a^b.everybody objects to this BT problem,so lcy makes the problem easier than begin.
this puzzle describes that: gave a and b,how to know the a^b's the last digit number.But everybody is too lazy to slove this problem,so they remit to you who is wise.
 

Input
There are mutiple test cases. Each test cases consists of two numbers a and b(0<a,b<=2^30)
 

Output
For each test case, you should output the a^b's last digit number.
 

Sample Input
7 66
8 800
 

Sample Output
9
6
*/


package hdu;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/24 0024.
 */
public class hdu_1097_Ahardpuzzle {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();int b = scanner.nextInt();
            System.out.println(cal(a,b));
        }
    }

    public static int cal(int a, int b){
        if(b == 0) return 1;
        if(b == 1) return a%10;
        int one = cal(a,b/2);
        if(b % 2 == 0){
            return (one*one)%10;
        }
        else{
            return (one*one*a)%10;
        }
    }
}
