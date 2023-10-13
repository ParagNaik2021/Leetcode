**********************************Binary Search -  Koko Eating Bananas*****************************************

class Solution {
    public static int findMax(int[] nums){
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        return maxi;
    }
    public int calculateTotalHr(int[] arr,int hour){
        int totalH=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totalH += Math.ceil((double)(arr[i]) / (double)(hour));
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int totalH=calculateTotalHr(piles,mid);
            if(totalH<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
