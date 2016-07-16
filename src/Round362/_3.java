package Round362;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/15.
 */
public class _3 {
    static int [][] a = new int[100005][2];
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int q = scanner.nextInt();
            for(int i = 0;i < 100005;i++){
                a[i][0] = a[i][1] = 0;
            }
            for(int i = 0;i < q;i++){
                int flag = scanner.nextInt();
                if(flag == 1){
                    add(scanner);
                }
                else{
                    get(scanner);
                }
            }
        }
    }

    public static void add(Scanner scanner){
        int u = scanner.nextInt();int v = scanner.nextInt();int w = scanner.nextInt();
        List<Integer> uPath = new ArrayList<>();
        int u_tmp = u;
        while(u_tmp != 0){
            uPath.add(0,u_tmp); u_tmp /= 2;
        }
        List<Integer> vPath = new ArrayList<>();
        int v_tmp = v;
        while (v_tmp != 0){
            vPath.add(0,v_tmp);
            v_tmp /= 2;
        }
        int i = 0;
        while(i < vPath.size() && i < uPath.size() && vPath.get(i) == uPath.get(i)) i++;

        if(i < vPath.size()){
            int t = 0;
            if(vPath.get(i-1) == 1) t = vPath.get(i)%2;
            else t = vPath.get(i)%vPath.get(i-1);
            a[vPath.get(i-1)][t] += w;
            int j = i;
            while(j+1 < vPath.size()){
                t = 0;
                if(vPath.get(j) == 1) t = vPath.get(j+1)%2;
                else t = vPath.get(j+1)%vPath.get(j);
                a[vPath.get(j)][t] += w;
                j++;
            }
        }

        if(i < uPath.size()){
            int t = 0;
            if(uPath.get(i-1) == 1) t = uPath.get(i)%2;
            else t = uPath.get(i)%uPath.get(i-1);
            a[uPath.get(i-1)][t] += w;
            int j = i;
            while(j+1 < uPath.size()){
                t = 0;
                if(uPath.get(j) == 1) t = uPath.get(j+1)%2;
                else t = uPath.get(j+1)%uPath.get(j);
                a[uPath.get(j)][t] += w;
                j++;
            }
        }
    }

    public static void get(Scanner scanner){
        int u = scanner.nextInt();int v = scanner.nextInt();
        List<Integer> uPath = new ArrayList<>();
        int u_tmp = u;
        while(u_tmp != 0){
            uPath.add(0,u_tmp); u_tmp /= 2;
        }
        List<Integer> vPath = new ArrayList<>();
        int v_tmp = v;
        while (v_tmp != 0){
            vPath.add(0,v_tmp);
            v_tmp /= 2;
        }

        int i = 0;
        while(i < vPath.size() && i < uPath.size() && vPath.get(i) == uPath.get(i)) i++;
        int sum = 0;
        if(i < vPath.size()){
            int t = 0;
            if(vPath.get(i-1) == 1) t = vPath.get(i)%2;
            else t = vPath.get(i)%vPath.get(i-1);
            sum += a[vPath.get(i-1)][t];
            int j = i;
            while(j+1 < vPath.size()){
                t = 0;
                if(vPath.get(j) == 1) t = vPath.get(j+1)%2;
                else t = vPath.get(j+1)%vPath.get(j);
                sum += a[vPath.get(j)][t];
                j++;
            }
        }

        if(i < uPath.size()){
            int t = 0;
            if(uPath.get(i-1) == 1) t = uPath.get(i)%2;
            else t = uPath.get(i)%uPath.get(i-1);
            sum += a[uPath.get(i-1)][t];
            int j = i;
            while(j+1 < uPath.size()){
                t = 0;
                if(uPath.get(j) == 1) t = uPath.get(j+1)%2;
                else t = uPath.get(j+1)%uPath.get(j);
                sum += a[uPath.get(j)][uPath.get(j+1)%uPath.get(j)];
                j++;
            }
        }

        System.out.println(sum);
    }
}
