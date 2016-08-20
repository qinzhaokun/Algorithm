package Round364;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by zqin on 2016/7/23.
 */
public class _1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        List<Pair<Integer,Integer>> r = new ArrayList();
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            r.clear();
            for(int i = 0;i < n;i++){
                int tmp = scanner.nextInt();
                Pair<Integer,Integer> p = new Pair<>(i+1,tmp);
                r.add(p);
            }
            Collections.sort(r, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getValue()-o2.getValue();
                }
            });
            for(int i = 0;i < n/2;i++){
                System.out.println(r.get(i).getKey() + " " + r.get(n-1-i).getKey());
            }

        }
    }
}
