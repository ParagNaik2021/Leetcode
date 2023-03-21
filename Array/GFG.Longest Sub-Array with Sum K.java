Problem link-https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k


 public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        LinkedHashMap<Long,Integer> map=new LinkedHashMap<>();
        long sum=0;
        int len=0;
        int maxLen=0;
        for(int i =0;i<A.length;i++)
        {
            sum+=A[i];
            if(sum==K)
            {

                maxLen=Math.max(maxLen,i+1);
            }
            long rem=sum-K;
            if(map.get(rem)!=map.get(map.size()-1))
            {
                len=i-map.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            
         //   map.put(sum,i); commented and added inside below if to accomodate zero also

            if(map.get(sum)==map.get(map.size()-1))
            {
            map.put(sum,i);
        }
        }


        return maxLen;
        
        
    }
    
    
}
