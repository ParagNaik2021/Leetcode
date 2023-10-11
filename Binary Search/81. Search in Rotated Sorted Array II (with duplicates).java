**********************************Binary Search - Search in Rotated Sorted Array - II with duplicates *****************************************

class Solution {
    public boolean search(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;
         while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return true;
            }
            //left part of mid is sorted or not
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                high=mid-1;}
                else{
                    low=mid+1;
                }
            }
            //right part of array is sorted or not
            else{
                if(arr[mid]<=target && target<=arr[high]){
                low=mid+1;}
                else{
                    high=mid-1;

                }
            }

        }
        return false;
    }
}