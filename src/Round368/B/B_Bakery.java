package Round368.B;

import java.util.*;

/**
 * Created by zqin on 2016/8/20.
 */
public class B_Bakery {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,List<Integer>> map1 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        while(scanner.hasNext()){
            int n = scanner.nextInt();int m = scanner.nextInt();int k = scanner.nextInt();

            map.clear();map1.clear();set.clear();

            for(int i = 0;i < m;i++){
                int u = scanner.nextInt();int v = scanner.nextInt(); int c = scanner.nextInt();

                if(!map.containsKey(u)){
                    map.put(u,new ArrayList<Integer>());
                    map1.put(u,new ArrayList<Integer>());
                }

                List l1 = map.get(u);
                List l2 = map1.get(u);
                if(l1.contains(v)){
                    int index = l1.indexOf(v);
                    int cLast = (int)l2.get(index);
                    if(cLast > c){
                        l2.set(index,c);
                    }
                }
                else{
                    l1.add(v);l2.add(c);
                }
                map.put(u,l1);map1.put(u,l2);


                if(!map.containsKey(v)){
                    map.put(v,new ArrayList<Integer>());
                    map1.put(v,new ArrayList<Integer>());
                }

                l1 = map.get(v);
                l2 = map1.get(v);
                if(l1.contains(u)){
                    int index = l1.indexOf(u);
                    int cLast = (int)l2.get(index);
                    if(cLast > c){
                        l2.set(index,c);
                    }
                }
                else{
                    l1.add(u);l2.add(c);
                }
                map.put(v,l1);map1.put(v,l2);

            }
            int [] a = new int[k];
            for(int i = 0;i < k;i++){
                int y = scanner.nextInt();
                set.add(y);
                a[i] = y;
            }

            int min = -1;
            for(int i = 0;i < k;i++){
                int u = a[i];
                if(map.containsKey(u)){
                    List l1 = map.get(u);
                    List l2 = map1.get(u);
                    for(int j = 0;j < l1.size();j++){
                        if(!set.contains(l1.get(j))){
                            if(min == -1 || min > (int)l2.get(j)){
                                min = (int)l2.get(j);
                            }
                        }
                    }
                }
            }

            System.out.println(min);
        }
    }
}
