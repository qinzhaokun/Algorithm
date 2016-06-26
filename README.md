# Algorithm

This is the algorithm exercise for my interview, come on!!

##深度优先搜索

####dfs_codeforce_659E_New_Reform

题意：有n座城市，城市之间有无向边，现在要把所有的边变成有向的边，使得入度为0的城市尽可能的少。

解答：如果是无向边构成的图，可以看成是一颗“树”，正常情况下的树只有根节点入度是0.但是，如果原来的图有环，所有的节点的入度都可以不为0，只要循环指向即可。因此，问题转化为dfs找环。遍历所有的联通集合，如果有环，则这个集合可以不存在入度为0的节点，否则，总结果+1.

###如何求树的直径？？树中距离最大的两个点

解答：对于任意一个节点，用bfs求到它最远的点s，则这个点s必是直径的一个点。在从s出发，bfs找到另一个最远的点t，(s,t)就是直径。


##动态规划：

###普通dp

####hdu_4248_A_Famous_Stone_Collector

题意：给n堆不同颜色的石头，给定每堆石子的数量，问，能够组成多少串满足：Two patterns are considered different, if and only if they have different number of stones or have different colors on at least one position.

解答：这题用组合数学+动态规划。考虑前i-1种石头，组成了长度是j，很明显，这里j的大小是[1,arr[0]+arr[1]+...+arr[i-1]]范围内，考虑第i种石头，则可以往长度为j的石头序列中加入0,1,...,arr[i]个石头不同的情况，比如往长度为j的序列里加入k个石头，则都有C(j+k,k)种可能。因此递推表达式是：

    for(int j = 0;j <= sum;j++){
        for(int k = 0;k <= arr[i];k++) dp[i][j+k] += dp[i-1][j]*c[j+k][k];
    }

####hdu_4526威威猫系列故事——拼车记

题意：有n个人准备做出租车，有k辆车在不同的时刻t[i]到来，每辆车都给定剩余的位置p[i],每次车来的时候，如果有人上车，不管多少人，都要付d元，由于时间就是金钱，每个人多等x分钟，就相当于花费了x元，问怎么安排上车，才能使得总花费最小。

解答：典型的贪心和dp，如果一辆车来了，要么不上，要么尽可能上多的人，因为没坐满的话后面的人再上就浪费时间了。但是如果来一辆车，尽可能都上满的话，也不是最优的，可以先不上前面的，因为可能后面来的车位置更多，可以用d元一次载跟多人，抵消了等待所耗费的金钱。用动态规划思考，dp[i][j]表示前i辆车带走j个人所花费的最小时间，初始时dp[0][j]表示0辆车带走多少人都是max，除了dp[0][0]=0; 当第i辆车来的时候，让dp[i-1][j]的值覆盖dp[i][j]的值，0<=j<=n 表示不做第i辆车的。接着，考虑第i辆车的剩余空位p[i],用r从遍历到1->p[i]，去更新dp[i][j+r]=min(dp[i][j+r],dp[i-1][j]+d+r*t[i]),表示第i辆车多带走r个人的最优结果。做到这反而觉得和贪心没什么关系了。最后看dp[k][n]的值就是所求。

####hdu_4597_play_game

题意：给两个长度为n的数组，每次只能从两个数组的头或尾拿一个数，问某个人先拿，双方都很聪明，他最多能得多少？

解答：动态规划，弄了好久，发现自己的思路有缺陷，边界条件特别难处理。要用开区间好做些。设dp[i][j][k][t]表示

###状态dp，二进制表示，状态压缩：

####poj3254-Corn Fields 

题意：一个n*m的矩阵，每个格子是0或者1，1表示土壤肥沃可以种植草地，0则不可以。在种草地的格子可以放牛，但边相邻的两
个格子不允许同时放牛，问总共有多少种放牛的方法？（不放牛也算一种情况）。

解答：基于状态的动态规划入门题。这样考虑，每一行能够几种放置方法？是不是这和这一行，上一行，下一行有关，由于是动态规划，先不用考虑下一行。
一行一共有多少种放置方法呢？假设一行有n个位置，要么不放0，要么全部放1111（n个1）。因此，总共有2<<n种放置方法，可以用[0,2<<n)来表示所有的
放置状态。但是每一种放置都是合法的吗？显然不是.要满足3个条件：

1: 相邻的不同同时是1. 因此，只有满足i&(i<<1) == 0 的状态i才是满足条件的。

