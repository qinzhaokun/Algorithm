/*
Description

There is going to be a party to celebrate the 80-th Anniversary of the Ural State University. The University has a hierarchical structure of employees. It means that the supervisor relation forms a tree rooted at the rector V. E. Tretyakov. In order to make the party funny for every one, the rector does not want both an employee and his or her immediate supervisor to be present. The personnel office has evaluated conviviality of each employee, so everyone has some number (rating) attached to him or her. Your task is to make a list of guests with the maximal possible sum of guests' conviviality ratings.
Input

Employees are numbered from 1 to N. A first line of input contains a number N. 1 <= N <= 6 000. Each of the subsequent N lines contains the conviviality rating of the corresponding employee. Conviviality rating is an integer number in a range from -128 to 127. After that go N – 1 lines that describe a supervisor relation tree. Each line of the tree specification has the form: 
L K 
It means that the K-th employee is an immediate supervisor of the L-th employee. Input is ended with the line 
0 0 
Output

Output should contain the maximal sum of guests' ratings.
Sample Input

7
1
1
1
1
1
1
1
1 3
2 3
6 4
7 4
4 5
3 5
0 0
Sample Output

5
*/

package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/10 0010.
 */
public class dp_tree_poj_2342_Anniversary_party {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] arr = new int[n];
        boolean [] degree = new boolean [n];
        for(int i = 0;i < n;i++) arr[i] = scanner.nextInt();

        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < n;i++) graph.add(new ArrayList<Integer>());

        while(true){
            int a = scanner.nextInt(); int b = scanner.nextInt();
            if(a == 0 || b == 0) break;
            graph.get(b-1).add(a-1);
            degree[a-1] = true;
        }

        int [][] dp = new int[n][2];

        int sum = 0;
        for(int i = 0;i < n;i++){
            if(!degree[i]) {
                afterOrder(graph,dp,i,arr);
                sum += ((dp[i][0] > dp[i][1]) ? dp[i][0] : dp[i][1]);
            }
        }

        System.out.println(sum);
    }

    static void afterOrder(List<ArrayList<Integer>> graph,int [][] dp,int index,int [] arr){
            for(int i = 0;i < graph.get(index).size();i++){
                int em = (int)graph.get(index).get(i);
                afterOrder(graph,dp,em,arr);
                dp[index][0] += Math.max(dp[em][1],dp[em][0]);
                dp[index][1] += dp[em][0];
            }
        dp[index][1] += arr[index];
    }
}
