**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
//Recurssion
class Solution {
  public int f(int ind, int buy, int[] prices, int n) {
    //base case
    if (ind >= prices.length) return 0;
    int profit = 0;
    if (buy == 1) {
      profit = Math.max((-prices[ind] + f(ind + 1, 0, prices, n)), (0 + f(ind + 1, 1, prices, n)));
    } else {
      profit = Math.max((prices[ind] + f(ind + 2, 1, prices, n)), (0 + f(ind + 1, 0, prices, n)));
    }
    return profit;
  }
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int buy = 1;
    return f(0, buy, prices, n);
  }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
  public int f(int ind, int buy, int[] prices, int n, int[][] dp) {
    //base case
    if (ind >= prices.length) return 0;
    int profit = 0;
    if (dp[ind][buy] != -1) return dp[ind][buy];
    if (buy == 1) {
      profit = Math.max((-prices[ind] + f(ind + 1, 0, prices, n, dp)), (0 + f(ind + 1, 1, prices, n, dp)));
    } else {
      profit = Math.max((prices[ind] + f(ind + 2, 1, prices, n, dp)), (0 + f(ind + 1, 0, prices, n, dp)));
    }
    return dp[ind][buy] = profit;
  }
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int buy = 1;
    int[][] dp = new int[n][2];
    for (int[] row: dp) Arrays.fill(row, -1);

    return f(0, buy, prices, n, dp);
  }
}

***************************************Tabulation approach****************************************
//Tabulation

class Solution {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n + 2][2];
    for (int ind = n - 1; ind >= 0; ind--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 1) {
          dp[ind][buy] = Math.max((-prices[ind] + dp[ind + 1][0]), (0 + dp[ind + 1][1]));
        } else {
          dp[ind][buy] = Math.max((prices[ind] + dp[ind + 2][1]), (0 + dp[ind + 1][0]));
        }
      }
    }

    return dp[0][1];
  }
}
   


***************************************Space optimization approach****************************************
//Space optimization---No space optimization because of ind+2 as we need to carry 3 variables


***************************************for loop optimization approach****************************************
//remove buy-for loop because it is redundant
class Solution {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n + 2][2];
    for (int ind = n - 1; ind >= 0; ind--) {

      dp[ind][1] = Math.max((-prices[ind] + dp[ind + 1][0]), (0 + dp[ind + 1][1]));
      dp[ind][0] = Math.max((prices[ind] + dp[ind + 2][1]), (0 + dp[ind + 1][0]));

    }

    return dp[0][1];
  }
}


***************************************Space optimization approach****************************************
//space optimization of above code
class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
        int[] front1=new int[2];
        int[] front2=new int[2];
        int[] curr=new int[2];
        for(int ind=n-1;ind>=0;ind--)
        {
    
            curr[1]=Math.max(-prices[ind] + front1[0], 0 + front1[1]);
            curr[0]=Math.max(prices[ind] + front2[1],0 + front1[0]);

            front2 = (int[])(front1.clone());
            front1 = (int [])(curr.clone());
                    
        }
        return curr[1];
    }
}