2：在矩阵中，只有土地肥沃的才能放牛（对应位置要是1）。因此对于第i行，可以得到一个数j，是土地肥沃与否的二进制表示。比如1010 --> 10.将其
取反得到0101，在和转态j与操作，如果等于表示状态j合法，个人觉得这一步很精妙。

3：最后一个，与上一行不能有冲突。因此对于状态j，遍历上一行的状态（用k表示），只有j&k==0才合法，合法的话就有dp[i][j] += dp[i-1][k];

最后统计最后一行的所有状态的数量即可，记得要MOD一个数。

####hdu_1074_doing_homework

题意：给定一定数量的课程，每个课程有名字，dealine，day（需要花多少天才能完成），如果超过deadline完成，没超过一天，多扣一分，求一个完成
顺序，使得扣的分数最少，如果分数相同，则按照课程字典序完成。

解答：比较高级的状态dp，虽然在hdu上通过率还是比较高的。想想dfs可以做的，复杂度是O(n!)。对于所有课程，必须要全部完成，然后有没有中间状态，比如一部分完成，一部分未完成，然后选择未完成的课程去完成，从而跳转成新状态。需要以下几个步骤：

1：二进制表示完成状态，假设n门课程，用[0,(2<<n))表示所有状态，对应位是0表示未完成，1表示已完成。每个状态还有一些变量，days--> 已经用的天数；reduce-->被扣的分数；last-->上一个转态

2：初始化最初的状态，0000，上一个状态是null；从0遍历到2<<n每一个状态，对于状态i，依次遍历每个课程编号j，如果(i & (1<<j)) == 0 表示状态i第j门课还没做，这里有一个需要注意的是，遍历到i状态时，状态i必然已经被赋值过，这里比较trick（当i=0 时，遍历课程，完成所有一门的情况都出来了，遍历i=1， 所有完成2门课的情况都完成了，因此，遍历到i状态，i状态一定在[0,i)中的状态的循环中赋值过了）。要完成新的课程，新的状态变成i|(1<<j)， 计算一下加入新的课程的reduce变成多少，reduce = dp[i].reduce + course[j].deadline-dp[i].days-course[j].days; 如果新的状态没有被初始化，新的状态由i+j转变，如果被初始化，比较一下reduce，如果dp[new].reduce > reduce，则由状态i+j转变。注意不用比较相等的情况，因为课程的遍历按照字典序的，因此相等的话必然字典序小的先被赋值。

3:总的最优reduce就是dp[(2 << n)-1].reduce，然后根据最后状态的last状态递归寻找路径输出.

####poj_1185_炮兵阵地: 

题意：一个矩阵，H表示高地，不能放东西，P表示平原，可以放大炮，打炮可以前后左右打两个，不能斜向。求最多能放多少个大炮，不能相互攻击。

解答：典型状态dp。每一行用二进制数来表示，0表示不放，1表示放，可得到所有状态，一行不相互攻击，二进制数满足(i & (i << 1)) == 0和(i & (i << 2)) == 0， 这是一个条件，可以过滤得到一行所有的状态；关于只有平原能够放大炮，状态i和rows[r] 与得到0才是可行的。最后第三点，重点来了，如果进行动态规划，poj3254-Corn Fields， 上下相邻的不能同时是1，我们用了一个二维数组,是的(state[i] & state[j]) == 0 去更新dp[r][i]， j 遍历了r-1所有的状态；现在这题，第r行和第r-1和第r-2都有关，我们就需要建立三维数组，dp[r][i][j]表示第r行状态是i，第r-1行状态是j，的最多大炮数量，那么，就需要遍历r-2所有的状态，最后得到dp[r][i][j] = max(dp[r][i][j],dp[r-1][j][k]+sum[state[i]]);具体参加代码。

###树形dp

####dp_tree_poj_2342_Anniversary_party

题意：有个party，每个人都有一个参加此party的愉悦值，同时还给出这些人中上下属的关系，上下属不能同时参加，求问怎么安排，使得愉悦值和最大，最大是多少？

解答：树形dp入门，人的关系可以看成一棵树，对于每个人有dp[i][0]表示不参加的愉悦值，dp[i][1]表示参加的愉悦值。遍历所有节点，每当遇到根节点，就进行后序遍历，dp[i][1] += dp[child][0]; dp[i][0] += Math.max(dp[child][0],dp[child][0]). 在递归返回之前，dp[i][1]+=i的愉悦值.

####dp_hdu_2196_Computer

题意：大概是n个节点，n-1条边形成树，每条边都有一个权值。问，对于树中的任意一个顶点，经典题，求树每个点到其他点的最远距离。

