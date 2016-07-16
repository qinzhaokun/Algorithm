package roundA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by KUN on 2016/7/10.
 */
public class _1 {

    public static void main(String [] args){
        try {
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));
            System.setOut(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int r = 1;
        while(r <= t){
            int n = scanner.nextInt();scanner.nextLine();
            String target = "";
            String output = "";
            int max = 0;
            for(int i = 0;i < n;i++){
                String line = scanner.nextLine();
                String afterReMove = remove(line);
                int num = count(afterReMove);
                if(max < num || (max == num && line.compareTo(target) < 0)){
                    max = num;target = afterReMove;output = line;
                }
            }
            System.out.println("Case #"+r+": " + output);
            r++;
        }

    }

    static int count(String line){
        int [] c = new int[26];
        int num = 0;
        for(int i = 0;i < line.length();i++){
            int tmp = line.charAt(i)-'A';
            if(c[tmp] == 0) {num++;c[tmp]++;}
        }
        return num;
    }

    static String remove(String line){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < line.length();i++){
            if(line.charAt(i) != ' ') sb.append(line.charAt(i));
        }
        return sb.toString();
    }
}


/*
Problem

The Constitution of a certain country states that the leader is the person with the name containing the greatest number of different alphabet letters. (The country uses the uppercase English alphabet from A through Z.) For example, the name GOOGLE has four different alphabet letters: E, G, L, and O. The name APAC CODE JAM has eight different letters. If the country only consists of these 2 persons, APAC CODE JAM would be the leader.

If there is a tie, the person whose name comes earliest in alphabetical order is the leader.

Given a list of names of the citizens of the country, can you determine who the leader is?
Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line with an interger N, the number of people in the country. Then N lines follow. The i-th line represents the name of the i-th person. Each name contains at most 20 characters and contains at least one alphabet letter.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the name of the leader.
Limits

1 ¡Ü T ¡Ü 100.
1 ¡Ü N ¡Ü 100.
Small dataset

Each name consists of at most 20 characters and only consists of the uppercase English letters A through Z.

Large dataset

Each name consists of at most 20 characters and only consists of the uppercase English letters A through Z and ' '(space).
All names start and end with alphabet letters.
Sample


Input

Output

2
3
ADAM
BOB
JOHNSON
2
A AB C
DEF

Case #1: JOHNSON
Case #2: A AB C


In sample case #1, JOHNSON contains 5 different alphabet letters('H', 'J', 'N', 'O', 'S'), so he is the leader.

Sample case #2 would only appear in Large data set. The name DEF contains 3 different alphabet letters, the name A AB C also contains 3 different alphabet letters. A AB C comes alphabetically earlier so he is the leader.
 */
