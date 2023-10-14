**********************************Binary Search - Find the Smallest Divisor Given a Threshold *****************************************

class Solution {
    public static int sumDiv(int[] arr, int threshold,int mid){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum += Math.ceil((double)(arr[i]) / (double)(mid));
        }
       return sum;
    }
    public static int maxVal(int[] arr){
        int maxi=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=maxVal(nums);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumDiv(nums,threshold,mid)<=threshold){
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