**********************************Iterative Approach *****************************************
//Iterative-Leetcode
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }
}

****************************Recurssive approach***************************************************
//Recursion-Leetcode

class Solution {
    int bs(int[] arr,int low,int high,int target){
        //base case
        if(low>high) return -1;

        int mid=(low+high)/2;
        if(arr[mid]==target) return mid;
        else if(target>arr[mid]) return bs(arr,mid+1,high,target);

        return bs(arr,0,mid-1,target);

    }
    public int search(int[] nums, int target) {
        return bs(nums,0,nums.length-1,target);
    }
}