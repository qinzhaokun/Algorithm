/*
A school bought the first computer some time ago(so this computer's id is 1). During the recent years the school bought N-1 new computers. Each new computer was connected to one of settled earlier. Managers of school are anxious about slow functioning of the net and want to know the maximum distance Si for which i-th computer needs to send signal (i.e. length of cable to the most distant computer). You need to provide this information. 



Hint: the example input is corresponding to this graph. And from the graph, you can see that the computer 4 is farthest one from 1, so S1 = 3. Computer 4 and 5 are the farthest ones from 2, so S2 = 2. Computer 5 is the farthest one from 3, so S3 = 3. we also get S4 = 4, S5 = 4.
*/

package dp;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/26 0026.
 */
public class dp_hdu_2196_Computer {
    public static List<ArrayList<Pair<Integer,Integer>>> graph = new ArrayList<>();
    public static int [] first = new int [10005];
    public static int [] second = new int[10005];
    public static int [] thrid = new int[10005];
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < 10005;i++){
            graph.add(new ArrayList<Pair<Integer,Integer>>());
        }
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            clear(n);
            for(int i = 0;i < n-1;i++){
                int a = scanner.nextInt()-1;
                int b = scanner.nextInt();
                graph.get(a).add(new Pair<Integer,Integer>(i+1,b));
                graph.get(i+1).add(new Pair<Integer,Integer>(a,b));
            }
            dfs(0,-1);
            treeDP(0,-1);
            for(int i = 0;i < n;i++){
                System.out.println(Math.max(first[i],thrid[i]));
            }
        }
    }

    public static void dfs(int u,int p){
        int max = 0;
        int sec = 0;
        List<Pair<Integer,Integer>> now = graph.get(u);
        for(int i = 0;i < now.size();i++){
            int j = now.get(i).getKey();
            int value = now.get(i).getValue();
            if(j != p) {
                dfs(j,u);
                if(max < first[j] + value) {sec = max;max = first[j]+value;}
                else if(first[j] +value > sec) sec = first[j] + value;
            }

        }
        first[u] = max;
        second[u] = sec;
    }

    public static void treeDP(int u,int p){
        List<Pair<Integer,Integer>> sons = graph.get(u);
        for(int i = 0;i < sons.size();i++){
            int j = sons.get(i).getKey();
            if(j == p) continue;
            int value = sons.get(i).getValue();
            thrid[j] = thrid[u] +value;
            if(first[j] + value == first[u]){
                thrid[j] = Math.max(thrid[j],value+second[u]);
            }
            else{
                thrid[j] = Math.max(thrid[j],value+first[u]);
            }
            treeDP(j,u);
        }
    }

    public static void clear(int n){
        for(int i = 0;i < n;i++){
            graph.get(i).clear();
        }
        Arrays.fill(first,0);
        Arrays.fill(second,0);
        Arrays.fill(thrid,0);
    }
}
