**********************************540. Single Element in a Sorted Array - Binary Search *****************************************

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){ 
                return nums[mid];
                }
            //we are on odd index and our target element is in right so we eliminate the left side
            if(mid%2==1 && nums[mid-1]==nums[mid] || mid%2==0 && nums[mid+1]==nums[mid]) {
                low=mid+1;
                }
            //we are on even index and our target element is in left so we eliminate the right side
          
           else {
               high=mid-1;
               }
        }

        return -1;
    }
}