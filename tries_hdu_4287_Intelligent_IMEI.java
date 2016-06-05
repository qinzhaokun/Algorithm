/*
Problem Description
　　We all use cell phone today. And we must be familiar with the intelligent English input method on the cell phone. To be specific, the number buttons may correspond to some English letters respectively, as shown below:
　　2 : a, b, c    3 : d, e, f    4 : g, h, i    5 : j, k, l    6 : m, n, o    
　　7 : p, q, r, s  8 : t, u, v    9 : w, x, y, z
　　When we want to input the word “wing”, we press the button 9, 4, 6, 4, then the input method will choose from an embedded dictionary, all words matching the input number sequence, such as “wing”, “whoi”, “zhog”. Here comes our question, given a dictionary, how many words in it match some input number sequences?
 

Input
　　First is an integer T, indicating the number of test cases. Then T block follows, each of which is formatted like this:
　　Two integer N (1 <= N <= 5000), M (1 <= M <= 5000), indicating the number of input number sequences and the number of words in the dictionary, respectively. Then comes N lines, each line contains a number sequence, consisting of no more than 6 digits. Then comes M lines, each line contains a letter string, consisting of no more than 6 lower letters. It is guaranteed that there are neither duplicated number sequences nor duplicated words.
 

Output
　　For each input block, output N integers, indicating how many words in the dictionary match the corresponding number sequence, each integer per line
*/


package tries;

import java.util.Scanner;

/**
 * Created by ABC on 2016/6/1 0001.
 */
class Tries{
    public Tries [] tries = new Tries[8];
    int count = 0;
}

public class tries_hdu_4287_Intelligent_IMEI {



    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] hash = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        int T = scanner.nextInt();
        while(T > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String [] hold = new String[n];
            for(int i = 0;i < n;i++){
                hold[i] = scanner.nextLine();
                if(hold[i] == null || hold[i].length() == 0) i--;
            }
            Tries root = new Tries();
            for(int i = 0;i < m;i++){
                String line = scanner.nextLine();
                if(line == null || line.length() == 0) {i--;continue;}

                Tries now = root;
                for(int j = 0;j < line.length();j++){
                    int location = hash[line.charAt(j)-'a']-2;
                    if(now.tries[location] == null) now.tries[location] = new Tries();
                    now = now.tries[location];
                }
                now.count++;
            }

            for(int i = 0;i < n;i++){
                Tries now = root;
                int j = 0;
                for(;j < hold[i].length();j++){
                    if(now.tries[hold[i].charAt(j) - '2'] == null) break;
                    else now = now.tries[hold[i].charAt(j) - '2'];
                }
                if(j == hold[i].length()) System.out.println(now.count);
                else System.out.println("0");
            }
            T--;
        }
    }
}
