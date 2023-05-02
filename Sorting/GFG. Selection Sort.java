********************************************** Selection Sort ************************************************

class Solution {
   int select(int arr[], int i) {
      // code here such that selectionSort() sorts arr[]
      int mini = i;

      for (int j = i + 1; j < arr.length; j++) {
         if (arr[j] < arr[mini]) {
            mini = j;
         }

      }
      return mini;
   }

   void selectionSort(int arr[], int n) {
      //code here
      for (int i = 0; i < n - 1; i++) {
         int mini = select(arr, i);

         int temp = arr[mini];
         arr[mini] = arr[i];
         arr[i] = temp;
      }
   }
}