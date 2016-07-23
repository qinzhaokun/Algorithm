package Round364;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zqin on 2016/7/23.
 */
public class _2 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Set<Long> set = new HashSet<>();
        boolean [] row = new boolean[100005];
        boolean [] col = new boolean[100005];
        while(scanner.hasNext()){
            long n = scanner.nextLong();long m= scanner.nextLong();
            set.clear();
            Arrays.fill(row,false);
            Arrays.fill(col,false);
            long sum = n*n;
            int numCol = 0;
            int numRow = 0;
            for(int i = 0;i < m;i++){
               // long u = scanner.nextLong()-1;long v = scanner.nextLong()-1;
                int u = scanner.nextInt()-1;int v = scanner.nextInt()-1;
                if(!col[v]){
                    sum -= (n-numRow);
                    col[v] = true;
                    numCol++;
                }
                if(!row[u]){
                    sum -= (n-numCol);
                    row[u] = true;
                    numRow++;
                }

//                for(long k = 0;k < n;k++){
//                    if(!set.contains(n*k+v)){
//                        sum--;
//                        set.add(n*k+v);
//                    }
//                }
//                for(long k = 0;k < n;k++){
//                    if(k != v && !set.contains(n*u+k)){
//                        sum--;
//                        set.add(n*u+k);
//                    }
//                }
                System.out.println(sum);
            }
        }
    }
}
