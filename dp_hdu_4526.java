/*
Problem Description
　　话说威威猫有一次去参加比赛，虽然学校离比赛地点不太远，但威威猫还是想坐出租车去。大学城的出租车总是比较另类，有“拼车”一说，也就是说，你一个人坐车去，还是一堆人一起，总共需要支付的钱是一样的（每辆出租上除司机外最多坐下4个人）。刚好那天同校的一群Acmer在校门口扎堆了，大家果断决定拼车去赛场。
　　问题来了，一辆又一辆的出租车经过，但里面要么坐满了乘客，要么只剩下一两个座位，众Acmer都觉得坐上去太亏了，威威猫也是这么想的。
　　假设N名Acmer准备拼车，此时为0时刻，从校门到目的地需要支付给出租车师傅D元（按车次算，不管里面坐了多少Acmer），假如S分钟后恰能赶上比赛，那么S分钟后经过校门口的出租车自然可以忽略不计了。现在给出在这S分钟当中经过校门的所有的K辆出租车先后到达校门口的时间Ti 及里面剩余的座位Zi (1 <= Zi <= 4)，Acmer可以选择上车几个人（不能超过），当然，也可以选择上0个人，那就是不坐这辆车。
　　俗话说，时间就是金钱，这里威威猫把每个Acmer在校门等待出租车的分钟数等同于花了相同多的钱（例如威威猫等待了20分钟，那相当于他额外花了20元钱）。
　　在保证所有Acmer都能在比赛开始前到达比赛地点的情况下，聪明的你能计算出他们最少需要花多少元钱么？
 

Input
输入第一行为T，表示有T组测试数据。每组数据以四个整数N , K , D , S开始，具体含义参见题目描述，接着K行，表示第i辆出租车在第Ti分钟到达校门，其空余的座位数为Zi（时间按照先后顺序）。
[Technical Specification]
T <= 50
N <= 100
K <= 100
D <= 100
S <= 100
1 <= Zi <= 4
1<= T(i) <= T(i+1) <= S
 

Output
对于每组测试数据，输出占一行，如果他们所有人能在比赛前到达比赛地点，则输出一个整数，代表他们最少需要花的钱（单位：元），否则请输出“impossible”。 
 

Sample Input
1
2 2 10 5
1 1
2 2
 

Sample Output
14
*/

package dp;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/15 0015.
 */
public class dp_hdu_4526 {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int [] time = new int[105];
        int [] people = new int[105];
        int [][] dp = new int[105][105];


        int t = scanner.nextInt();
        while((t--) > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            int s = scanner.nextInt();

            for(int i = 0;i < k;i++) {
                time [i] = scanner.nextInt();
                people[i] = scanner.nextInt();
            }

            //dp[i][j] 表示前i辆车送走j个人
            for(int i = 1;i <= n;i++) dp[0][i] = Integer.MAX_VALUE/2;

            dp[0][0] = 0;

            for(int i = 1;i <= k;i++){
                for(int j = 0;j <= n;j++) dp[i][j] = dp[i-1][j];
                    for(int r = 1;r <= people[i-1];r++) {
                        for (int j = 0; j + r <= n; j++) {
                            dp[i][j + r] = Math.min(dp[i][j + r], dp[i - 1][j] + r * time[i - 1] + d);
                        }
                    }
            }

            if(dp[k][n] >= Integer.MAX_VALUE/2) System.out.println("impossible");
            else System.out.println(dp[k][n]);

        }
    }
}
