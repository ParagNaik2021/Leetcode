Problem Link-https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_5713505?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTab=0
Note-This code is for problem where elements in array are both positive and negative


import java.util.* ;
import java.io.*; 
import java.util.LinkedHashMap;
public class Solution {
    public static int getLongestSubarray(int []nums, int k) {
        // Write your code here.

  LinkedHashMap<Long,Integer> map=new LinkedHashMap<>();
        long sum=0;
        int len=0;
        int maxLen=0;
        for(int i =0;i<nums.length;i++)
        {
            sum+=nums[i];
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