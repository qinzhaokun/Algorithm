/*
“Given some Chinese Coins (硬币) (three kinds-- 1, 2, 5), and their number is num_1, num_2 and num_5 respectively, please output the minimum value that you cannot pay with given coins.”
You, super ACMer, should solve the problem easily, and don’t forget to take $25000000 from Bush!
 

Input
Input contains multiple test cases. Each test case contains 3 positive integers num_1, num_2 and num_5 (0<=num_i<=1000). A test case containing 0 0 0 terminates the input and this test case is not to be processed.
 

Output
Output the minimum positive value that one cannot pay with given coins, one line for one case.
 

Sample Input
1 1 3
0 0 0
 

Sample Output
4
 

*/

package mother_function;

import java.util.Scanner;

/**
 * Created by ABC on 2016/5/28 0028.
 */
public class mother_function_hdu_1085_Holding_Bin-Laden_Captive {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] val = {1,2,5};
        int [] num = new int [3];
        while(true){
            num[0] = scanner.nextInt();
            num[1] = scanner.nextInt();
            num[2] = scanner.nextInt();
            if(num[0] == 0 && num[1] == 0 && num[2] == 0) break;

            int max = num[0]*1 + num[1]*2 + num[2]*5;
            int [] arr = new int [max+2];
            int [] arr1 = new int [max+2];

            for(int i = 0;i <= num[0]*val[0];i+=val[0]) arr[i] = 1;

            for(int i = 1;i < 3;i++){
                for(int k = 0;k <= max;k++){
                    for(int j = 0;j <= num[i]*val[i] && k+j <= max;j+=val[i]){
                        arr1[k+j] += arr[k];
                    }
                }

                for(int k = 0;k <= max;k++) {arr[k] = arr1[k];arr1[k] = 0;}
            }

            for(int i = 1;i <= max+1;i++){
                if(arr[i] == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
