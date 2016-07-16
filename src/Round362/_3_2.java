package Round362;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/16.
 */
public class _3_2 {

    static Map<Long,Long> map = new HashMap<>();
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int q = scanner.nextInt();
            for(int i = 0;i < q;i++){
                int s = scanner.nextInt();
                if(s == 1){
                    long u = scanner.nextLong();long v = scanner.nextLong(); long w = scanner.nextLong();
                    add(u, v, w);
                }
                else{
                    long u = scanner.nextLong();long v = scanner.nextLong();
                    System.out.println(get(u,v));
                }
            }
        }
    }

    public static void add(long u ,long v ,long w){
        while(u != v){
            if(u > v){
                addToMap(u,w);
                u = u >> 1;
            }
            else{
                addToMap(v,w);
                v = v >> 1;
            }
        }
    }

    public static long get(long u, long v){
        long reslut = 0;
        while(u != v){
            if(u > v){
                reslut += getFromMap(u);
                u = u >> 1;
            }
            else{
                reslut += getFromMap(v);
                v = v >> 1;
            }
        }
        return reslut;
    }

    public static void addToMap(long u , long w){
        if(!map.containsKey(u)) map.put(u,0L);
        long value = map.get(u) + w;
        map.put(u,value);

    }

    public static long getFromMap(long u){
        if(!map.containsKey(u)) return 0L;
        else return map.get(u);
    }
}
