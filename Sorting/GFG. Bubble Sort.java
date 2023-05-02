********************************************** Bubble Sort ************************************************

class Solution
{
    //Function to sort the array using bubble sort algorithm.
     public static void bubbleSort(int arr[], int n)
    {
        //code here
        for(int i=n-1;i>=0;i--)
        {
            int didSwap=0;
            for(int j=0;j<=i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    //Swap the elements in array
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    didSwap=1;
                }
            }
            if(didSwap==0) break;
        }
    }
}