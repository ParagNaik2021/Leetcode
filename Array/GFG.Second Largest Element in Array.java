class Solution {
    int print2largest(int arr[], int n) {
        // code here
        
        //Optimal solution
        if(arr.length==1)
            return arr[0];
            
        int largest=arr[0];
        int secondLargest=-1;
        
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>secondLargest)
            {
                secondLargest=arr[i];
            }
        }
        return secondLargest;
        
        
        
        
        //Better solution TC=O(2N)
    /*    if(arr.length==1)
            return arr[0];
        int largest=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                largest=arr[i];
            }
        }
        
        
        int secondLargest=-1;
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]>secondLargest && arr[j]!=largest)
            {
                secondLargest=arr[j];
            }
        }
        return secondLargest;
        */
    }
}