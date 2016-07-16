/*
Berland has n cities connected by m bidirectional roads. No road connects a city to itself, and each pair of cities is connected by no more than one road. It is not guaranteed that you can get from any city to any other one, using only the existing roads.

The President of Berland decided to make changes to the road system and instructed the Ministry of Transport to make this reform. Now, each road should be unidirectional (only lead from one city to another).

In order not to cause great resentment among residents, the reform needs to be conducted so that there can be as few separate cities as possible. A city is considered separate, if no road leads into it, while it is allowed to have roads leading from this city.

Help the Ministry of Transport to find the minimum possible number of separate cities after the reform.

Input
The first line of the input contains two positive integers, n and m — the number of the cities and the number of roads in Berland (2 ≤ n ≤ 100 000, 1 ≤ m ≤ 100 000).

Next m lines contain the descriptions of the roads: the i-th road is determined by two distinct integers xi, yi (1 ≤ xi, yi ≤ n, xi ≠ yi), where xi and yi are the numbers of the cities connected by the i-th road.

It is guaranteed that there is no more than one road between each pair of cities, but it is not guaranteed that from any city you can get to any other one, using only roads.

Output
Print a single integer — the minimum number of separated cities after the reform.

Examples
input
4 3
2 1
1 3
4 3
output
1
input
5 5
2 1
1 3
2 3
2 5
4 3
output
0
input
6 5
1 2
2 3
4 5
4 6
5 6
output
1
*/

package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/20 0020.
 */
public class dfs_codeforce_659E_New_Reform {

    static boolean isCircle;
    static boolean [] isV = new boolean[100005];
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0;i < 100005;i++) graph.add(new ArrayList<Integer>());

        while(scanner.hasNext()){
            int n = scanner.nextInt();int m = scanner.nextInt();
            for(int i =0;i < n;i++) {graph.get(i).clear();isV[i] = false;}

            for(int i = 0;i < m;i++){
                int u = scanner.nextInt();int v = scanner.nextInt();
                graph.get(u-1).add(v-1);
                graph.get(v-1).add(u-1);
            }

            int sum = 0;
            for(int i =0;i < n;i++){
                if(!isV[i]){
                    isCircle = false;
                    dfs(i,i);
                    sum += (isCircle ? 0:1);
                }
            }
            System.out.println(sum);
        }

    }

    public static void dfs(int now, int pre){
        if(isV[now]) {isCircle = true;return;}
        isV[now] = true;
        List<Integer> children = graph.get(now);
        for(int i =0;i < children.size();i++){
            int child = children.get(i);
            if(child != pre){
                dfs(child,now);
            }
        }
    }
}
