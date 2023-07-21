**********************************714. Best time to buy and sell with transaction fee but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {

	public static int f(int ind, int buy, int[] prices, int n,int fee) {
    //base case
    if (ind >= prices.length) return 0;
    int profit = 0;
    if (buy == 1) {
      profit = Math.max(((-prices[ind]-fee) + f(ind + 1, 0, prices, n,fee)), 
                        (0 + f(ind + 1, 1, prices, n,fee)));
    } else {
      profit = Math.max((prices[ind] + f(ind + 1, 1, prices, n,fee)),
                         (0 + f(ind + 1, 0, prices, n,fee)));
    }
    return profit;
  }
    public int maxProfit(int[] prices, int fee) {
      int n=prices.length;
        return f(0, 1, prices, n,fee);
    }
}

****************************Memoization approach***************************************************
//Memoization


***************************************Tabulation approach****************************************
//Tabulation

   


***************************************Space optimization approach****************************************
//Space optimization
class Solution {

	public static int f(int ind, int buy, int[] prices, int n,int fee) {
    //base case
    if (ind >= prices.length) return 0;
    int profit = 0;
    if (buy == 1) {
      profit = Math.max(((-prices[ind]-fee) + f(ind + 1, 0, prices, n,fee)), 
                        (0 + f(ind + 1, 1, prices, n,fee)));
    } else {
      profit = Math.max((prices[ind] + f(ind + 1, 1, prices, n,fee)),
                         (0 + f(ind + 1, 0, prices, n,fee)));
    }
    return profit;
  }
    public int maxProfit(int[] prices, int fee) {
      int n=prices.length;
        return f(0, 1, prices, n,fee);
    }
}