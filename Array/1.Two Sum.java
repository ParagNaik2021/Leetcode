Variety 1- If we need to return index of the element which add up to target
Below is the better and optimal approach for this variety

class Solution {
    public int[] twoSum(int[] nums, int target) {
      /* Better solution*/
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int val=target-nums[i];
            if(map.containsKey(val))
            {
                result[0]=i;
                result[1]=map.get(val);
                return result;
              //  return new int[]{i, map.get(val)}; //this will return a array
            }
            map.put(nums[i],i);
        }

        return result;
        //return new int[]{-1,-1};
 
    }
}



Variety 2- We need to return "Yes or No" if the target is achieved. The problem is on coding ninja
Link-https://www.codingninjas.com/codestudio/problems/reading_6845742?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTab=1

import java.util.Arrays;

public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        Arrays.sort(book);
        int left=0;
        int right=book.length-1;
        while(left<=right)
        {
            int sum=book[left]+book[right];
            if(sum==target)
            {
                return "YES";
            }
            else if(sum<target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

return "NO";
    }
}
