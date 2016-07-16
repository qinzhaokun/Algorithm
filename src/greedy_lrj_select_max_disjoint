import java.util.Scanner;

/**
 * Created by vincentqin on 2016/5/30.
 */

class qujian{
    public int a;
    public int b;
}
public class greedy_lrj_select_max_disjoint {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        qujian [] q = new qujian[n];
        for(int i = 0;i < n;i++) { q[i].a = scanner.nextInt(); q[i].b = scanner.nextInt();}

        //the base idea is using greedy algorithm
        //firstly, sort by b field
        sort(q);

        int count = 0;
        int end = -1;
        for(int i = 0;i < n;i++){
            if(q[i].a >= end){
                end = q[i].b;
                System.out.print("[" + q[i].a+","+q[i].b+"]" + " ");
                count++;
            }
        }

    }

    public static void sort(qujian [] q){
        int n = q.length;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(q[j].b < q[i].b){
                    int tmpA = q[i].a;
                    int tmpB = q[i].b;
                    q[i].a = q[j].a;
                    q[i].b = q[j].b;
                    q[j].a = tmpA;
                    q[j].b = tmpB;
                }
            }
        }
    }
}
