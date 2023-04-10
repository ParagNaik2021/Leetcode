********Optimal Solution******************

class Solution {
   public void rotate(int[][] matrix) {
      int n = matrix.length;
      for (int i = 0; i < n - 1; i++) {
         for (int j = i + 1; j < n; j++) {
            //Transpose the matrix so swap(matrix[i][j],matrix[j][i]);
            int temp = 0;
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
      //Reverse each row of matrix
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix.length / 2; j++) {
            int temp = 0;
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length - 1 - j];
            matrix[i][matrix.length - 1 - j] = temp;

         }
      }
   }
}



*****************************************************************************************************************************

Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.

Space Complexity: O(1).