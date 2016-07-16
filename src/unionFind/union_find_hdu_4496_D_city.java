/*
Problem Description
Luxer is a really bad guy. He destroys everything he met. 
One day Luxer went to D-city. D-city has N D-points and M D-lines. Each D-line connects exactly two D-points. Luxer will destroy all the D-lines. The mayor of D-city wants to know how many connected blocks of D-city left after Luxer destroying the first K D-lines in the input. 
Two points are in the same connected blocks if and only if they connect to each other directly or indirectly.
 

Input
First line of the input contains two integers N and M. 
Then following M lines each containing 2 space-separated integers u and v, which denotes an D-line. 
Constraints: 
0 < N <= 10000 
0 < M <= 100000 
0 <= u, v < N. 
 

Output
Output M lines, the ith line is the answer after deleting the first i edges in the input.
 

Sample Input
5 10 
0 1 
1 2 
1 3 
1 4 
0 2 
2 3 
0 4 
0 3 
3 4 
2 4
 

Sample Output
1 
1 
1 
2 
2 
2 
2 
3 
4 
5
Hint

The graph given in sample input is a complete graph, that each pair of vertex has an edge connecting them, so there's only 1 connected block at first. 
The first 3 lines of output are 1s  because  after  deleting  the  first  3  edges  of  the  graph,  all  vertexes  still  connected together. 
But after deleting the first 4 edges of the graph, vertex 1 will be disconnected with other vertex, and it became an independent connected block. 
Continue deleting edges the disconnected blocks increased and finally it will became the number of vertex, so the last output should always be N. 
*/


package unionFind;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/4 0004.
 */
public class union_find_hdu_4496_D_city {

    static int [] parent = new int[10005];

    public static void main(String [] args) {


        Scanner scanner = new Scanner(System.in);

        int m,n;
        int [][] arr = new int[100005][2];


        int[] ret = new int[100005];

        while (scanner.hasNext()) {


            n = scanner.nextInt();
            m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }


        for (int i = 0; i < n; i++) parent[i] = i;

        int count = n;


        for (int i = m - 1; i >= 0; i--) {
            ret[i] = count;
            int pi = find(arr[i][0]);
            int pj = find(arr[i][1]);
            if(pi != pj) {parent[pi] = pj;count--;}
        }

        for (int i = 0; i < m; i++) {
            System.out.println(ret[i]);
        }
    }
    }

    public static int find(int i){
        if(parent[i] == i) return i;
        else {parent[i] = find(parent[i]);return parent[i];}
    }

}
