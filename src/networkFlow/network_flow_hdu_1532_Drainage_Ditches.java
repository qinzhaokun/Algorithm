/*
Problem Description
Every time it rains on Farmer John's fields, a pond forms over Bessie's favorite clover patch. This means that the clover is covered by water for awhile and takes quite a long time to regrow. Thus, Farmer John has built a set of drainage ditches so that Bessie's clover patch is never covered in water. Instead, the water is drained to a nearby stream. Being an ace engineer, Farmer John has also installed regulators at the beginning of each ditch, so he can control at what rate water flows into that ditch. 
Farmer John knows not only how many gallons of water each ditch can transport per minute but also the exact layout of the ditches, which feed out of the pond and into each other and stream in a potentially complex network. 
Given all this information, determine the maximum rate at which water can be transported out of the pond and into the stream. For any given ditch, water flows in only one direction, but there might be a way that water can flow in a circle. 
 

Input
The input includes several cases. For each case, the first line contains two space-separated integers, N (0 <= N <= 200) and M (2 <= M <= 200). N is the number of ditches that Farmer John has dug. M is the number of intersections points for those ditches. Intersection 1 is the pond. Intersection point M is the stream. Each of the following N lines contains three integers, Si, Ei, and Ci. Si and Ei (1 <= Si, Ei <= M) designate the intersections between which this ditch flows. Water will flow through this ditch from Si to Ei. Ci (0 <= Ci <= 10,000,000) is the maximum rate at which water will flow through the ditch.
 

Output
For each case, output a single integer, the maximum rate at which water may emptied from the pond. 
 

Sample Input
5 4
1 2 40
1 4 20
2 4 20
2 3 30
3 4 10
 

Sample Output
50
*/


package networkFlow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/21 0021.
 */
public class hdu_1532_Drainage_Ditches {

    static int [][] flow = new int[205][205];
    static int [][] cap = new int [205][205];
    static int [] p = new int [205];
    static int [] d = new int[205];
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n = scanner.nextInt();int m = scanner.nextInt();
            clear();
            for(int i = 0;i < n;i++){
                int a = scanner.nextInt();int b = scanner.nextInt();
                cap[a-1][b-1] += scanner.nextInt(); //考虑重复的边，被坑惨了
            }

            int maxFlow = 0;
            while(true){
                int min = findPath(m);
                if(min == 0) break;
                for(int i = m-1;i != 0;i=p[i]){
                    flow[p[i]][i] += min;
                    flow[i][p[i]] -= min;
                }
                maxFlow += min;
            }

            System.out.println(maxFlow);
        }
    }

    public static int findPath(int m){
        Arrays.fill(d,0);
        d[0] = Integer.MAX_VALUE/2-1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v = 0;v <m;v++){
                if(d[v] == 0 && v != u && cap[u][v] > flow[u][v]){
                    d[v] = d[u];
                    p[v] = u;
                    if(cap[u][v] - flow[u][v] < d[v]) d[v] = cap[u][v] - flow[u][v];
                    q.add(v);
                }
            }
        }
        int min = d[0];
        for(int i = 1;i < m;i++) min = Math.min(min,d[i]);
        return min;
    }


    public static void clear(){
        for(int i = 0;i < 205;i++){
            p[i] = i;
            for(int j = 0;j < 205;j++){
                cap[i][j] = 0;
                flow[i][j] = 0;
            }
        }
    }
}
