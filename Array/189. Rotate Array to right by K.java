class Solution {

    public int [] arr_reverse(int[] arr,int start,int end)
    {
        while(start<end) {
            System.out.println(start+" "+end);
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }


    public void rotate(int[] nums, int k) {
        
        int n=nums.length;
        k=k % n;
        arr_reverse(nums,n-k,n-1);
        arr_reverse(nums,0,n-k-1);
        arr_reverse(nums,0,n-1);
    }
}