解答：典型的树形dp来做。原理，对于一棵树，他的最远距离来自子节点或者父节点。首先以任意一个点为根，dfs，每次求两个值first[i],second[i], 分别对应以i为根节点的所有子节点中离其最远和和次远的距离。这样，我们就求出了某个顶点，它的子树求中所有的节点最远距离。现在，要求的是从其根的方向来的最长距离。第二次dfs，对于节点u，其父节点p，来自父节点的的最长距离thrid[u]有两种情况。1）一种是直接从u的父节点方向而来，这时是thrid[u]+len(u,v); 2) 另一种是经过父节点u（中转），导向v的某个兄弟节点，因此当u来自子树的最长的距离不来自v，那么thrid[v] = first[u]+len(u,v), 如果不巧，正好来自v，那么不能再走v了，这是要走second[u]了。1）和 2） 取最大的。

整个first[i] 来自子树 和 thrid[i] 来自经过父亲 中的最大值。

事实上上面的方法太麻烦，还有一个更普遍的定理。树中的任意一个点的最远距离的点都是树的直径中的任意一个点，因此，先找直径，在找出每个点到直径的两个端点的距离，比较一下即可。

##图论

###二分图

####graph_hdu_4160_Dolls

题意：有N个Doll，给出对应的长宽高，一个Doll能放到令一个Doll里，当前仅当长宽高分别比其小，并每个Doll最多只能嵌套1个Doll.问如何嵌套使得最后剩的在外面的Doll最少。

解答：首先利用嵌套关系构造图，由于关系限定，肯定图中不会出现回路，而且考虑的是1对1的关系，因此，往二分图上考虑。问题可以转化为：最小路径覆盖=顶点数-最大匹配数。其实这个转化还是挺神奇的，最大匹配数用匈牙利算法解解就好了，详细的分析记录在博客中了。

##贪心算法

####lrj_最优装载问题

给出n个物品，每个物品重量是wi，选择尽量多的物品，使得总的质量不超过C。

思路：按照重量排序，从小达到一次选取。无代码。

####lrj_乘船问题

有n个人，每个人重量是wi，每艘船最多能承受C，且最多能载两个人。问最少需要多少条船才能载下所有人。

解答：从小到大排序，从最小的开始，找最大的能够和他一起的配对。

####lrj_选择不想交的区间

有n个区间[ai,bi]，选择最多的不想交的区间

解答：首先明确一点，如果区间x包含区间y，则一定不能选x，要选y。因为选x和y都是增加1，但是选y的代价小。现在按照bi排序。从小到大一个个选取不相交的。对于bi<=bj，选择bi对后面的代价小。类似的题目：安排会议，要求安排尽可能多的会议。


##二分搜索：

####lpj_minimize_max: 

最大值最小化。

这题是算法竞赛入门的例题。典型的二分+贪心。最大值的范围是多少？[1,max]， max是所有元素的和，在这个范围内二分查找，对于每一个mid，判断一下可以把起分为k组（小于k也行），使得每组的和都小于mid，如果成立，在[1,mid]继续搜索，否则在[mid+1,max]中搜索。

这题还有一个dp的方法，可以把其看成具体的问题，例如，有n个作业，每个作业都有一个完成时间，有k个人，他们的效率相同，怎么分配使得所有作业都完成的时间最少，一个人只能完成连续的作业。递推关系如下：定义dp[i][j]表示前i个作业j个人完成最小的时间，那么：

    dp[i][j] = min(max(dp[t][j-1],m[t+1]+m[t+2]+...m[i])) 0 <= t <= i
    
####binary_search__codeforce_660C_hard_process

题意：给定一个长度为n的0，1序列，和一个k，问最多可以把k个0变成1，使得连续的1最长。

解答：这题非常精妙，问题装换很重要，一开始以为dp啥的都是不对的。问题可以很难想到的转为找到一个最长的子序列，使得包含的0小于等于k。这样问题就可以容易解答出来了.用一个一维数组存储0到i有多少个0，这样对于任意的子序列i,j，都可以用a[j]-a[i-1]求出有多少个0.可以用二重循环遍历所有可能性，但是题目需要考察的是更快的二分。因为a数组显然是升序的，所以每次可以固定最后一个最为右边界，左边界从0到n，每一次都用二分发找到最大的满足的子序列，时间复杂度可以降到nlogn。
    
##母函数：

