package Round367;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/12.
 */
public class D_Vasiliys_Multiset {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        Map<Integer,Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            map.clear();
            int q = scanner.nextInt();scanner.nextLine();

            for(int i = 0;i < q;i++){
                String line = scanner.nextLine();
                String [] a = line.split(" ");
                int t = Integer.parseInt(a[1]);
                if(a[0].charAt(0) == '+'){
                    if(map.containsKey(t)){
                        int value = map.get(t);
                        map.put(t,value+1);
                    }
                    else{
                        map.put(t,1);
                    }
                }
                else if(a[0].charAt(0) == '-'){
                    int value = map.get(t);
                    if(value == 1){
                        map.remove(t);
                    }
                    else{
                        map.put(t,value-1);
                    }
                }
                else{
                    int max = 0;
                    for (Integer key : map.keySet()) {

                        int g = key ^ t;
                        if(max == 0 || max < g) max = g;


                    }
                    System.out.println(max);
                }
            }
        }
    }
}
