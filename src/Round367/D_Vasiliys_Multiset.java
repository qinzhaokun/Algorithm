package Round367;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zqin on 2016/8/12.
 */


public class D_Vasiliys_Multiset {

    class Node{
        Node left;
        Node right;
        int value;
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int q = scanner.nextInt();
            scanner.nextLine();
            D_Vasiliys_Multiset.Node root = new D_Vasiliys_Multiset().new Node();
            for(int i = 0;i < q;i++){
                String line = scanner.nextLine();
                String [] a = line.split(" ");
                if(a[0].charAt(0) == '+'){
                    int t = Integer.parseInt(a[1]);
                    Node tmp = root;
                    for(int j = 31;j >= 0;j--){
                        if(((t >> j) & 1) == 1){
                            if(tmp.right == null) tmp.right = new D_Vasiliys_Multiset().new Node();
                            tmp = tmp.right;
                            tmp.value++;
                        }
                        else{
                            if(tmp.left == null) tmp.left = new D_Vasiliys_Multiset().new Node();
                            tmp = tmp.left;
                            tmp.value++;
                        }
                    }
                }
                else if(a[0].charAt(0) == '-'){
                    int t = Integer.parseInt(a[1]);
                    Node tmp = root;
                    for(int j = 31;j >= 0;j--){
                        if(((t >> j) & 1) == 1){
                            tmp = tmp.right;
                            tmp.value--;
                        }
                        else{
                            tmp = tmp.left;
                            tmp.value--;
                        }
                    }
                }
                else{
                    int t = Integer.parseInt(a[1]);
                    Node tmp = root;
                    int re = 0;int j = 31;
                    for(;j >= 0;j--){
                        if(((t >> j) & 1) == 1){
                            if(tmp.left != null && tmp.left.value > 0){
                                tmp = tmp.left;
                                re += (1<<j);
                            }
                            else if(tmp.right != null && tmp.right.value > 0){
                                tmp = tmp.right;

                            }
                            else{
                                break;
                            }
                        }
                        else{
                            if(tmp.right != null && tmp.right.value > 0){
                                tmp = tmp.right;
                                re += (1<<j);
                            }
                            else if(tmp.left != null && tmp.left.value > 0){
                                tmp = tmp.left;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(j < 0){
                        System.out.println(re);
                    }
                    else{
                        System.out.println(-1);
                    }
                }
            }
        }
    }

//    public static void main(String [] args){
//        Scanner scanner = new Scanner(System.in);
//
//        Map<Integer,Integer> map = new HashMap<>();
//        while(scanner.hasNext()){
//            map.clear();
//            int q = scanner.nextInt();scanner.nextLine();
//
//            for(int i = 0;i < q;i++){
//                String line = scanner.nextLine();
//                String [] a = line.split(" ");
//                int t = Integer.parseInt(a[1]);
//                if(a[0].charAt(0) == '+'){
//                    if(map.containsKey(t)){
//                        int value = map.get(t);
//                        map.put(t,value+1);
//                    }
//                    else{
//                        map.put(t,1);
//                    }
//                }
//                else if(a[0].charAt(0) == '-'){
//                    int value = map.get(t);
//                    if(value == 1){
//                        map.remove(t);
//                    }
//                    else{
//                        map.put(t,value-1);
//                    }
//                }
//                else{
//                    int max = 0;
//                    for (Integer key : map.keySet()) {
//
//                        int g = key ^ t;
//                        if(max == 0 || max < g) max = g;
//
//
//                    }
//                    System.out.println(max);
//                }
//            }
//        }
//    }
}
