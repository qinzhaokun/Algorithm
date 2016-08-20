package Educational15;

import java.util.*;

/**
 * Created by zqin on 2016/7/29.
 */
public class Powers_of_Two {

    public static void main(String [] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1000000000+1000000000);
        Scanner scanner = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        for(long i = 1;i < Long.MAX_VALUE && i > 0;i*=2){
            list.add(i);
        }
        long [] a = new long[100005];
        while(scanner.hasNext()){
            map.clear();
            int n = scanner.nextInt();
            long count = 0;
            for(int i = 0;i < n;i++) {
                a[i] = scanner.nextLong();
                if(map.containsKey(a[i])){
                    int value = map.get(a[i]);
                    map.put(a[i],value+1);
                }
                else {
                    map.put(a[i],1);
                }
//                for(int j = i-1;j >= 0;j--){
//                    long tmp = (a[i]+a[j]);
//                    if((tmp&(tmp-1)) == 0) count++;
//                }
            }
//            long mm = 0;
//            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
//                long t = entry.getKey();
//                int g = entry.getValue();
//                for(int i = 0;i < list.size();i++){
//                    long less = list.get(i)-t;
//                    if(map.containsKey(less)){
//                        if(less == t){
//                            mm += (g*(g-1));
//                        }
//                       else  mm +=(g*map.get(less));
//                    }
//                }
//
//            }
            Arrays.sort(a,0,n);
            for(int i = 0;i < n-1;i++){
                for(int j = 0;j < list.size();j++){
                    long t = list.get(j)-a[i];
                    if(t < 0) continue;
                    if(t > a[n-1]) break;
                    int r = findRight(a,i+1,n-1,t);
                    if(a[r] != t) continue;
                    int rr = findLeft(a,i+1,n-1,t);
                    count += (r-rr+1);
                }

            }
            System.out.println(count);
        }
    }

    public static int findRight(long [] a, int i, int j, long t){
        while(i < j){
            int mid = i+(j-i)/2+1;
            if(a[mid] == t) i = mid;
            else if(a[mid] > t) j = mid-1;
            else i = mid+1;
        }
        return i;
    }

    public static int findLeft(long [] a, int i, int j, long t){
        while(i < j){
            int mid = i+(j-i)/2;
            if(a[mid] == t) j = mid;
            else if(a[mid] > t) j = mid-1;
            else i = mid+1;
        }
        return i;
    }
}
