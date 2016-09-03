package roundB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/28.
 */
public class _3 {

    static int N, L1, R1, A, B, C1, C2, M;
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < 1000000000;i++);
        System.out.println("ff");
        int T = scanner.nextInt();
        int index = 1;
        while(index <= T){

            N= scanner.nextInt();
            L1= scanner.nextInt();
            R1= scanner.nextInt();
            A= scanner.nextInt();
            B= scanner.nextInt();
            C1= scanner.nextInt();
            C2= scanner.nextInt();
            M= scanner.nextInt();
            int [][] aa = new int[N+1][2];
            int x = L1; int y = R1;
            int ml = x;int mr = y;
            Map<Integer,Integer> map = new HashMap<>();
            aa[0][0] = L1;aa[0][1] = R1;
            for(int i = ml;i <= mr;i++){
                map.put(i,1);
            }
            for(int i = 1;i < N;i++){
                int [] r = dd(x,y);
                x = r[0];
                y = r[1];
                aa[i][0] = Math.min(x,y);
                aa[i][1] = Math.max(x,y);
                if(aa[i][0] < ml) ml = aa[i][0];
                if(aa[i][1] > mr) mr = aa[i][1];
                for(int j = aa[i][0];j <= aa[i][1];j++){
                    if(map.containsKey(j)){
                        int v = map.get(j);
                        map.put(j,v+1);
                    }
                    else{
                        map.put(j,1);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0;i < N;i++){
                int count = 0;
                for(int j = aa[i][0];j <= aa[i][1];j++){
                    if(map.get(j) == 1){
                        count++;
                    }
                }
                if(mr-ml+1-count < min) min = mr-ml+1-count;
            }

            System.out.println("Case #"+index+": "+min);
            index++;
        }
    }

    public static int [] dd(int x, int y){
        int [] e = new int [2];
        e[0] = (A*x+B*y+C1)%M;
        e[1] = (A*x+B*y+C2)%M;
        return e;
    }
}
