package test;

/**
 * Created by zqin on 2016/8/20.
 */
public class Solution43 {

    String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] ret = new int[n1+n2];
        //memset(ret,0,sizeof(ret));
        for(int i = n1-1;i >= 0;i--){
            for(int j = n2-1;j >= 0;j--){
                int a1 = num1.charAt(i)-'0';
                int a2 = num2.charAt(j)-'0';
                int tmp = a1*a2;
                int location = n1-i+n2-j-2;
                ret[location] += tmp;
            }
        }
        int s = 0;
        for(int i = 0;i < n1+n2;i++){
            int k = s+ret[i];
            ret[i] = k%10;
            s = k/10;
        }
        StringBuilder t = new StringBuilder();
        boolean flag = false;
        for(int i = n1+n2-1;i >=0;i--){
            if(!flag&&ret[i] == 0){
                //skip
            }
            else{
                flag = true;
                //char put = '0'+ret[i];
                t.append(ret[i]);
            }
        }
        String re = t.toString();
        if(re.length() == 0) re = "0";
        //reverse(re.begin(),re.end());
        return re;
    }

    public static void main(String [] args){
        Solution43 a = new Solution43();
        a.multiply("9","99");
    }
}
