class Compute {
    
    public void rotate(int arr[], int n)
    { 
        int temp=arr[n-1];
        for(int i=n-1;i>0;i--)
        {
            arr[i]=arr[i-1];//i=arr[4]=arr[3]--->{1,2,3,4,4}
                            //arr[3]=arr[2]----->{1,2,3,3,4}
                            //arr[2]=arr[1]----->{1,2,2,3,4}
                            //arr[1]=arr[0]----->{1,1,2,3,4}
                        }
        arr[0]=temp;        //arr[0]=5---------->{5,1,2,3,4}
        
        
        
        
        //TC look O(2N)---->ask someone
       /* int [] temp=arr.clone();
        for(int i=0;i<arr.length;i++)
        {
         temp[(i+1)%arr.length]=arr[i];   
        }
        for(int j=0;j<temp.length;j++)
        {
            arr[j]=temp[j];
        }
        */
    }
}