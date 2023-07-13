**********************************DP & Iteration *****************************************

class Solution {
    public int maxProfit(int[] prices) {

        //Using DP--->TC=O(N)
        int mini=prices[0];
        int maxProfit=0;
        int n=prices.length;

        for(int i=1;i<n;i++)
        {
            int cost=prices[i]-mini;
            maxProfit=Math.max(maxProfit,cost);
            mini=Math.min(mini,prices[i]);
        }
        return maxProfit;

    }
}