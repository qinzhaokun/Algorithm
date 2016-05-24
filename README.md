# Algorithm

This is the algorithm exercise for my interview, come on!!

##动态规划：

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


###二分搜索：

####lpj_minimize_max: 最大值最小化。这题是算法竞赛入门的例题。典型的二分+贪心。最大值的范围是多少？[1,max]， max是所有元素的和，在这个范围内二分查找，对于每一个mid，判断一下可以把起分为k组（小于k也行），使得每组的和都小于mid，如果成立，在[1,mid]继续搜索，否则在[mid+1,max]中搜索。

这题还有一个dp的方法，可以把其看成具体的问题，例如，有n个作业，每个作业都有一个完成时间，有k个人，他们的效率相同，怎么分配使得所有作业都完成的时间最少，一个人只能完成连续的作业。递推关系如下：定义dp[i][j]表示前i个作业j个人完成最小的时间，那么：

    dp[i][j] = min(max(dp[t][j-1],m[t+1]+m[t+2]+...m[i])) 0 <= t <= i
    
