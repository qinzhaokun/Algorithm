package apac2016D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KUN on 2016/8/27.
 */

class Node{
    int [] ip;
    int l;

    public Node(){
        ip = new int[32];
    }
}
public class IPAddressSummarization {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int index = 1;
        List<Node> net = new ArrayList<>();
        while(index <= T){
            Node root = new Node();
            net.clear();
            int n = scanner.nextInt(); scanner.nextLine();
            for(int i = 0;i < n;i++){
                String line = scanner.nextLine();
                String [] arr = line.split("/");
                int l = Integer.valueOf(arr[1]);
                int [] ip = strToArr(arr[0]);

                //for(int j = )

            }
            refactor(root);
            System.out.println("Case #" + index + " :");

            index++;
        }
    }

    public static void refactor(Node node){
        if(node.flag){
            if(node.ch[0] != null){
                node.ch[0].p = null;
                node.ch[0] = null;
            }
            if(node.ch[1] != null){
                node.ch[1].p = null;
                node.ch[1] = null;
            }


        }
        if(node.ch[0] != null){
            refactor(node.ch[0]);
        }
        if(node.ch[1] != null){
            refactor(node.ch[1]);
        }
    }

    public static int [] strToArr(String a){
        String [] aa = a.split("\\.");
        int [] ret = new int [32];
        for(int i = 0;i < 4;i++){
            int t = Integer.valueOf(aa[i]);
            for(int j = 7;j >= 0;j--){
                ret[8*i+j] = t%2;
                t /= 2;
            }
        }
        return ret;
    }

    public static void print(String t, int l){
        int i = 0;int num = 0;
        for(i= 0;i < 8 && i < l;i++){
            if(t.charAt(i) == '1'){
                num += Math.pow(2,(7-i));
            }
        }
        System.out.print(num+".");num = 0;
        for(i = 8;i < 16 && i < l;i++){
            if(t.charAt(i) == '1'){
                num += Math.pow(2,(16-i));
            }
        }
        System.out.print(num+".");num = 0;
        for(i = 16;i < 24 && i < l;i++){
            if(t.charAt(i) == '1'){
                num += Math.pow(2,(24-i));
            }
        }
        System.out.print(num+".");num = 0;
        for(i = 24;i < 31 && i < l;i++){
            if(t.charAt(i) == '1'){
                num += Math.pow(2,(31-i));
            }
        }
        System.out.print(num);
        System.out.println("/" + l);
    }


}
