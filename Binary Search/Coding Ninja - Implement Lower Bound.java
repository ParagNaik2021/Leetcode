**********************************Binary Search- Coding Ninja Implement lower bound *****************************************
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1; 
            }
        }
        return ans;
    }
}

Note:- Time Complexity: O(logN), where N = size of the given array.
Reason: We are basically using the Binary Search algorithm.

Space Complexity: O(1) as we are using no extra space.