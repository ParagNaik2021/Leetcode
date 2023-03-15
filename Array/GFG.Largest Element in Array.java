class Compute {
    
    public int largest(int arr[], int n)
    {
        
        //optimal approach
        if(arr.length==1)
            return arr[0];
        
        int largest=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                largest=arr[i];
            }
            
        }
        
        return largest;
        
    
        
        
        //Brute Force approach
       /* Arrays.sort(arr);
        return arr[n-1];*/
        
    }
}