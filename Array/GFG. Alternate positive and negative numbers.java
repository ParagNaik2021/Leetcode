class Solution {
   void rearrange(int arr[], int n) {
      // code here
      ArrayList < Integer > pos = new ArrayList < > ();
      ArrayList < Integer > neg = new ArrayList < > ();
      int index = 0;
      for (int i = 0; i < n; i++) {
         if (arr[i] < 0) {
            neg.add(Integer.valueOf(arr[i]));
         } else {
            pos.add(Integer.valueOf(arr[i]));
         }
      }

      if (pos.size() > neg.size()) {
         for (int i = 0; i < neg.size(); i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
         }
         index = neg.size() * 2;
         for (int i = neg.size(); i < pos.size(); i++) {
            arr[index] = pos.get(i);
            index++;
         }
      } else {
         for (int i = 0; i < pos.size(); i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
         }
         index = pos.size() * 2;
         for (int i = pos.size(); i < neg.size(); i++) {
            arr[index] = neg.get(i);
            index++;
         }

      }

   }
}