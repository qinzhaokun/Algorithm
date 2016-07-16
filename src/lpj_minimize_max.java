/*
题目：最大值最小化，给定n个正数，和k，要求把n个正数分成k组，每组的分别求和，使得k个和的最大值最小。
*/



import java.util.Scanner;

/**
 * Created by vincentqin on 2016/5/24.
 */
public class lpj_minimize_max {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int [] arr = new int[n];
            int max = 0;
            for(int i = 0;i < n;i++) {arr[i] = scanner.nextInt(); max += arr[i];}

            //solve(arr,k,max);
            dp_method(arr,k);
        }
    }

    public static void solve(int [] arr, int k, int max){
        int i = 1,j = max;
        while(i < j){
            int mid = i + (j-i)/2;
            if(judge(arr,mid,k)) j = mid;
            else i = mid+1;
        }

        output(arr,j,0,arr.length-1);
    }

    public static boolean judge(int [] arr, int mid, int k){
        int sum = 0; int count = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
            if(sum > mid) {sum = 0;count++;i--;if(count >= k) return false;}
        }
        return true;
    }

    public static void output(int [] arr, int mid, int now, int i){
        if(i == 0) System.out.print(arr[i] + " ");
        else{
            now += arr[i];
            if(now > mid){
                now = arr[i];
                output(arr,mid,now,i-1);
                System.out.print(arr[i] + " " + "|" + " ");
            }
            else{
                output(arr,mid,now,i-1);
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void dp_method(int [] arr , int k){
        int n = arr.length;

        int [][] dp = new int[n][k+1];
        for(int i = 0;i < n;i++) {dp[i][1] = arr[i]; if(i > 0) dp[i][1] += dp[i-1][1];}

        for(int i = 0;i < n;i++){
            for(int j = 2;j <= k && j <= i+1;j++){
                dp[i][j] = dp[i][j-1];
                for(int t = 0;t < i;t++){
                    if(Math.max(dp[t][j-1],dp[i][1]-dp[t][1]) < dp[i][j]) dp[i][j] = Math.max(dp[t][j-1],dp[i][1]-dp[t][1]);
                }
            }
        }

        output(arr,dp[n-1][k],0,arr.length-1);
    }
}
