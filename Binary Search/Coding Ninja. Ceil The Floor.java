**********************************Binary Search*****************************************
import java.util.* ;
import java.io.*; 
public class Solution {
    static int findFloor(int[] arr,int n,int x){
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    static int findCeil(int[] arr,int n, int x){
         int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
      static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        // Write your code here.
        Arrays.sort(arr);
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.print(ans[0]+" ");
        return ans[1];
           }
} 