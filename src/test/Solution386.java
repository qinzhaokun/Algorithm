package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zqin on 2016/8/27.
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            ret.add(i);
        }

        mergesort(ret,0,n-1);
        return ret;
    }

    void mergesort(List<Integer> ret, int i, int j){
        if(j - i < 1) return;
        int mid = i+(j-i)/2;

        mergesort(ret,i,mid);mergesort(ret,mid+1,j);
        merge(ret,i,mid,j);
    }

    void merge(List<Integer> ret, int i , int mid, int j){
        List<Integer> tmp = new ArrayList<>();
        int k = i;int t = mid+1;
        while(k <= mid && t <= j){
            int flag = compare(ret.get(k),ret.get(t));
            if(flag <= 0){
                tmp.add(ret.get(k));
                k++;
            }
            else{
                tmp.add(ret.get(t));
                t++;
            }
        }
        while(k <= mid){
            tmp.add(ret.get(k));
            k++;
        }
        while(t <= j){
            tmp.add(ret.get(t));
            t++;
        }
        for(k = i;k <= j;k++){
            ret.set(k,tmp.get(k-i));
        }
    }

    int compare(int i, int j){
        String a1 = String.valueOf(i);
        String a2 = String.valueOf(j);
        int k = 0;
        while(k < a1.length() && k < a2.length()){
            if(a1.charAt(k) < a2.charAt(k)) return -1;
            else if(a1.charAt(k) > a2.charAt(k)) return 1;
            k++;
        }
        return k == a1.length()?-1:1;
    }

    public static void main(String [] args){
        new Solution386().lexicalOrder(10);
    }
}
