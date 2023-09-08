1. Optimized solution-


class Solution {
    public void moveZeroes(int[] a) {
         int j=-1;
         int n=a.length;
       
         if (n == 1) {
            return; // No need to modify the array
        }

        for(int i=0;i<n;i++){
            if(a[i]==0){
                j=i;
                break;
            }
        }

        if(j==-1) return ;       

        for(int i=j+1;i<n;i++){
            if(a[i]!=0){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            j++;
            }
        }


    }
}