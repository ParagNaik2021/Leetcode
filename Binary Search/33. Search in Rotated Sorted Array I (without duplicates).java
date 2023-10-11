**********************************Binary Search - 33. Search in Rotated Sorted Array *****************************************

class Solution {
    public int search(int[] arr, int target) {
        //Why BS? Because we have to search and the array is sort as worst case in Linear search is O(N)
        //Because in BS we eliminate the left half or the right half and the TC reduces to O(N)-->O(n/2)
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            //left part of mid is sorted or not
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
        return -1;
    }
}