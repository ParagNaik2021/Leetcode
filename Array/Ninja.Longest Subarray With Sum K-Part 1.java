******************************************************************************************************************************************
* Problem Link:-https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTab=0
* Note-The code is for problem where elements in array are only +ve and zero, the last if is to accomodate the zeros code also
******************************************************************************************************************************************

import java.util.LinkedHashMap;
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here

        //This is will work for +ves but not work for zeros
        LinkedHashMap<Long,Integer> map=new LinkedHashMap<>();
        long sum=0;
        int len=0;
        int maxLen=0;
        for(int i =0;i<a.length;i++)
        {
            sum+=a[i];
            if(sum==k)
            {

                maxLen=Math.max(maxLen,i+1);
            }
            long rem=sum-k;
            if(map.get(rem)!=map.get(map.size()-1))
            {
                len=i-map.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            
         //   map.put(sum,i); commented and added inside below if to accomodate zero also

            if(map.get(sum)==map.get(map.size()-1))
            {
            map.put(sum,i);
        }
        }


        return maxLen;


    }
}


*****************************************************************************************************************************************
//Optimal solution-if array has element +ve and zeros(2 pointer approach)
******************************************************************************************************************************************

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here

        //optimal solution for +ve and zero
        int left=0;
        int right=0;
        long sum=a[0];
        int maxLen=0;
        int n=a.length;

        while(right<n)
        {
            while(left<=right && sum>k)
            {
                sum-=a[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<n)
                sum+=a[right];   
        }
         return maxLen;
    }
}