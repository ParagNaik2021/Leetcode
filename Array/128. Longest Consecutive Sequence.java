***********************Optimal Solution**************************************


class Solution {
    public int longestConsecutive(int[] nums) {
        //Optimal Solution-->TC-O(3N), SC-O(N)
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}


*********************************Better Solution****************************************************

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int nums[], int N)
    {
       // Brute Force solution
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int ans = 1;
        int prev = nums[0];
        int cur = 1;
        
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == prev+1){
                cur++;
            }
            else if(nums[i] != prev){
                cur = 1;
            }
            prev = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}