在谈论母函数问题之前，我们先看一个简单的问题描述：假如有两组数据（A,B）和（C,D），每组中选出一个构成一个组合，总共有几种选法？很显然总共有4种选法：AC,AD,BC,BD。而且很容易联想到这个式子（A+B）*（C+D）=A*C+A*D+B*C+B*D。式子中的几个乘积项就是上面的4种选法。假如把问题换一下：每组中选出一个或0个数据构成组合，总共有几种组合？那么结果就变成：{空},A,B,C,D,AC,AD,BC,BD，而式子（1+A+B）*（1+C+D）=1+C+D+A+A*C+A*D+B+B*C+B*D，正好和上面组合的结果又一致（1代表什么都没选）。从这2个例子我们可以发现多项式乘积和组合存在着某种关系。事实上我们可以这么理解：（1+A+B）可以理解为从第一组数据中取0个数据，取A或者取B，同样（1+C+D）可以理解为从第二组数据取0个数据，取C或者取D。两者相乘的结果就表示了所有的组合。再看一下这个多项式：

    （1+x）*（1+x+x2）*（1+x3）=1+2x+2x2+2x3+2x4+2x5+x6

　　这个多项式和上面的有一些区别了，它的幂级数超过1了。如果要从（1+x）、（1+x+x2）和（1+x3）中得到x的2次方的话，有两种选择：从（1+x）和（1+x+x2）中分别选择一个x或者从（1+x+x2）中选择x2；如果要得到x的6次方的话，只有1种选择，就是从（1+x）中选择x、（1+x+x2）中选择x2、（1+x3）中选择x3。也就是说乘积结果的每一项anxn的前面的系数an表示了从（1+x）、（1+x+x2）和（1+x3）中得到xn的组合数。

　其实上面的例子就利用了母函数的思想，下面来具体讨论一下母函数。

一.什么是母函数

　　下面这个对于母函数的描述摘自维基百科：

　　在数学中，某个序列 的母函数是一种形式幂级数，其每一项的系数可以提供关于这个序列的信息。

　　也就是说母函数是针对某个序列的，它的外在表现形式是一种形式幂级数。比如说有这样一个序列a0，a1，......an，构造一个函数

　　f(x)=a0+a1x+a2x2+......+anxn

　　则f(x)是序列a0，a1，......an的母函数。比如说最常见的(1+x)n，它是序列C(n,0)，C(n,1)，C(n,2)...C(n,n)的母函数。

二.利用普通型母函数解决组合问题

　利用母函数的思想可以解决很多组合问题，下面举例说明：

　1.口袋中有白球2个，红球3个，黄球1个，从袋中摸出3个球有几种取法？

　   和上面描述的例子类似，我们可以用次数代表球的个数，多项式的每一项前面的系数代表取法的种树。

　　可以很容易地写出下面这个式子：

　　（1+x+x2）（1+x+x2+x3）（1+x）

 　　（1+x+x2）表示有白球2个，1表示白球不取，x代表取1个白球，x2代表取2个白球，即用x的次数表示取球的个数，后面的也是类似。那么这个多项式的乘积就把所有的情况都表示出来了，对于最终乘积的每一项anxn，表示取n个球有an种取法。

    2.有若干个1克，2克，5克的砝码，要称出20克的重量，有多少种称法？

　　这里不限制砝码的个数，无所谓，照样写出母函数：

　　（1+x+x2+x3+......xk+....）（1+x2+x4+x6......+x2n+......）（1+x5+x10+......x5m+......）

　　因为要称出20克，所以只需要找找到结果中次数为20 的那一项就可以得到结果。

    3.同样对于正数划分也可以解决，比如有整数20，划分成1，2，5，有多少种划分方法？

　　解法和2的类似。

     还有一类题目和这类似，有n个球放到m个盒子中，有多少种不同的放法？

    （1+x+x2+x3+...xk+...）（1+x+x2+x3+...xk+...）（1+x+x2+x3+...xk+...）总共有m项，然后找出乘积中次数为n的那一项系数。
    
####hdu_1085_Holding Bin-Laden Captive!

题意：有3种硬币，面值是1，2,5 ,数量分别是num_1,num_2,num_5，问用这些硬币表示钱数，最小的不能表示的是多少钱？

解答：这题要用母函数表示的方法，表达式是(1+x+x^2+...+x^num_1)*(1+x+x^2+...+x^num_2)*(1+x+x^2+...+x^num_5),展开后求各项的系数，第一个是0的就是所求的。那么，如何计算这样的表达式？

从题目出发，最大的数值应该是1*num_1+2*num_2+5*num_5， 用arr[i]表示i的x^i的系数。

