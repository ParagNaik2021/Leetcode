**********************************1539. Kth Missing Positive Number--Naive Approach *****************************************

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=k) k++;
            else break;
        }
        return k;
    }
}


***************************************Binary Search************************************************
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int n=arr.length;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high+1+k;
    }
}