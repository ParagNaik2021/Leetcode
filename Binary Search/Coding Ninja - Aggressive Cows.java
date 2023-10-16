**********************************Linear Search - Aggressive Cows********************************************************************
import java.util.*;
public class Solution {
    public static boolean canWePlace(int[] stalls,int  dist, int cows){
        int countCows=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                countCows++;
                last=stalls[i];
            }
            if(countCows>=cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        int n = stalls.length; //size of array
        //sort the stalls[]:
        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (canWePlace(stalls, i, k) == false) {
                return (i - 1);
            }
        }
        return limit;
    }
}

***********************************Binary Search - Aggressive Cows******************************************************************

import java.util.*;
public class Solution {
    public static boolean canWePlace(int[] stalls,int  dist, int cows){
        int countCows=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                countCows++;
                last=stalls[i];
            }
            if(countCows>=cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n=stalls.length;
        int low=1;
        int high=stalls[n-1]-stalls[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(stalls,mid,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}


