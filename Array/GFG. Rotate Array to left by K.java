class Solution {
    
    public int [] arr_reverse(int[] arr,int start,int end)
    {
        while(start<end) {
           
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    
    void leftRotate(int[] arr, int n, int d) {
        // code here
        
        
       // int n=nums.length;
        d=d % n;
        arr_reverse(arr,d,n-1);//2,1,7,6,5,4,3,
        arr_reverse(arr,0,d-1);
       
       
       
        arr_reverse(arr,0,n-1);
    }
}