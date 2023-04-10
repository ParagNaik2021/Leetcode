class Solution {
   public void setZeroes(int[][] matrix) {

      //Optimal Solution-->
      int col0 = 1;
      int n = matrix.length;
      int m = matrix[0].length;
      //marking which row and col will be affected
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if (matrix[i][j] == 0) {
               //mark the i-th row
               matrix[i][0] = 0;
               //mark the j-th col
               if (j != 0)
                  matrix[0][j] = 0;
               else
                  col0 = 0;
            }
         }
      }
      //Marking the 1 as 0

      for (int i = 1; i < n; i++) {
         for (int j = 1; j < m; j++) {
            if (matrix[i][j] != 0) {
               //check for col and row
               if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                  matrix[i][j] = 0;
               }
            }

         }
      }

      //check for col used for marking and start with it
      if (matrix[0][0] == 0) {
         for (int j = 0; j < m; j++) {
            matrix[0][j] = 0;
         }
      }

      if (col0 == 0) {
         for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
         }
      }

   }
}

Optimal Solution-
TC-O(2*N*M)
SC-O(1)