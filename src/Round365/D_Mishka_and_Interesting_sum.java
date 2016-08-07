package Round365;

import java.util.Scanner;

/**
 * Created by zqin on 2016/8/5.
 */

class Node{
    public int l;
    public int r;
    public int v;
    Node left;
    Node right;
}
public class D_Mishka_and_Interesting_sum {

    static int [] a = new int[1000005];
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n = scanner.nextInt();
            for(int i = 0;i < n;i++) a[i] = scanner.nextInt();

            Node root = buildTree(0,n-1);
            int m = scanner.nextInt();
            for(int i = 0;i < m;i++){
                int l = scanner.nextInt()-1; int r = scanner.nextInt()-1;
                Node tmp = root;
                System.out.println(find(tmp,l,r));
            }
        }
    }

    public static int find(Node tmp,int l ,int r){
        if(tmp == null) return 0;
        if(tmp.l == l && tmp.r == r) return tmp.v;
        else{
            int mid = tmp.l + (tmp.r-tmp.l)/2;
            if(r <= mid){
                return find(tmp.left,l,r);
            }
            else if(l >= mid+1){
                return find(tmp.right,l,r);
            }
            else{
                return (find(tmp.left,l,mid) ^ find(tmp.right,mid+1,r));
            }
        }
    }

    public static Node buildTree(int l ,int r){
        if(l > r) return null;
        if(l == r){
            Node node = new Node();
            node.l = l;node.r = r;node.v = a[l];
            return node;
        }

        int mid = l + (r-l)/2;
        Node node = new Node();node.l=l;node.r=r;
        Node left = buildTree(l,mid);
        Node right = buildTree(mid+1,r);
        node.left = left;
        node.right = right;
        int v = 0;
        if(left != null) v = v ^ left.v;
        if(right != null) v = v ^ right.v;
        node.v = v;
        return node;
    }


}
