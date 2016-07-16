/*
Problem Description
An inch worm is at the bottom of a well n inches deep. It has enough energy to climb u inches every minute, but then has to rest a minute before climbing again. During the rest, it slips down d inches. The process of climbing and resting then repeats. How long before the worm climbs out of the well? We'll always count a portion of a minute as a whole minute and if the worm just reaches the top of the well at the end of its climbing, we'll assume the worm makes it out.
 

Input
There will be multiple problem instances. Each line will contain 3 positive integers n, u and d. These give the values mentioned in the paragraph above. Furthermore, you may assume d < u and n < 100. A value of n = 0 indicates end of output.
 

Output
Each input instance should generate a single integer on a line, indicating the number of minutes it takes for the worm to climb out of the well.
 

Sample Input
10 2 1
20 3 1
0 0 0
 

Sample Output
17
19
*/


package hdu;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/26 0026.
 */
public class hdu_1049_Climbing_Worm {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(true){
            int n = scanner.nextInt();
            int u = scanner.nextInt();
            int d = scanner.nextInt();
            if(n == 0) break;

            int time =  (int)(Math.ceil(((double)(n-u)/(u-d)))*2) + 1;

            System.out.println(time);
        }
    }

}
