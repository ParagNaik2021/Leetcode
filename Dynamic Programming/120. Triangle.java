**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode
class Solution {

  public static int f(int i, int j, int n, List < List < Integer >> triangle) {
    if (i == n - 1) return triangle.get(n - 1).get(j);

    int down = triangle.get(i).get(j) + f(i + 1, j, n, triangle);
    int dia = triangle.get(i).get(j) + f(i + 1, j + 1, n, triangle);

    return Math.min(down, dia);
  }

  public int minimumTotal(List < List < Integer >> triangle) {
    int n = triangle.size();
    return f(0, 0, n, triangle);
  }
}


//Recurrssion-Coding Ninja
import java.util.* ;
import java.io.*; 
public class Solution {

    public static int f(int i,int j,int n,int[][] triangle)
    {
        if(i==n-1) return triangle[n-1][j];

        int down=triangle[i][j]+f(i+1,j,n,triangle);
        int dia=triangle[i][j]+f(i+1,j+1,n,triangle);

        return Math.min(down, dia);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
   
        return f(0,0,n,triangle);
    }
}

****************************Memoization approach***************************************************
//Memoization



***************************************Tabulation approach****************************************
//Tabulation


***************************************Space optimization approach****************************************
//Space optimization
