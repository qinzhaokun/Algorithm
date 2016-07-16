/*
Problem Description
WANGPENG is a freshman. He is requested to have a physical examination when entering the university.
Now WANGPENG arrives at the hospital. Er….. There are so many students, and the number is increasing!
There are many examination subjects to do, and there is a queue for every subject. The queues are getting longer as time goes by. Choosing the queue to stand is always a problem. Please help WANGPENG to determine an exam sequence, so that he can finish all the physical examination subjects as early as possible.
 

Input
There are several test cases. Each test case starts with a positive integer n in a line, meaning the number of subjects(queues).
Then n lines follow. The i-th line has a pair of integers (ai, bi) to describe the i-th queue:
1. If WANGPENG follows this queue at time 0, WANGPENG has to wait for ai seconds to finish this subject.
2. As the queue is getting longer, the waiting time will increase bi seconds every second while WANGPENG is not in the queue.
The input ends with n = 0.
For all test cases, 0<n≤100000, 0≤ai,bi<231.
 

Output
For each test case, output one line with an integer: the earliest time (counted by seconds) that WANGPENG can finish all exam subjects. Since WANGPENG is always confused by years, just print the seconds mod 365×24×60×60.
 

Sample Input
5
1 2
2 3
3 4
4 5
5 6
0
 

Sample Output
1419
Hint

In the Sample Input, WANGPENG just follow the given order. He spends 1 second in the first queue, 5 seconds in the 2th queue, 27 seconds in the 3th queue, 
169 seconds in the 4th queue, and 1217 seconds in the 5th queue. So the total time is 1419s. WANGPENG has computed all possible orders in his 
120-core-parallel head, and decided that this is the optimal choice.
*/

package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ABC on 2016/6/16 0016.
 */
class Node{
    int a;int b;
}

class Compare implements Comparator<Node>{
    public int compare(Node t1,Node t2){
        return t1.a*t2.b - t2.a*t1.b;
    }
}
public class greedy_hdu_4442_Physical_Examination {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Node [] arr = new Node[100005];
        for(int i = 0;i < 100005;i++) arr[i] = new Node();
        while(true){
            int n = scanner.nextInt();
            if(n == 0) break;
            for(int i = 0;i < n;i++){
                arr[i].a = scanner.nextInt();
                arr[i].b = scanner.nextInt();
            }

            Arrays.sort(arr,0,n,new Compare());

            long t = 0;
            for(int i = 0;i < n;i++){
                t += (arr[i].a + t*arr[i].b);
            }
            System.out.println(t%(365*24*60*60));

        }
    }
}
