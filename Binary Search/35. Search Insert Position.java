**********************************Binary Search *****************************************
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        int result=n;
        while(low<=high){
            int mid=(low+high)/2;

            if(nums[mid]>=target){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return result;
    }
}

Note:-
Time Complexity: O(logN), where N = size of the given array.
Reason: We are basically using the Binary Search algorithm.

Space Complexity: O(1) as we are using no extra space.