先求出(1+x+x^2+...+x^num_1)各项系数，然后二重循环--> [0,max] 和[0,num_2] 对于k,j， 有arr1[k+j] += arr[k]。这样就arr1表示(1+x+x^2+...+x^num_1)*(1+x+x^2+...+x^num_2)后各项的系数.详见代码。

##字典树

####hdu_4287_Intelligent_IMEI

题意：手机输入是9宫格，给出N个数字组合，和M个字符串，求对于每一个数字组合，可以对应多少个字符串。

解答：典型字典树的应用，以M个字符串建树，由于每个字符都对应一个数字，因此a,b,c对于子节点0，以此类推。。。，在末尾添加结束的标志。最后对于每一个数字，搜索字典树，返回结果。

##并查集

####hdu_4313_matrix

题意：有N个结点，N-1条边相连，每天边有个权值，构成了一个无根树，有K个机器人，分布在结点上，要求切段任意条边，使得K个机器人两量不连通，且切断边的权值之后最小。

解答：并查集+贪心。缩点打法用并查集。首先每个结点都是独立的集合，把边按照从大到小排序，依次遍历，对于每条边，分别找到对应两个点的parent结点，如果对应点都有机器人，则这条边要切掉，否则，把这两个结合合并，p[pa] = pb，if(isM[pa]) isM[pb] = true。

##网络流

####hdu_1532_Drainage_Ditches。

这题是一个标准的网络流题目，大意是有个排水系统，1号是水池，n号是排水口，有若干条路径，每条路径都有一个最大排水值。问最大的排水量是多少。

解答：设定cap[]和flow[]数组，每次找一条增广路径，注意不一定要去找流量最大的增广路径，找到一条即可，更新最大流，直到无法找到增广路径为止。题目有个陷阱就是对于同样的两个顶点，会有多条边，注意处理就好了。

##随机做题

####hdu_1171_Big Event in HDU

题意：HDU要将一个学院拆分成两个，物资也要平均分配，问题是现在有n种物资，每种物资有value[i]和num[i]，问最平均的做法是怎么样，不用求具体分配数，只需输出两个学院最后获得的物资总价值数。

解答：可以求出总价值，就是累加value[i]和num[i]的sum,然后使得能够拿出一些物资，使得总价值最接近sum/2;这变成了一道多重0,1背包问题。空间复杂度可以优化到O(sum/2)

####hdu_1049_Climbing_Worm

题意：大概意思是长为n的路，一分钟可以向前上走u，下一分钟要向下滑d，问最短多少分钟能够走完n。

解答：水题。这样想，当到达n-u时候，下一次走u就能到了，不用考虑下滑的情况。因此，我们要看每两份钟前进u-d步，多少步能够到达n-u.答案是base = Math.ceil((double)(n-u)/u-d)， 这里需要向上取整，最后答案就是2*base+1

####hdu_1076_An_Easy_Task

题意：给出出生年份n，计算第m个闰年。

解答：详见代码。

####hdu_1058_Humble_Numbers

题意：类似第n个丑数，因此只包含2,3,5,7的数叫做Humble Number， 问第n个Humble Number是什么？

解答：类似leetcode的求第n个丑数的题，略。

####poj_1032_Parliament

题意：给定一个数n，将其分解为k个数，使得a1+a2+...+ak=n; 并且a1*a2*...*ak最大。且a1,a2...ak互不相同。

解答：假设有a = b+c， 则b*c>a成立。因此不断的将n二分，再二分，直到无法再分时最大。但是要保证互不相同。因此，需要从2开始，每次+1,使得2+3+...+i <= n, 并且2+3+...+i+i+1>n，这时表示每个数都是无法再分的了，因为再分就会有重复，另外还剩下n-sum个数，她肯定是小于i的，因此把它平摊到2...i中，从最大的开始平摊，这样乘积会最大。

####poj_1088_skiing

题意：给定一个矩阵，数值代表高度，从任意位置滑雪，往下滑，求最长的滑雪长度。

解答：dfs+dp，记忆版的dp。

####hdu_1081_ToTheMax

题意：给出一个矩阵，求一个子矩阵，使得里面数字和最大

解答：用matirx[i][j]存储（0,0）到（i,j）的和。然后用四重循环，遍历所有点对，可用O(1)的复杂度算出其中的和。

####hdu_1097_A hard puzzle

题意：给定两个数a,b,求a^b的最后一个数字

解答：二分递归求解。对于求解a^b的最后一个数字，可求a^(b/2)的最后一个数字是one,并且返回(one*one)%10.
    
