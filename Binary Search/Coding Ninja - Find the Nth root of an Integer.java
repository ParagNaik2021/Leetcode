**********************************Binary Search - Find the Nth root of an Integer*****************************************

Naive Approach-

public class Solution {
    public static int NthRoot(int n, int m) {
  
		 for(int i=1;i<=m;i++){
             if(Math.pow(i,n)==m) return i;
			else if(Math.pow(i,n)>m){
				break;
			 }
			
		 }
		 return -1;
    }
}

*****************************************************************************************************************************
Binary Search- O(log n) using Math.pow()

public class Solution {
    //BS search with Math.pow
    public static int NthRoot(int n, int m) {
  
		  int low=1;
          int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            if(Math.pow(mid,n)==m) return mid;
            else if(Math.pow(mid,n)>m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;

    }
}


*****************************************************************************************************************************
Binary Search- Helper Function

public class Solution {
     public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
