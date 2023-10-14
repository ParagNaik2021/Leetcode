*****************************************************Using Linear Search--> Not Best approach ********************************************************************************

class Solution {
   public int findDays(int[] weight, int cap) {
      int days = 1;
      int load = 0;
      int n = weight.length;
      for (int i = 0; i < n; i++) {
         if (load + weight[i] > cap) {
            days += 1;
            load = weight[i];
         } else {
            load += weight[i];
         }
      }
      return days;
   }
   public int shipWithinDays(int[] weights, int days) {
      int maxi = Integer.MIN_VALUE, sum = 0;
      for (int i = 0; i < weights.length; i++) {
         sum += weights[i];
         maxi = Math.max(maxi, weights[i]);
      }

      for (int i = maxi; i <= sum; i++) {
         if (findDays(weights, i) <= days) {
            return i;
         }
      }
      //dummy return statement:
      return -1;
   }
}

**********************************Binary Search - Capacity To Ship Packages Within D Days *****************************************

class Solution {
    public int findDays(int[] weight,int cap){
        int days=1;
        int load=0;
        int n=weight.length;
        for(int i=0;i<n;i++){
            if(load+weight[i]>cap){
                days+=1;
                load=weight[i];
            }
            else{
                load+=weight[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weight, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<weight.length;i++){
            high+=weight[i];
            low=Math.max(low,weight[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            int numberOfDays=findDays(weight,mid);
            if(numberOfDays<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}