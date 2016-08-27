package educational16;

import java.util.*;

/**
 * Created by zqin on 2016/8/22.
 */
public class B_OptimalPointonaLine {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        List<Integer> a = new ArrayList<>();
       // Map<Integer,Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            a.clear();//map.clear();
            int n = scanner.nextInt();
            for(int i = 0;i < n;i++) {
                int tmp = scanner.nextInt();
                a.add(tmp);
               // map.put(tmp,i);

            }

            Collections.sort(a);
            if((n&1) == 1){
                System.out.println(a.get(n/2));
            }
            else{
                System.out.println(a.get(n/2-1));
            }
        }


    }

//    public static int find(int i, int j,int k,List<Integer> a){
//        int mid = i+(j-i)/2;
//
//        int num = 0;
//        for(int s = i;s <=j;s++){
//            if(a.get(s) < a.get(mid)) num++;
//
//        }
//        if(num == k-1) return a.get(mid);
//        else if()
//    }
}
