#A.Country Leader

Problem

The Constitution of a certain country states that the leader is the person with the name containing the greatest number of different alphabet letters. 
(The country uses the uppercase English alphabet from A through Z.) For example, the name GOOGLE has four different alphabet letters: E, G, L, and O. 
The name APAC CODE JAM has eight different letters. If the country only consists of these 2 persons, APAC CODE JAM would be the leader.

If there is a tie, the person whose name comes earliest in alphabetical order is the leader.

Given a list of names of the citizens of the country, can you determine who the leader is?
Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line with an interger N, 
the number of people in the country. Then N lines follow. The i-th line represents the name of the i-th person. Each name contains at most 20
 characters and contains at least one alphabet letter.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the name of the leader.
Limits

1 < T < 100.
1 < N < 100.
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

Sample case #2 would only appear in Large data set. The name DEF contains 3 different alphabet letters, the name A AB C also contains 3 different alphabet 
letters. A AB C comes alphabetically earlier so he is the leader.

##解答
水题，不说了。

#B. Rain

Problem

There's an island in the sea. The island can be described as a matrix with R rows and C columns, with H[i][j] indicating the height of each unit cell. Following is an example of a 3*3 island:
3 5 5
5 4 5
5 5 5
Sometimes, a heavy rain falls evenly on every cell of this island. You can assume that an arbitrarily large amount of water falls. After such a heavy rain, some areas of the island (formed of one or more unit cells joined along edges) might collect water. This can only happen if, wherever a cell in that area shares an edge (not just a corner) with a cell outside of that area, the cell outside of that area has a larger height. (The surrounding sea counts as an infinite grid of cells with height 0.) Otherwise, water will always flow away into one or more of the neighboring areas (for our purposes, it doesn't matter which) and eventually out to sea. You may assume that the height of the sea never changes. We will use W[i][j] to denote the heights of the island's cells after a heavy rain. Here are the heights of the example island after a heavy rain. The cell with initial height 4 only borders cells with higher initial heights, so water will collect in it, raising its height to 5. After that, there are no more areas surrounded by higher cells, so no more water will collect. Again, note that water cannot flow directly between cells that intersect only at their corners; water must flow along shared edges.
Following is the height of the example island after rain:
3 5 5
5 5 5
5 5 5
Given the matrix of the island, can you calculate the total increased height sum(W[i][j]-H[i][j]) after a heavy rain?
Input

The first line of the input gives the number of test cases, T. T test cases follow.
The first line of each test case contains two numbers R and C indicating the number of rows and columns of cells on the island. Then, there are R lines of C positive integers each. The j-th value on the i-th of these lines gives H[i][j]: the height of the cell in the i-th row and the j-th column.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the total increased height.

Limits

1 ≤ T ≤ 100.
1 ≤ H[i][j] ≤ 1000.
Small dataset

1 ≤ R ≤ 10.
1 ≤ C ≤ 10.
Large dataset

1 ≤ R ≤ 50.
1 ≤ C ≤ 50.
Sample


Input 
 	
Output 
 
3
3 3
3 5 5
5 4 5
5 5 5
4 4
5 5 5 1
5 1 1 5
5 1 5 5
5 2 5 8
4 3
2 2 2
2 1 2
2 1 2
2 1 2

Case #1: 1
Case #2: 3
Case #3: 0

Case 1 is explained in the statement.

In case 2, the island looks like this after the rain:

5 5 5 1
5 2 2 5
5 2 5 5
5 2 5 8
Case 3 remains unchanged after the rain.

##解答：

这次笔试就特别倒霉，结束之后就做出来了。发现是要一点地方就可以过了。问题是给定一个矩阵，每个值代表一个高度，问这个矩阵能够灌多少水？

官方的答案是设置另一个矩阵，比如是after，表示灌水的高度，初始化时是边缘的等于matrix[i][j], 里面的是1000（最大值）。之后不断的一次一次的遍历里面的
每个点，找到每个点周围4个点中最小的after[I][J]，如果比after[i][j]还小，就要更新after[i][j]了，当然，这个after[i][j] 必须满足 >= matrix[i][j]。
直到遍历完一次后大仙所有的都不用更新了，就停止输出。测试的时候就是没想到这一步所以没过。

#C. Jane's Flower Shop

Problem

Jane plans to open a flower shop in the local flower market. The initial cost includes the booth license, furnishings and decorations, a truck to transport flowers from the greenhouse to the shop, and so on. Jane will have to recoup these costs by earning income. She has estimated how much net income she will earn in each of the following M months.

Jane wants to predict how successful her flower shop will be by calculating the IRR (Internal Rate of Return) for the M-month period. Given a series of (time, cash flow) pairs (i, Ci), the IRR is the compound interest rate that would make total cash exactly 0 at the end of the last month. The higher the IRR is, the more successful the business is. If the IRR is lower than the inflation rate, it would be wise not to start the business in the first place.

For example, suppose the initial cost is $10,000 and the shop runs for 3 months, with net incomes of $3,000, $4,000, and $5,000, respectively. Then the IRR r is given by:



In this case, there is only one rate (~=8.8963%) that satisfies the equation.

Help Jane to calculate the IRR for her business. It is guaranteed that -1 < r < 1, and there is exactly one solution in each test case.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a positive integer M: the number of months that the flower shop will be open. The next line contains M + 1 non-negative integers Ci (0 ≤ i ≤ M). Note that C0 represents the initial cost, all the remaining Cis are profits, the shop will always either make a positive net profit or zero net profit in each month, and will never have negative profits.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a floating-point number: the IRR of Jane's business. y will be considered correct if it is within an absolute or relative error of 10-9 of the correct answer. See the FAQ for an explanation of what that means, and what formats of real numbers we accept.

Limits

1 ≤ T ≤ 100.
C0 > 0.
0 ≤ Ci ≤ 1,000,000,000.
Small dataset

1 ≤ M ≤ 2.
Large dataset

1 ≤ M ≤ 100.
Sample


Input 
 	
Output 
 
3
2
200 100 100
3
10000 3000 4000 5000
5
3000 100 100 100 100 100

Case #1: 0.000000000000
Case #2: 0.088963394693
Case #3: -0.401790748826

In sample case #1, the IRR is 0, Jane just paid back all the money and no interest.

Sample case #2 and #3 would only appear in Large dataset.

##解答：

这题比上一题更可惜，考虑错了跳出循环的条件，粗心！！题目太长，总结就是求一次多元方程。但是不要求导，不用特殊公式，题目有隐含条件，
就是保证了接唯一，范围在(-1,1)间，可知f(-1)> 0, 函数式单调的，用二分查找即可。其实我并没有读到这个，只是网上搜到了接一个一次三元方程的
程序是二分做的，就用了，这样看来没过心里会好受些。

    while(e-l<0.00000001) //这才是循环跳出的条件，而不是while(Math.abs(re,0) < 0.000000001), 脑子抽了。
    
