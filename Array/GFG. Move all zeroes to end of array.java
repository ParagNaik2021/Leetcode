class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        // code here
        //Optimal Approach
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                arr[j]=arr[i];
                j++;
            }
        }
        
        while(j<n)
        {
            arr[j]=0;
            j++;
        }
        
/*        //Brute force approach
        
        int[] temp=new int[arr.length];
        int count=0;
        int j=0;
        
        //TC--->O(N) only insert non-zero number into the temp array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[count++] = arr[i];
            }
        }
        
        
        //TC-->O(X) insert back non-zero element from temp into arr till temp not exhaust
        while(j!=temp.length && temp[j]!=0)
        {
            arr[j]=temp[j];
            j++;
        }
   
        
        //TC--->O(N-X) insert zeros in remaining places of arr array
    
          for(int k=j;k<arr.length;k++)
            {
                arr[k]=0;
            }
            */
        
    }
}