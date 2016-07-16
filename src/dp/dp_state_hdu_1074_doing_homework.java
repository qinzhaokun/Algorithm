package dp;/*
oing Homework

Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 1950    Accepted Submission(s): 685



Problem Description
Ignatius has just come back school from the 30th ACM/ICPC. Now he has a lot of homework to do. Every teacher gives him a deadline of handing in the homework. If Ignatius hands in the homework after the deadline, the teacher will reduce his score of the final test, 1 day for 1 point. And as you know, doing homework always takes a long time. So Ignatius wants you to help him to arrange the order of doing homework to minimize the reduced score.
 
Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case start with a positive integer N(1<=N<=15) which indicate the number of homework. Then N lines follow. Each line contains a string S(the subject's name, each string will at most has 100 characters) and two integers D(the deadline of the subject), C(how many days will it take Ignatius to finish this subject's homework). 

Note: All the subject names are given in the alphabet increasing order. So you may process the problem much easier.
 
Output
For each test case, you should output the smallest total reduced score, then give out the order of the subjects, one subject in a line. If there are more than one orders, you should output the alphabet smallest one.
 
Sample Input
2
3
Computer 3 3
English 20 1
Math 3 2
3
Computer 3 3
English 6 3
Math 6 3
 
Sample Output
2 Computer Math English
3 Computer English Math
Hint
In the second test case, both Computer->English->Math and Computer->Math->English leads to reduce 3 points, but the word "English" appears earlier than the word "Math", so we choose the first order. That is so-called alphabet order.
*/


import java.util.Scanner;

/**
 * Created by ABC on 2016/5/22 0022.
 */

class Course{
    public String name;
    public int deadline;
    public int days;

    Course(String name, int deadline, int days){
        this.name = name;
        this.deadline = deadline;
        this.days = days;
    }
}

class Dp{
    public int reduce;
    public int last;
    public int days;
    public Dp lastState;

    Dp() {reduce = 0; last = -1;days = 0;lastState = null;}
}
public class dp_state_hdu_1074_doing_homework {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(T > 0){
            int n = scanner.nextInt();
            Course [] courses = new Course[n];
            for(int i = 0;i < n;i++){
                String line = scanner.nextLine();
                String [] eachs = line.split(" ");
                if(eachs.length != 3){i--;continue;}
                Course each = new Course(eachs[0], Integer.parseInt(eachs[1]),Integer.parseInt(eachs[2]));
                courses[i] = each;
            }

            //finish getting input data

            int total = (1 << n);
            Dp [] dps = new Dp[total];
            for(int i = 0;i < total;i++) dps[i] = new Dp();

            for(int i = 0;i < total;i++){
                for(int j = 0;j < n;j++){
                    //homework j represented by binary
                    int work = 1 << j;

                    //int state i, homework has not been done.
                    if((i & work) == 0){
                        //after doing home j, state change to be cur
                        int cur = (i | work);

                        int finishDay = dps[i].days + courses[j].days;
                        int addReduce = Math.max(0,finishDay-courses[j].deadline);

                        if(dps[cur].last != -1){
                            //since the course is iterator by dictionary sort,
                            // we need not to process the situation of dps[cur].reduce == dps[i].reduce + addReduce
                            if(dps[cur].reduce > dps[i].reduce + addReduce){
                                dps[cur].reduce = dps[i].reduce + addReduce;
                                dps[cur].days = finishDay;
                                dps[cur].last = j;
                                dps[cur].lastState = dps[i];
                            }
                        }
                        else{
                            dps[cur].reduce = dps[i].reduce + addReduce;
                            dps[cur].days = finishDay;
                            dps[cur].last = j;
                            dps[cur].lastState = dps[i];
                        }

                    }
                }
            }

            System.out.print(dps[total-1].reduce + " ");
            output(dps[total-1],courses);
            System.out.println();

            T--;
        }
    }


    public static void output(Dp dp, Course [] courses){
        if(dp.last != -1){
            /*if(dp.lastState.last == -1){
                System.out.println(courses[dp.last].name);
            }*/
            //else{
            output(dp.lastState,courses);
            System.out.print(courses[dp.last].name + " ");

            //}

        }
    }
}
