**********************************Binary Search - Find out how many times the array has been rotated *****************************************

public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            //checking if left half is sorted or not
            int mid=(low+high)/2;
            if(arr[low]<=arr[high]){
                if(arr[low]<ans) {
                    ans=arr[low];
                    index=low;
                }
                break;
            }
            if(arr[low]<=arr[mid]){
               if(arr[low]<ans) {
                    ans=arr[low];
                    index=low;
                }
                low=mid+1; //we eliminate the left half
            }
            else{

                if(arr[mid]<ans) {
                    ans=arr[mid];
                    index=mid;
                } high=mid-1;
            }
        }
        return index;
    }
}