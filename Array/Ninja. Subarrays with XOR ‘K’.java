****************************Optimal Solution*******************************
import java.util.*;
public class Solution {
    public static int subarraysWithSumK(int []A, int B) {
        // Write your code here
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int count = 0; 
        int xr = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            xr = xr ^ A[i]; 
            if(visited.get(xr^B) != null) 
                count += visited.get(xr ^ B); 
            if(xr == B) {
                count++; 
            }
            if(visited.get(xr) != null) 
                visited.put(xr, visited.get(xr) + 1); 
            else 
                visited.put(xr, 1); 
        }
        return count; 
    }
}

***********************************************
*Time Complexity: O(N), Space Complexity: O(N)*
***********************************************