/*
Problem Description
Machines have once again attacked the kingdom of Xions. The kingdom of Xions has N cities and N-1 bidirectional roads. The road network is such that there is a
unique path between any pair of cities.

Morpheus has the news that K Machines are planning to destroy the whole kingdom. These Machines are initially living in K different cities of the kingdom and
anytime from now they can plan and launch an attack. So he has asked Neo to destroy some of the roads to disrupt the connection among Machines. i.e after destroying those roads there should not be any path between any two Machines.

Since the attack can be at any time from now, Neo has to do this task as fast as possible. Each road in the kingdom takes certain time to get destroyed and they
can be destroyed only one at a time. 

You need to write a program that tells Neo the minimum amount of time he will require to disrupt the connection among machines.
 

Input
The first line is an integer T represents there are T test cases. (0<T <=10)
For each test case the first line input contains two, space-separated integers, N and K. Cities are numbered 0 to N-1. Then follow N-1 lines, each containing three, space-separated integers, x y z, which means there is a bidirectional road connecting city x and city y, and to destroy this road it takes z units of time.Then follow K lines each containing an integer. The ith integer is the id of city in which ith Machine is currently located.
2 <= N <= 100,000
2 <= K <= N
1 <= time to destroy a road <= 1000,000
 

Output
For each test case print the minimum time required to disrupt the connection among Machines.
 

Sample Input
1
5 3
2 1 8
1 0 5
2 4 5
1 3 4
2
4
0
 

Sample Output
10
Hint

Neo can destroy the road connecting city 2 and city 4 of weight 5 , and the road connecting city 0 and city 1 of weight 5. As only one road can be destroyed at a
time, the total minimum time taken is 10 units of time. After destroying these roads none of the Machines can reach other Machine via any path.
*/

package unionFind;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/4 0004.
 */
public class union_find_hdu_4313_matrix {

    static int n,k;
    static int [][] roads = new int[100005][3];
    static int [] p = new int[100005];
    static boolean [] isM = new boolean[100005];

    public static void main(String [] args){

        Scanner scanner = new Scanner((System.in));




        int T = scanner.nextInt();
        while(T > 0){
            n = scanner.nextInt();k = scanner.nextInt();
            for(int i = 0;i < n-1;i++){
                roads[i][0] = scanner.nextInt();roads[i][1] = scanner.nextInt();roads[i][2] = scanner.nextInt();
            }
            for(int i = 0;i < n;i++) {isM[i] = false;p[i] = i;}
            for(int i = 0;i < k;i++){
                isM[scanner.nextInt()] = true;
            }

            sort();
            int sum = 0;
            for(int i = 0;i < n-1;i++){
                int pa = find(roads[i][0]);
                int pb = find(roads[i][1]);
                //由于是科树，所以肯定不会是同一个根
                if(isM[pa] && isM[pb]) sum += roads[i][2];
                else{
                    //union两个集合
                    p[pa] = pb;
                    if(isM[pa]) isM[pb] = true;
                }
            }

            System.out.println(sum);
            T--;
        }
    }

    static int find(int i){
        if(p[i] == i) return i;
        else{
            p[i] = find(p[i]);
            return p[i];
        }
    }

    static void sort(){
        for(int i = 0;i < n-1;i++){
            for(int j = i+1;j < n-1;j++){
                if(roads[i][2] < roads[j][2]){
                    exchange(i,j);
                }
            }
        }
    }

    static void exchange(int i, int j){
        int tmp = roads[i][0];
        roads[i][0] = roads[j][0];
        roads[j][0] = tmp;
        tmp = roads[i][1];
        roads[i][1] = roads[j][1];
        roads[j][1] = tmp;
        tmp = roads[i][2];
        roads[i][2] = roads[j][2];
        roads[j][2] = tmp;
    }
}
