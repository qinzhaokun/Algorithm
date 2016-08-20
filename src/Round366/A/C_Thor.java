package Round366.A;


import javafx.util.Pair;

import java.util.*;

/**
 * Created by zqin on 2016/8/7.
 */

public class C_Thor {
class Node{
    int id;
    boolean has;
}
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        List<Node> m = new ArrayList<>();
        List<List<Node>> list = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        while(scanner.hasNext()){
            m.clear();
            int sum = 0;
            int num = 0;
            int n = scanner.nextInt(); int q = scanner.nextInt();
            for(int i = 0;i < n+1;i++){
                list.add(new ArrayList<Node>());
                pos.add(0);
            }
            for(int i = 0;i < q;i++){
                int a = scanner.nextInt(); int b = scanner.nextInt();
                if(a == 1){
                    C_Thor.Node  node = new C_Thor().new Node();
                    node.has = true;node.id = i;
                    m.add(node);
                    list.get(b).add(node);
                    sum++;

                }
                else if(a == 2){
                    for(int j = pos.get(b);j < list.get(b).size();j++){
                        int index = list.get(b).get(j).id;
                        if(m.get(index).has){
                            m.get(index).has = false;
                            sum--;
                        }

                    }
                    pos.set(b,list.get(b).size());
                }
                else{
                    for(int j = num;j< b;j++){
                        if(m.get(j).has){
                            sum--;
                            m.get(j).has = false;
                        }
                    }
                }

                System.out.println(sum);
            }
        }

        }


    public static int binaryFind(List<Integer> list, int t){
        int i = 0;int j = list.size()-1;
        while(i < j){
            int mid = i + (j-i)/2 + 1;
            if(list.get(mid) > t){
                j = mid-1;
            }
            else{
                i = mid;
            }
        }
        return i;
    }

    void f(){
//        while(scanner.hasNext()){
//            int n = scanner.nextInt(); int q = scanner.nextInt();
//            map.clear();
//            int count = 0;
//            int ii = 1;
//            for(int i = 0;i < q;i++){
//                int type = scanner.nextInt();
//                if(type == 1){
//                    int app = scanner.nextInt();
//                    if(!map.containsKey(app)){
//                        List list = new ArrayList<Integer>();
//                        list.add(ii);
//                        ii++;
//                        map.put(app,list);
//                    }
//                    else{
//                        List<Integer> list = map.get(app);
//                        list.add(ii);
//                        ii++;
//                        map.put(app,list);
//                    }
//                    count++;
//
//
//                }
//                else if(type == 2){
//                    int app =scanner.nextInt();
//                    if(map.containsKey(app)){
//                        List list = map.get(app);
//                        count -= list.size();
//                        if(count < 0) count = 0;
//                        list.clear();
//                        map.put(app,list);
//                    }
//                }
//                else{
//                    int t = scanner.nextInt();
//
//                    for (Map.Entry<Integer,List> entry : map.entrySet()) {
//                        List<Integer> value = entry.getValue();
//                        if(value.size() > 0 && value.get(0) <= t){
//                            int j = 0;
//                            for(j = 0;j < value.size();j++){
//                                if(value.get(j) > t) break;
//                            }
//                            count -= j;
//                            if(count < 0) count = 0;
//                            int s = value.size();
//                            map.put(entry.getKey(),value.subList(j,s));
//                        }
//                    }
//
////                    for (List<Integer> value : map.values()) {
////                            if(value.size() > 0 && value.get(0) <= t){
//////                                int index = binaryFind(value,t);
//////                                count -= (index+1);
//////                                if(count < 0) count = 0;
//////                                List<Integer> w = new ArrayList<>();
//////                                for(int j = index+1;j < value.size();j++){
//////                                    w.add(value.get(j));
//////
//////                                }
//////                                value = w;
////                                int j = 0;
////                                for(j = 0;j < value.size();j++){
////                                    if(value.get(j) > t) break;
////                                }
////                                int s = value.size();
////                                value = value.subList(j,s);
////                            }
//                }
//                System.out.println(count);
//            }
//
//
//        }
    }
}
